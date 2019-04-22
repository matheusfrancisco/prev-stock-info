

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AccountControllerLogic {



	 EntityManagerFactory 		factory ;
	 EntityManager 	    em ;

	 public AccountControllerLogic() {
		 factory =  Persistence.createEntityManagerFactory("Users");
		 em = factory.createEntityManager();
	 }
	 
	 public void salvar(AccountController _trans) {
		 em.persist(_trans);
         em.getTransaction().begin();
		 

		 em.getTransaction().commit();
		 factory.close();
	 }
	 
	public void remover(AccountController _trans) {
		//em.persist(_user);
        em.getTransaction().begin();
        //em.persist(_user);
		//Query q = em.createQuery("DELETE FROM Users WHERE id = "+_user.getUserid());
		//q.executeUpdate();
        AccountController a1 = em.find(AccountController.class, _trans.getIdAccount());
        System.out.println(a1);
		//Users uObj = em.find(Users.class, 101);
		em.remove(a1);
        em.getTransaction().commit();
		//factory.close();
		
	}
	
	public void update(AccountController _trans) {
		em.getTransaction().begin();
		AccountController a1 = em.find(AccountController.class, _trans.getIdAccount());
		//a1.setPayday(Date);
		//em.merge(a1);
		em.getTransaction().commit();
	}
	
	public void getWithdraw(Users _user, Plans _plan) {
		//realiza o saquei.
		//verifica se ele pagou 36 meses.
		//se sim vai para o formulario e realiza o saque
		//se não informa saca 20%
	}
	
	public void payment(Users _user, float value) {
		//realizar pagament
		
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
		String formattedDate = formatter.format(LocalDate.now());
		
		AccountController trans = new AccountController();
		//AccountControllerLogic ac = new AccountControllerLogic();
		PlanController planController = new PlanController();
		
        Plans planUser = em.find(Plans.class, _user.getUserid());
       	
        trans.setIdPlanAccount( planUser.getPlanId());
        trans.setPayValue(value);
        trans.setIdUserAccount(_user.getUserid());
        
        planController.updateParcelas(planUser, planUser.getRemainingInstallments());
                
        
        
        this.salvar(trans);
        

		
		
		//trans.setIdPlanAccount(_plan.getPlanId());
		//trans.setIdUserAccount(_user.getUserid());
		
	
		//gerar um log account
		//
	}
	
	
	public int verificarParcelas(int setRemainingInstallments) {
		if(setRemainingInstallments == 36 ) {
			return 1;
		}else {
			return 2;
		}
	}
	
}

