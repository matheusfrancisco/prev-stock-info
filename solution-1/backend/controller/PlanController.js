const db = require('../src/server');
const UserController = require('./UserController.js');
const User = require('../models/User.js');
const Plan = require('../models/Plans.js');
const AccountController = require('./AccountController.js');

class PlanController{

    createPlan(req, res){
        db.query('INSERT INTO Plans SET ?', req.body, (err, results, fields)=>{
            if(err) throw err;
                res.send('Insert plans');
        });
    }

    async joinAtPlan(req, res){
        let cpf = req.body['cpf'];
        let definePlan = {'remainingInstallments' : 36,
                           'numberOfInstallments': 36,
                           'monthsOfGracePeriod': 36,
                           'value_plan': 36000,
                           'payday': '03/02/2019',
                           'id_user': '',
                           'paymentAmount': 1000
                          }

        let user =  User;
        let column = ['nome', 'cpf', 'email', 'endereco', 'balance'];

        UserController.findUser(cpf, user).then(userResult => {
                let jsonUser = {}

            Object.keys(userResult).forEach(userFields =>{
                    jsonUser[userFields.substring(1)] = userResult[userFields]
                });

            definePlan['id_user'] = jsonUser['id']

            db.query('INSERT INTO Plans SET ?', definePlan,(err, results, fields) => {
                if(err) throw err;
                    res.send('ok foi ')
            })

        });

    }

    findPlanById(planId){
        let columns = ['id','remainingInstallments', 'numberOfInstallments','monthsOfGracePeriod', 'value_plan',
                       'id_user', 'paymentAmount'];

        return new Promise((resolve, reject) =>{
        let loadPlan = Plan;

        console.log('my id', planId)
            db.query('SELECT ??  FROM ?? Where id = ?', [columns, 'Plans' ,planId], (err, res)=>{
                if(err) throw err;

                let resultPlanToString = JSON.stringify(res);
                let planJson = JSON.parse(resultPlanToString);

                loadPlan.setIdPlan(planJson[0].id);
                loadPlan.setRemainingInstallments(planJson[0].remainingInstallments);
                loadPlan.setMonthsOfGracePeriod(planJson[0].monthsOfGracePeriod);
                loadPlan.setNumberOfInstallments(planJson[0].numberOfInstallments);
                loadPlan.setValuePlan(planJson[0].value_plan);
                loadPlan.setUserId(planJson[0].id_user);
                console.log('Plan select', loadPlan);
                resolve(loadPlan)
            });
        });
    }

    async updatePlanPaymentDate(planId){

        let PlanControllerToFind = new PlanController();
        let plan = Plan;
        plan = await PlanControllerToFind.findPlanById(planId);
        let value = plan.getRemainingInstallments();

        let newValue = value -1;
        console.log(newValue);

        db.query('UPDATE Plans SET remainingInstallments = ? WHERE id = ?',[newValue,planId], (err,res)=>{
            if(err) throw err;

                console.log(res);
        });
    }

    async findPlanByUserId(idUser){

        return new Promise((resolve, reject)=>{
            let loadPlan = Plan;
            db.query('SELECT *  FROM Plans Where id_user = ?', [idUser], (err, res)=>{
                let resultString = JSON.stringify(res);
                let planJson = JSON.parse(resultString);

                loadPlan.setIdPlan(planJson[0].id);
                loadPlan.setRemainingInstallments(planJson[0].remainingInstallments);
                loadPlan.setMonthsOfGracePeriod(planJson[0].monthsOfGracePeriod);
                loadPlan.setNumberOfInstallments(planJson[0].numberOfInstallments);
                loadPlan.setValuePlan(planJson[0].value_plan);
                loadPlan.setUserId(planJson[0].id_user);
                resolve(loadPlan);
            })
        })
    }

    async cancelPlan(req, res){
        let user = User;
        let plan = Plan;
        let planByUserId = new PlanController();
        await UserController.findUserById(req.body['id_user'], user);
        plan = await planByUserId.findPlanByUserId(req.body['id_user']);

        let valueBalance = user.getBalance();
        if(plan.getRemainingInstallments() > 0){
            let value = ((valueBalance*20)/100);
            await AccountController.withdrawCancelPlan(value, user);
            res.send(`voce cancelou sua conta e o saque foi ${value}`)
        }


    }

}


module.exports = new PlanController();
