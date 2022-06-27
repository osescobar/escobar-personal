-----------------------
CREATE database mydb;
USE mydb ;

-- -----------------------------------------------------
-- Table `mydb`.`Ciudades`
-- -----------------------------------------------------
CREATE TABLE  Ciudades (
  id INT NOT NULL,
  nombre_ciudad VARCHAR(45) NULL,
  codigo_ciudad VARCHAR(45) NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table `mydb`.`Departamentos`
-- -----------------------------------------------------
CREATE TABLE Departamentos (
  id INT NOT NULL,
  departamento_codigo VARCHAR(45) NULL,
  nombre_departamento VARCHAR(45) NULL,
  fecha_hora_crea DATE NULL,
  fecha_hora_modifica VARCHAR(45) NULL,
  fk_Ciudades_id INT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (fk_Ciudades_id)
    REFERENCES Ciudades (id)
    );


-- -----------------------------------------------------
-- Table `mydb`.`Empleados`
-- -----------------------------------------------------
CREATE TABLE  Empleados (
  id INT NOT NULL,
  tipo_empleados VARCHAR(45) NULL,
  numero_documento INT NULL,
  nombres VARCHAR(45) NULL,
  apellidos VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  correo_electronico VARCHAR(45) NULL,
  telefono INT NULL,
  fecha_hora_crea DATE NULL,
  fecha_hora_modifica DATE NULL,
  fk_departamentos_id INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (fk_departamentos_id)
    REFERENCES Departamentos (id));








