					 
CREATE TABLE eip_populate_record  ( 
	id  	int(11) AUTO_INCREMENT NOT NULL,
	related_open_mrs_record_id	    int(11) NOT NULL,
	related_open_mrs_record_uuid    char(38) NOT NULL,
	related_open_mrs_record_table   varchar(100) NOT NULL,
	related_open_mrs_record_date    datetime NOT NULL,
	user_name varchar(255) NOT NULL,
	operation varchar(255) NOT NULL,
	locked            	tinyint(1) NOT NULL DEFAULT '0',
    creation_date      	datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	PRIMARY KEY(id) USING BTREE
)
ENGINE = InnoDB;