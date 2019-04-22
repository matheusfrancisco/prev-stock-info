import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PlanController {
	

	 EntityManagerFactory 		factory ;
	 EntityManager 	    em ;

	 public PlanController() {
		 factory =  Persistence.createEntityManagerFactory("Users");
		 em = factory.createEntityManager();
	 }
	 
	 public void salvar(Plans _plan) {
		 em.persist(_plan);
         em.getTransaction().begin();
		 

		 em.getTransaction().commit();
		 factory.close();
	 }
	 
	public void remover(Plans _plan) {
        em.getTransaction().begin();

    	System.out.println(_plan.getPlanId());
        Plans p1 = em.find(Plans.class,_plan.getPlanId());
		em.remove(p1);
        em.getTransaction().commit();
		
	}
	
	public void update(Plans _plan) {
		em.getTransaction().begin();
		Plans u1 = em.find(Plans.class, _plan.getPlanId());
		u1.setNumberOfInstallments(9);
		em.merge(u1);
		em.getTransaction().commit();
	}
	
	public void updateParcelas(Plans _plan, int number) {
		em.getTransaction().begin();
		Plans u1 = em.find(Plans.class, _plan.getPlanId());
		u1.setRemainingInstallments(number-1);
		em.merge(u1);
		em.getTransaction().commit();
	}
	
	public int getParcelas(Users _user) {
        Plans planUser = em.find(Plans.class, _user.getUserid());
        return planUser.getRemainingInstallments();
 
	}
	
	 public void cancelPlan(Users _user) {
	      Plans planUser = em.find(Plans.class, _user.getUserid());
	      UsersController usersControllerToGetBalance = new UsersController();
	      float valueBalance = usersControllerToGetBalance.getBalance(_user);
	      
	      System.out.println("Sua conta vai ser cancelada");
	      float yourValueToWithdrawIs = (valueBalance/100)*20;
	      System.out.println(yourValueToWithdrawIs);
	     
	  }
	
}

