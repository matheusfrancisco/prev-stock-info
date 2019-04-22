
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")

public class Users{
	 
    @Id
    @Column(name = "id")
    private int id;
 
    @Column(name = "nome")
    private String nome;
 
    @Column(name = "senha")
    private String senha;
 
    @Column(name = "endereco")
    private String endereco;
    
    @Column(name = "email")
    private String email;
    
    @Column(name ="balance")
    private float balance;
    
    @Column(name = "cpf")
    private String cpf;
 
    public int getUserid() {
        return id;
    }
 
    public void setUserid(int id) {
        this.id = id;
    }
 
    public String getUsername() {
        return nome;
    }
 
    public void setUsername(String nome) {
        this.nome = nome;
    }
    
    public String getSenha() {
    	return senha;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }
    
    public String getCpf() {
    	return cpf;
    }
    
    public void setCpf(String cpf) {
    	this.cpf = cpf;
    }
    
    public String getEndereco() {
        return endereco;
    }
 
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public float getBalance() {
        return balance;
    }
 
    public void setBalance(float balance) {
        this.balance = balance;
    }
}