const db = require('../src/server');
const UserController = require('./UserController.js');
const User = require('../models/User.js');
const Plan = require('../models/Plans.js');

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
        let columns = ['remainingInstallments', 'numberOfInstallments','monthsGracePeriod', 'value_plan',
                       'id_user', 'paymentAmount'];
        let Plan = Plan;
        db.query('SELECT Plan FROM ?? Where id = ?', [columns, planId], (err, res)=>{

            console.log('Plan select', res);
        });
    }

    updatePlanPaymentDate(planId){

        let PlanControllerToFind = new PlanController();
        PlanControllerToFind.findPlanById(planId);

        /*db.query('UPDATE Plans SET remainingInstallments = ? WHERE id = ?',[value,planId], (err,res)=>{

        });*/

    }


}


module.exports = new PlanController();
