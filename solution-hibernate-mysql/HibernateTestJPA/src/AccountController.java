
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccountController")

public class AccountController {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="pay_value")
	private float pay_value;
	
	@Column(name = "payday")
	private Date payday;
	
	@Column(name = "id_user")
	private int id_user;
	
	@Column(name= "id_plan")
	private int id_plan;

	public int getIdAccount() {
		return id;
	}
	
	public void setIdAccount(int id) {
		this.id = id;
	}
	public float getPayValue() {
		return pay_value;
	}
	public void setPayValue(float pay_value) {
		this.pay_value = pay_value;
	}
	
	public Date getPayday() {
		return payday;
	}
	
	public void setPayday(Date payday) {
		this.payday = payday;
	}
	
	public int getIdUserAccount() {
		return id_user;
	}
	
	public void setIdUserAccount(int id_user) {
		this.id_user = id_user;
	}
	
	public int getIdPlanAccount() {
		return id_plan;
	}
	
	public void setIdPlanAccount(int id_plan) {
		this.id_plan =id_plan;
	}
	
	
}
