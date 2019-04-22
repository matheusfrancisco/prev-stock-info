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
		//em.persist(_user);
        em.getTransaction().begin();
        //em.persist(_user);
		//Query q = em.createQuery("DELETE FROM Users WHERE id = "+_user.getUserid());
		//q.executeUpdate();
    	System.out.println(_plan.getPlanId());
        Plans p1 = em.find(Plans.class,_plan.getPlanId());
        System.out.println(p1);
		//Users uObj = em.find(Users.class, 101);
		em.remove(p1);
        em.getTransaction().commit();
		//factory.close();
		
	}
	
	public void update(Plans _plan) {
		em.getTransaction().begin();
		Plans u1 = em.find(Plans.class, _plan.getPlanId());
		u1.setNumberOfInstallments(9);
		em.merge(u1);
		em.getTransaction().commit();
	}
	
}

