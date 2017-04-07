
 CREATE TABLE status (
 idstatus integer NOT NULL PRIMARY KEY ,
 descricao varchar(45) ,
 PRIMARY KEY (idstatus));

-- CREATE TABLE status (
-- idstatus INT(11) NOT NULL AUTO_INCREMENT,
--  descricao VARCHAR(45) NULL DEFAULT NULL,
--  PRIMARY KEY (idstatus));

-- E/SQLiteLog: (1) near "AUTO_INCREMENT": syntax error
-- D/AndroidRuntime: Shutting down VM
-- E/AndroidRuntime: FATAL EXCEPTION: main
   --               Process: com.example.meupc.controlecotacoes, PID: 3741
     --             java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.meupc.controlecotacoes/com.example.meupc.controlecotacoes.MainActivity}: android.database.sqlite.SQLiteException: near "AUTO_INCREMENT": syntax error (code 1): , while compiling: CREATE TABLE status (
       --             idstatus INT(11) NOT NULL AUTO_INCREMENT,
         --           descricao VARCHAR(45) NULL DEFAULT NULL,
           --         PRIMARY KEY (idstatus));

CREATE TABLE solicitacao (
  idsolicitacao INT(11) NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL DEFAULT NULL,
  telefone VARCHAR(45) NULL DEFAULT NULL,
  dt_ida DATE NULL DEFAULT NULL,
  origem VARCHAR(45) NULL DEFAULT NULL,
  destino VARCHAR(45) NULL DEFAULT NULL,
  dt_volta DATE NULL DEFAULT NULL,
  ida_e_volta CHAR(1) NULL DEFAULT NULL,
  status_id INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (idsolicitacao),
  CONSTRAINT solicitacao_id
    FOREIGN KEY (status_id)
    REFERENCES status (idstatus);