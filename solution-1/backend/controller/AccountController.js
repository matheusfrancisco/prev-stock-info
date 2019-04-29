const UserController = require('./UserController');
const User = require('../models/User');
const PlanController = require('./PlanController');
const Plan = require('../models/Plans');

const db = require('../src/server');

class AccountController{

    async makePayment(req, res){

        db.query('INSERT INTO AccountController SET ?', req.body,async (err, res, fields)=>{
            if(err) throw err;

            let user = User;
            await UserController.findUserById(req.body['id_user'], user)
            let userJson ={};

            Object.keys(user).forEach(userFields =>{
                userJson[userFields.substring(1)] = user[userFields];
            });

                console.log(userJson, 'user');


            await UserController.updateBalance(userJson, req.body['pay_value']);
            await PlanController.updatePlanPaymentDate(req.body['id_plan'], res);

            console.log('passou')
            //res.send('Payment ok and updates');

        });
        res.send('Payment and updates ok')
    }

    async withdrawBalance(req, res){

        let user = User;
        await UserController.findUser(req.body['cpf'], user);
        let plan = Plan;
        plan = await PlanController.findPlanByUserId(user.getUserId());

        console.log(plan.getRemainingInstallments());
        console.log(user.getBalance());
        //verificacoes

        if(plan.getRemainingInstallments() > 0){
            res.send('Falta parcelas');
        }else{
            await UserController.updateBalanceWithdraw(user);
            res.send('Saque concluido');
        }
    }

    async withdrawCancelPlan(value, user){
        await UserController.updateBalanceWithdrawCancel(value, user);
    }
}


module.exports = new AccountController();
