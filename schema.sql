-- Optional: the JSP pages create all of this automatically on first run.
CREATE DATABASE IF NOT EXISTS asg30_db;
USE asg30_db;

CREATE TABLE IF NOT EXISTS employee (
    emp_id      INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100)  NOT NULL,
    department  VARCHAR(100)  NOT NULL,
    designation VARCHAR(100)  NOT NULL,
    salary      DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS patient (
    patient_id       INT AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    age              INT          NOT NULL,
    disease          VARCHAR(150) NOT NULL,
    treatment_status VARCHAR(30)  NOT NULL
);
