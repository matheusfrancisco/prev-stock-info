
const database = require('./database');

class Client{
    constructor(){
        this._name;
        this._cpf;
        this._idUser;
        this._address;
    }
    setClientName(value){
        this._name = value;
    }
    
    getClientName(){
        return this._name;
    }
    
    setClientCPF(value){
        this._cpf = value;
    }

    getClientCPF(){
        return this._cpf;
    }

    setAddress(value){
        this._address = value;
    }

    insert(req, res){
        database.insertInto(req.body);
        //res.send();
    }


}

module.exports = new Client();