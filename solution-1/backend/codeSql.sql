CREATE TABLE IF NOT EXISTS User(
    email Varchar(50),
    cpf Varchar(50),
    idUser int PRIMARY KEY,
    name Varchar(50),
    address Varchar(50),
);

CREATE TABLE IF NOT EXISTS Account(
    balance float,
    idAccount int PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Plan(
    remainingInstallments number,
    numberOfInstallments number,
    payday Date,
    idPlan int PRIMARY KEY,
    startDateUser Date
);

CREATE TABLE IF NOT EXISTS PortabilityPlan(
    paymentAmount float,
    idPortabilityPLan int,
    monthsOfGracePeriod number,
    fk_Plan_idPlan int,
    PRIMARY KEY( idPortabilityPlan, fk_Plan_idPlan )
);

CREATE TABLE IF NOT EXISTS SupplementaryPensionPlan(
    monthsOfGracePeriod number,
    paymentAmount float,
    idSupplementaryPensionPlan int,
    fk_Plan_idPlan int,
    PRIMARY KEY(idSupplementaryPensionPlan, fk_Plan_idPlan)
);

CREATE TABLE IF NOT EXISTS InsuranceCompany(
    idInsuranceCompanyPlan int,
    monthsOfGracePeriod number,
    pyamentAmount float,
    fk_Plan_idPlan int,
    PRIMARY KEY (idInsuranceCompanyPLan, fk_Plan_idPlan)
);

CREATE TABLE IF NOT EXISTS AccountControllerUserAccountPlan(
    fk_User_idUser int,
    fk_Account_idAccount int,
    fk_Plan_idPlan int
);

ALTER TABLE PortabilityPlan ADD CONSTRAINT FK_PortabilityPlan_2
    FOREIGN KEY(fk_Plan_idPlan)
    REFERENCES Plan(idPlan)
    ON DELETE CASCADE;

ALTER TABLE SupplementaryPensionPlan ADD CONSTRAINT FK_SupplementaryPensionPlan_2
    FOREIGN KEY(fk_Plan_idPlan)
    REFERENCES Plan(idPlan)
    ON DELETE CASCADE;

ALTER TABLE AccountControllerUserAccountPlan ADD CONSTRAINT FK_AccountControllerUserAccountPlan_1
    FOREIGN KEY(fk_User_idUser)
    REFERENCES User (idUser)
    ON DELETE RESTRICT;

ALTER TABLE AccountControllerUserAccountPlan ADD CONSTRAINT FK_AccountControllerUserAccountPlan_2
    FOREIGN KEY(fk_Account_idAccount)
    REFERENCES Account (idAccount)
    ON DELETE NO ACTION;

ALTER TABLE AccountControllerUserAccountPlan ADD CONSTRAINT FK_AccountControllerUserAccountPlan_3
    FOREIGN KEY (fk_Plan_idPlan)
    REFERENCES Plan (idPlan)
    ON DELETE NO ACTION;

