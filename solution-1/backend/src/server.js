const express = require('express');
const path = require('path');

const app = express();
const cors = require('cors');
app.use(cors());

const server = require('http');
const mysql = require('mysql');


var db = mysql.createConnection({
  host: "127.0.0.1",
  user: "evohc",
  password: "root",
  database: 'stockJs'
})

db.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});

module.exports = db;



app.use(express.json());
app.use(express.urlencoded({extended: true}));

app.use(require('./routes.js'));


app.listen(process.env.PORT || 3333);


