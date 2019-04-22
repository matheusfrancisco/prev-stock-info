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
		//em.persist(_user);
        em.getTransaction().begin();
        //em.persist(_user);
		//Query q = em.createQuery("DELETE FROM Users WHERE id = "+_user.getUserid());
		//q.executeUpdate();
    	System.out.println(_user.getUserid());
        Users u1 = em.find(Users.class,_user.getUserid());
        System.out.println(u1);
		//Users uObj = em.find(Users.class, 101);
		em.remove(u1);
        em.getTransaction().commit();
		//factory.close();
		
	}
	
	public void update(Users _user) {
		em.getTransaction().begin();
		Users u1 = em.find(Users.class, _user.getUserid());
		u1.setUsername("joao" + _user.getUserid());
		em.merge(u1);
		em.getTransaction().commit();
	}
	
	
	
	public float getBalance(Users _user) {
		return _user.getBalance();
	}
	
	public void updateBalance(Users _user, float newBalance) {
		em.getTransaction().begin();
		Users u1 = em.find(Users.class, _user.getUserid());
		u1.setBalance(newBalance);
		em.merge(u1);
		em.getTransaction().commit();
	}
}

