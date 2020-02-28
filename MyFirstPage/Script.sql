--<ScriptOptions statementTerminator=";"/>

CREATE TABLE cn_star (
	cn_star_id VARCHAR(50) NOT NULL,
	cn_user_id VARCHAR(50),
	cn_stars INT,
	PRIMARY KEY (cn_star_id)
) ENGINE=InnoDB;

CREATE TABLE cn_share (
	cn_share_id VARCHAR(100) NOT NULL,
	cn_share_title VARCHAR(500),
	cn_share_body TEXT,
	cn_note_id VARCHAR(100),
	PRIMARY KEY (cn_share_id)
) ENGINE=InnoDB;

CREATE TABLE cn_note_status (
	cn_note_status_id VARCHAR(100) NOT NULL,
	cn_note_status_code VARCHAR(100),
	cn_note_status_name VARCHAR(500),
	PRIMARY KEY (cn_note_status_id)
) ENGINE=InnoDB;

CREATE TABLE cn_user (
	cn_user_id VARCHAR(100) NOT NULL,
	cn_user_name VARCHAR(100),
	cn_user_password VARCHAR(100),
	cn_user_token VARCHAR(100),
	cn_user_nick VARCHAR(100),
	PRIMARY KEY (cn_user_id)
) ENGINE=InnoDB;

CREATE TABLE cn_activity_status (
	cn_activity_status_id VARCHAR(100) NOT NULL,
	cn_activity_id VARCHAR(100),
	cn_activity_status_code VARCHAR(500),
	cn_activity_status_name VARCHAR(500),
	PRIMARY KEY (cn_activity_status_id)
) ENGINE=InnoDB;

CREATE TABLE cn_note_type (
	cn_note_type_id VARCHAR(100) NOT NULL,
	cn_note_type_code VARCHAR(100),
	cn_note_type_name VARCHAR(500),
	cn_note_type_desc TEXT,
	PRIMARY KEY (cn_note_type_id)
) ENGINE=InnoDB;

CREATE TABLE cn_notebook (
	cn_notebook_id VARCHAR(100) NOT NULL,
	cn_user_id VARCHAR(100),
	cn_notebook_type_id VARCHAR(100),
	cn_notebook_name VARCHAR(500),
	cn_notebook_desc TEXT,
	cn_notebook_createtime TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	PRIMARY KEY (cn_notebook_id)
) ENGINE=InnoDB;

CREATE TABLE cn_notebook_type (
	cn_notebook_type_id VARCHAR(100) NOT NULL,
	cn_notebook_type_code VARCHAR(100),
	cn_notebook_type_name VARCHAR(500),
	cn_notebook_type_desc TEXT,
	PRIMARY KEY (cn_notebook_type_id)
) ENGINE=InnoDB;

CREATE TABLE cn_note (
	cn_note_id VARCHAR(100) NOT NULL,
	cn_notebook_id VARCHAR(100),
	cn_user_id VARCHAR(100),
	cn_note_status_id VARCHAR(100),
	cn_note_type_id VARCHAR(100),
	cn_note_title VARCHAR(500),
	cn_note_body TEXT,
	cn_note_create_time BIGINT,
	cn_note_last_modify_time BIGINT,
	PRIMARY KEY (cn_note_id)
) ENGINE=InnoDB;

CREATE TABLE cn_activity (
	cn_activity_id VARCHAR(100) NOT NULL,
	cn_activity_title VARCHAR(500),
	cn_activity_body TEXT,
	cn_activity_end_time BIGINT,
	PRIMARY KEY (cn_activity_id)
) ENGINE=InnoDB;

CREATE TABLE cn_note_activity (
	cn_note_activity_id VARCHAR(100) NOT NULL,
	cn_activity_id VARCHAR(100),
	cn_note_id VARCHAR(100),
	cn_note_activity_up INT,
	cn_note_activity_down INT,
	cn_note_activity_title VARCHAR(500),
	cn_note_activity_body TEXT,
	PRIMARY KEY (cn_note_activity_id)
) ENGINE=InnoDB;

CREATE INDEX FK_Reference_5 ON cn_note_activity (cn_note_id ASC);

CREATE INDEX FK_Reference_2 ON cn_note (cn_notebook_id ASC);

CREATE INDEX FK_Reference_9 ON cn_activity_status (cn_activity_id ASC);

CREATE INDEX FK_Reference_8 ON cn_note (cn_note_type_id ASC);

CREATE INDEX FK_Note_User_Reference ON cn_notebook (cn_user_id ASC);

CREATE INDEX FK_Reference_3 ON cn_note (cn_user_id ASC);

CREATE INDEX FK_Reference_7 ON cn_note (cn_note_status_id ASC);

CREATE INDEX FK_Reference_4 ON cn_note_activity (cn_activity_id ASC);

CREATE INDEX FK_Reference_6 ON cn_notebook (cn_notebook_type_id ASC);

