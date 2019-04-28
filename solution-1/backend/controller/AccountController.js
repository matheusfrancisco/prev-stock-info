const UserController = require('./UserController');
const User = require('../models/User');
const PlanController = require('./PlanController');

const db = require('../src/server');

class AccountController{

    async makePayment(req, res){

        db.query('INSERT INTO AccountController SET ?', req.body,async (err, res, fields)=>{
            if(err) throw err;

                let user = User;
                UserController.findUserById(req.body['id_user'], user).then(userResult =>{

                    let userJson ={};
                    Object.keys(userResult).forEach(userFields =>{
                        userJson[userFields.substring(1)] = userResult[userFields];

                    });

                    console.log(userJson);
                    UserController.updateBalance(userJson, req.body['pay_value']);
                    PlanController.updatePlanPaymentDate(req.body['id_plan']);


                });


        })
        console.log(req.body);

    }
}


module.exports = new AccountController();
