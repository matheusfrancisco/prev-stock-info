

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
	
}

