const User = require('../models/User.js')
const db = require('../src/server.js');


class UserController{

    insertUser(req, res){

        //let querySql = `INSERT INTO Users (email, cpf, id , senha, nome, endereco, balance) VALUES (${req.body['email']}, ${req.body['cpf']}, ${req.body['cpf']}, ${req.body['id']},${req.body['senha']}, ${req.body['nome']},${req.body['endereco']}, ${0})`;
        var query = db.query('INSERT INTO Users SET ?', req.body, (error, results, fields) => {
    	    if (error) throw error;
            res.send('User insert');
    	});
    }


    async findUser(cpf , user){

        let columns = ['id', 'nome', 'cpf', 'email', 'endereco', 'balance'];
        return new Promise((resolve, reject) =>{

        db.query('SELECT ?? FROM ?? Where cpf = ?', [columns, 'Users', cpf], (err, results, fields)=>{

            if(err) throw err;
            let resultString = JSON.stringify(results);

            let userJson = JSON.parse(resultString);

            console.log(userJson[0])
            user.setUserName(userJson[0].nome);
            user.setCpf(userJson[0].cpf);
            user.setEndereco(userJson[0].endereco);
            user.setEmail(userJson[0].email);
            user.setUserId(userJson[0].id);
            user.setBalance(userJson[0].balance);

            resolve(user);
           });
        });

    }

    async findUserById(id , user){

        let columns = ['id', 'nome', 'cpf', 'email', 'endereco', 'balance'];
        return new Promise((resolve, reject) =>{

        db.query('SELECT ?? FROM ?? Where id = ?', [columns, 'Users', id], (err, results, fields)=>{

            if(err) throw err;
            let resultString = JSON.stringify(results);

            let userJson = JSON.parse(resultString);

            console.log(userJson[0])
            user.setUserName(userJson[0].nome);
            user.setCpf(userJson[0].cpf);
            user.setEndereco(userJson[0].endereco);
            user.setEmail(userJson[0].email);
            user.setUserId(userJson[0].id);
            user.setBalance(userJson[0].balance);

            resolve(user);
           });
        });

    }


    updateBalance(user, valuePayment){
        let newValue;
        if(user['balance'] == null){
            newValue = 0 + valuePayment;
        }else{
            newValue = user['balance'] + valuePayment;
        }
            db.query('UPDATE Users SET balance = ? WHERE id = ?', [newValue, user['id']], (err, res) =>{
                if(err) throw err;
            });
    }

    updateBalanceWithdraw(user){
        console.log(user)
        db.query('UPDATE Users SET balance = ? WHERE id = ?',[0, user.getUserId()], (err,res)=>{
            if(err) throw err;

        });
    }

    updateBalanceWithdrawCancel(value, user){
        db.query('UPDATE Users SET balance = ? WHERE id = ?',[user.getBalance() - value, user.getUserId()], (err,res)=>{
            if(err) throw err;

        });

    }

}


module.exports = new UserController();
