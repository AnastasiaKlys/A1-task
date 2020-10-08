DROP SCHEMA

IF EXISTS a1;
	CREATE SCHEMA a1 COLLATE = utf8_general_ci;

USE a1;

CREATE TABLE logins (
	login_id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT,
	application VARCHAR(40),
	app_account_name VARCHAR(50),
	is_active BOOLEAN NOT NULL,
	job_title VARCHAR(50) NOT NULL,
	department VARCHAR(50) NOT NULL,
	PRIMARY KEY (login_id)
	);
    
    CREATE TABLE postings (
	posting_id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT,
	mat_doc VARCHAR(20),
	item VARCHAR(20),
	doc_date VARCHAR(20),
    pstng_date VARCHAR(20),
	material_description VARCHAR(255), 
	quantity VARCHAR(20),
	bun VARCHAR(20),
    amount_lc VARCHAR(25),
    crcy VARCHAR(10),
    user_name VARCHAR(40),
    authorized_delivery  BOOLEAN,
	PRIMARY KEY (posting_id)
	);
    
    COMMIT;