const sqlite = require('sqlite3').verbose();

class DatabaseController{
    constructor(){
    }

    startDatabase(databaseFilePath){

        this.database = new sqlite.Database(databaseFilePath, (err)=>{
            if(err) console.log('err');
            else{
                console.log('connected to database');
            }
        });
    }

   async createTableInDatabase(sql){
        await this.database.run(sql, (err)=>{
            if(err){
                return console.error(err.message);
            }
            console.log(`create ok`)
        });
    this.database.close();
    }


}

module.exports = new DatabaseController();
