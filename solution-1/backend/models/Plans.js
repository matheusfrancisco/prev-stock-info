
class Plans{
    constructor(){
        this._id;
        this._remainingInstallments;
        this._numberOfInstallments;
        this._monthsOfGracePeriod;
        this._valuePlan;
        this._idUser;
        this._paymentAmount;
        this._payday;
        this._startDateUser;

    }

    setIdPlan(id){
        this._id = id;
    }

    getIdPlan(){
        return this._id;
    }

    setRemainingInstallments(remaingInstallments){
        this._remainingInstallments = remaingInstallments;
    }

    getRemainingInstallments(){
        return this._remainingInstallments;
    }

    setMonthsOfGracePeriod(monthsOfGracePeriod){
        this._monthsOfGracePeriod = monthsOfGracePeriod;
    }

    getMonthsOfGracePeriod(){
        return this._monthsOfGracePeriod;
    }


    setNumberOfInstallments(numberOfInstallments){
        this._numberOfInstallments = numberOfInstallments;
    }

    getNumberOfInstallments(){
        return this._numberOfInstallments;
    }

    setValuePlan(valuePlan){
        this._valuePlan;
    }

    getValuePlan(){
        return this._valuePlan;
    }

    setUserId(idUser){
        this._idUser = idUser;
    }

    getUserId(){
        return this._idUser;
    }

    setPaymentAmount(paymentAmount){
        this._paymentAmount = paymentAmount;
    }

    getPaymentAmount(){
        return this._paymentAmount;
    }

    setPayday(payday){
        this._payday = payday;
    }

    getPayday(){
        return this._payday;
    }

    setStartDateUser(startDateUser){
        this._startDateUser = startDateUser;
    }

    getStartDateUser(){
        return this._startDateUser;
    }

}

module.exports = new Plans();
