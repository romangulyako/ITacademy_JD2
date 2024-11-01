CREATE TABLE people.person
  (id INT NOT NULL AUTO_INCREMENT,
  age INT NOT NULL,
  salary DOUBLE NULL,
  passport CHAR(10) NOT NULL,
  address VARCHAR(200) NULL,
  dateOfBirthday DATE NOT NULL,
  dateTimeCreate DATETIME NOT NULL,
  timeToLunch TIME NULL,
  letter TEXT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
  UNIQUE INDEX passport_UNIQUE (passport ASC) VISIBLE);