var express = require('express');
var router = express.Router();
const DatabaseController = require('../models/database.js');
const path = require('path');
const Client = require('../models/Client');
/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

//router.get('/createDatabase', DatabaseController.startDatabase);
//router.get('/createTables', DatabaseController.createTableInDatabase);
router.post('/insert', Client.insert);

module.exports = router;
