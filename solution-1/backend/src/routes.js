
const express = require('express');
const routes = express.Router();
const UserController = require('../controller/UserController');
const PlanController = require('../controller/PlanController');
const AccountController = require('../controller/AccountController');

//Users Routes
routes.post('/insert', UserController.insertUser);
//routes.post('/edit', UserController.editUser);
routes.post('/joinAtPlan', PlanController.joinAtPlan);


//Plans Routes

routes.post('/createPlan', PlanController.createPlan);

// AccountController

routes.post('/makePayment', AccountController.makePayment);

module.exports = routes;