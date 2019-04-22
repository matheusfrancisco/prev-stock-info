import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Teste {
	public static void main(String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
   			/*
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
			AccountController a1 = new AccountController();
			a1.setIdAccount(1);
			//a1.setPayday();
			a1.setPayValue(100);
			a1.setIdPlanAccount(1);
			a1.setIdUserAccount(101);
			
			AccountControllerLogic ac = new AccountControllerLogic();
			
			ac.salvar(a1);
			
	       System.out.println("..............\n");

        }
	
}
