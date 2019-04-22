import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Teste {
	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
   			/*
   			 * test implementation
            Users u1 = new Users();
            
            u1.setUserid(2);
            u1.setUsername("Editor " + 2);
            u1.setBalance(0);
            u1.setSenha("adfasf");
            u1.setEndereco("end");
            u1.setEmail("ahhahahah" +2 );
            u1.setCpf("123131231" + 2);
           
            */
            //UsersController con = new UsersController();
            //con.salvar(u1);
            //con.remover(u1);
            //con.update(u1);

			/*Plans p1 = new Plans();
			p1.setIdUser(101);
			p1.setNumberOfInstallments(36);
			//p1.setPayday(new Date(0).getDate());
	        p1.setPlanId(1);
	        p1.setPaymentAmount(100);
	        p1.setMonthsOfGracePeriod(36);
	        p1.setRemainingInstallments(36);
	        p1.setValuePlan(3600);
	        
	        PlanController pla= new PlanController();
	        pla.salvar(p1);
	        */
			/*
			AccountController a1 = new AccountController();
			a1.setIdAccount(1);
			//a1.setPayday();
			a1.setPayValue(100);
			a1.setIdPlanAccount(1);
			a1.setIdUserAccount(101);
			
			AccountControllerLogic ac = new AccountControllerLogic();
			
			ac.salvar(a1);*/
			//DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
			//String formattedDate = formatter.format(LocalDate.now());
			//System.out.println(LocalDate.now());

			Users user1 = new Users();
		    
			user1.setUserid(1);
			user1.setUsername("Matheus ");
			user1.setBalance(0);
		    user1.setSenha("teste");
		    user1.setEndereco("Endereço");
		    user1.setEmail("matheusfrancisco@hotmail.com" );
		    user1.setCpf("41819714810");
		    /*
		    UsersController con = new UsersController();
		    con.salvar(user1);
		    
		    Plans plan1 = new Plans();
		    plan1.setIdUser(1);
		    plan1.setNumberOfInstallments(36);
			//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			//LocalDate localDate = LocalDate.now();

			//plan1.setPayday(localDate);
			plan1.setPlanId(1);
			plan1.setPaymentAmount(100);
			plan1.setMonthsOfGracePeriod(36);
			plan1.setRemainingInstallments(36);
			plan1.setValuePlan(3600);
	        
	        PlanController pla= new PlanController();
	        pla.salvar(plan1);
	        */
	       /* AccountController account1 = new AccountController();
	        account1.setIdAccount(1);
	        account1.setPayValue(100);
			account1.setIdPlanAccount(1);
			account1.setIdUserAccount(1);
			*/
			//AccountControllerLogic ac = new AccountControllerLogic();
			
			//ac.salvar(account1);
			
			//make a payment
			
			//ac.payment(user1, 100);
	        
	      //make a withdraw
		   //UsersController con = new UsersController();

		   // con.updateBalance(user1, 3600);
		    
		   //cancel plan
		   PlanController planCon  = new PlanController();
		   planCon.cancelPlan(user1);
		    
		   
		   
	    System.out.println("..............\n");

        }
	
}
