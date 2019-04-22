# Implementação utilizando Hibernate + Mysql



Nesta solução foi implementado um simples sistema para tentar manter os registros
dos usuarios com seus respectivos planos de previdência.


### Banco de dados utilizado MySQL e SQL code

Segue um simples código SQL para  realizar a implementação das classes em Java
Gerar um banco de dados com o nome stockinfo
```
CREATE TABLE IF NOT EXISTS Users(
    email Varchar(50),
    cpf Varchar(50) NOT NULL ,
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    senha varchar(50) NOT NULL,
    nome Varchar(50),
    endereco Varchar(50),
    balance DECIMAL(10, 2),
    PRIMARY KEY (id),
    UNIQUE KEY (cpf),
    UNIQUE KEY (email)
);


CREATE TABLE IF NOT EXISTS Plans(
    remainingInstallments integer,
    numberOfInstallments integer,
    monthsOfGracePeriod integer,
    value_plan Decimal(10,2), 
    id_user int unsigned,
    paymentAmount Decimal(10,2),
    payday Date,
    id int UNSIGNED NOT NULL AUTO_INCREMENT ,
    PRIMARY KEY (id),
    startDateUser Date,
    FOREIGN KEY(id_user) REFERENCES Users(id)
);



CREATE TABLE IF NOT EXISTS AccountController(
    pay_value DECIMAL(10,2),
    payday Date,
    id int UNSIGNED NOT NULL AUTO_INCREMENT ,
    id_user int unsigned,
    id_plan int unsigned, 
    FOREIGN KEY(id_user) REFERENCES Users(id),
    FOREIGN KEY(id_plan) REFERENCES Plans(id),
    PRIMARY KEY(id)

)


```


## Implementação 

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="1.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_1_0.xsd">
    <persistence-unit name="Users" transaction-type="RESOURCE_LOCAL"> 
    	<provider>org.hibernate.ejb.HibernatePersistence</provider> 
        <properties>
       		<property name="hibernate.archive.autodetection" value="class" />
       		 
            <!-- Conexão com o banco de dados -->
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5InnoDBDialect" />
			<property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver" />
			<property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/stockinfo" />
			<property name="hibernate.connection.user" value="COLOCAR SEU LOGIN" />
			<property name="hibernate.connection.password" value="COOCAR SUA SENHA" />
<!--             <property name="hibernate.hbm2ddl.auto" value="create" /> -->
            <property name="hibernate.hbm2ddl.auto" value="update"/>
 
            <!--Configuracoes de Debug-->
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
			<property name="use_sql_comments" value="true" />
			
		</properties>
    </persistence-unit>
</persistence>

```



