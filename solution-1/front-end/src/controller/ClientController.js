

class ClientController{
    constructor(){

        this.formElement = document.getElementById('form-user-create');
        this.onSubmit();
    }


    getValues(formElement) {

        let user = {};
        let isValid = true;
        [...formElement.elements].forEach((field, index) => {
            if (['name', 'email', 'password'].indexOf(field.name) > -1 && !field.value) {
                //field.parentElement.classList.add('has-error');
                isValid = false;

            }
            else {
                user[field.name] = field.value;
            }

        });

    }

    onSumbit(){
        this.formElement.addEventListener("submit" ,(event)=>{
            event.preventDefault();
            let btn = this.formElement.querySelector("[type=submit]");
            btn.disabled = true;
            let values = this.getValues(this.formElement);
            if (!values) {
                return false;
            }
            console.log(values);

        });
    }

}



