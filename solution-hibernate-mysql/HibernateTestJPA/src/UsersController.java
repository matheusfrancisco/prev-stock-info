import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsersController {
	

	 EntityManagerFactory 		factory ;
	 EntityManager 	    em ;

	 public UsersController() {
		 factory =  Persistence.createEntityManagerFactory("Users");
		 em = factory.createEntityManager();
	 }
	 
	 public void salvar(Users _user) {
		 em.persist(_user);
         em.getTransaction().begin();
		 

		 em.getTransaction().commit();
		 factory.close();
	 }
	 
	public void remover(Users _user) {
        em.getTransaction().begin();
    	System.out.println(_user.getUserid());
        Users u1 = em.find(Users.class,_user.getUserid());
        System.out.println(u1);
		em.remove(u1);
        em.getTransaction().commit();
		
	}
	
	public void update(Users _user) {
		em.getTransaction().begin();
		Users u1 = em.find(Users.class, _user.getUserid());
		u1.setUsername("joao" + _user.getUserid());
		em.merge(u1);
		em.getTransaction().commit();
	}
	
	
	
	public float getBalance(Users _user) {
		Users u1 = em.find(Users.class, _user.getUserid());
		return u1.getBalance();
	}
	
	public void updateBalance(Users _user, float newBalance) {
		em.getTransaction().begin();
		Users u1 = em.find(Users.class, _user.getUserid());

		u1.setBalance(newBalance);
		em.merge(u1);
		em.getTransaction().commit();
	}
	
	public void getWithdraw(Users _user) {
		//AccountController trans = new AccountController();
		PlanController planController = new PlanController();
        //Plans planUser = em.find(Plans.class, _user.getUserid());
        if(this.validacaoWithdraw(planController.getParcelas(_user)) == 0)
        {
    		System.out.println("Voce nao pode sacar");
    		System.out.println("Pq falta parcelas");
    		

        }else
        {
        	
        	this.formSendEmail(_user);
        	
        }
        
	}
	
   public int validacaoWithdraw(int value) {
	   if(value > 0) {
		   return 0;
	   }else
	   {
		   return 1;
	   }
	   
   }
   
   public void formSendEmail(Users _user) {
	   System.out.println("Voce vai sacar");
	   Users u1 = em.find(Users.class, _user.getUserid());
	   System.out.println(u1.getBalance());
	   
	   //update balance withdraw ok
	   this.updateBalance(u1, 0);

   }
   
  
   
}

