
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Plans")

public class Plans {
	@Id
    @Column(name = "id")
    private int id;
 
    @Column(name = "remainingInstallments")
    private int remainingInstallments;
 
    @Column(name = "numberOfInstallments")
    private int numberOfInstallments;
 
    @Column(name = "monthsOfGracePeriod")
    private int monthsOfGracePeriod;
    
    @Column(name = "value_plan")
    private float value_plan;
    
    @Column(name = "id_user")
    private int id_user;
    
    @Column(name ="paymentAmount")
    private float paymentAmount;
    
    @Column(name = "payday")
    private LocalDate payday;
    
    @Column(name= "startDateUser")
    private Date startDateUser;
    
    public int getPlanId() {
        return id;
    }
 
    public void setPlanId(int id) {
        this.id = id;
    }
    
    public int getRemainingInstallments() {
        return remainingInstallments;
    }
 
    public void setRemainingInstallments(int remainingInstallments) {
        this.remainingInstallments = remainingInstallments;
    }
    
    public int getNumberOfInstallments() {
    	return numberOfInstallments;
    }
    
    public int getMonthsOfGracePeriod() {
    	return monthsOfGracePeriod;
    }
    
    public void setMonthsOfGracePeriod(int monthsOfGracePeriod) {
    	this.monthsOfGracePeriod =monthsOfGracePeriod;
    }
    
    public void setNumberOfInstallments(int numberOfInstallments)
    {
    	this.numberOfInstallments = numberOfInstallments;
    }
    
    public float getValuePlan() {
    	return value_plan;
    }
    
    public void setValuePlan(float value_plan) {
    	this.value_plan = value_plan;
    }
    
    public int getIdUser() {
    	return id_user;
    }
	
    public void setIdUser(int id_user) {
    	this.id_user = id_user;
    }
    
    public float getPaymentAmount() {
    	return paymentAmount;
    }
    public void setPaymentAmount(float paymentAmount) {
    	this.paymentAmount = paymentAmount;
    }
    public LocalDate getPayday() {
    	return payday;
    }
    
    public void setPayday(LocalDate localDate) {
    	this.payday = localDate;
    }
    
    public Date getStartDateUser() {
    	return startDateUser;
    }
    public void setStartDateUser(Date startDateUser) {
    	this.startDateUser = startDateUser;
    }
    
}
