const db = require('../src/server');


class User{
    constructor(){
        this._name;
        this._cpf;
        this._email;
        this._password;
        this._id;
        this._balance;
        this._endereco;
    }

    getUserName(){
        return this._name;
    }

    setUserName(name){
        this._name = name;
    }

    getCpf(){
        return this._cpf;
    }

    setCpf(cpf){
        this._cpf = cpf;
    }

    setEmail(email){
        this._email = email;
    }

    setEndereco(endereco){
        this._endereco = endereco;
    }

    getEndereco(){
        return this._endereco;
    }

    getEmail(){
        return this._email;
    }

    setPassword(password){
        this._password = password;
    }

    getPassword(){
        return this._password;
    }

    setBalance(balance){
        this._balance = balance;
    }

    getBalance(){
        return this._balance;
    }

   setUserId(id){
        this._id = id;
   }

    
   getUserId(){
        return this._id;
   }
}


module.exports = new User();
