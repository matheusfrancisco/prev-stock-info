const sqlite3 = require('sqlite3');
const path = require('path');
const database = new sqlite3.Database(`${path.resolve()}/database.db`)
const fs = require('fs');
const Promise = require('bluebird');


class DatabaseController{
    constructor(){
	//this.database = `${path.resolve()}/database.db`;
	
    }

   insertInto(valuesToInsert){
       console.log(valuesToInsert)
       database.run('INSERT INTO User(email, cpf, idUser,name,address) VALUES(?,?,?,?,?)', [valuesToInsert['email'], valuesToInsert['cpf'],  
       valuesToInsert['idUser'], valuesToInsert['name'],valuesToInsert['address']],(err)=>{
                if(err){ console.log('err')}
        });
   }


}

module.exports = new DatabaseController();
