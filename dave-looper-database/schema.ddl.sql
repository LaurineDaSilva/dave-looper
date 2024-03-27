DROP TABLE IF EXISTS 
	t_skills, t_developers, t_accounts, t_languages, t_roles;

CREATE TABLE t_languages (
	id serial,
	code char(5) NOT NULL,
	"name" varchar(50) NOT NULL,
	CONSTRAINT t_languages_pkey PRIMARY KEY (id),
	CONSTRAINT t_languages_code_ukey UNIQUE (code)
);

CREATE TABLE t_roles (
	id serial,
	code varchar(20) NOT NULL,
	"name" varchar(50) NOT NULL,
	CONSTRAINT t_roles_pkey PRIMARY KEY (id),
	CONSTRAINT t_roles_code_ukey UNIQUE (code)
);

CREATE TABLE t_accounts (
	id serial,
	username varchar(255) NOT NULL,
	"password" char(60) NOT NULL,
	role_id integer NOT NULL,
	CONSTRAINT t_accounts_pkey PRIMARY KEY (id),
	CONSTRAINT t_accounts_username_ukey UNIQUE (username),
	CONSTRAINT t_accounts_t_roles_fkey
		FOREIGN KEY (role_id)
		REFERENCES t_roles (id)
);

CREATE TABLE t_developers (
	id serial,
	registration_number char(7) NOT NULL,
	firstname varchar(200) NOT NULL,
	lastname varchar(200) NOT NULL,
	account_id integer NOT NULL,
	CONSTRAINT t_developers_pkey PRIMARY KEY (id),
	CONSTRAINT t_developers_registration_number_ukey UNIQUE (registration_number),
	CONSTRAINT t_developers_account_id_ukey UNIQUE (account_id),
	CONSTRAINT t_developers_t_accounts_fkey
		FOREIGN KEY (account_id)
		REFERENCES t_accounts (id)
);

CREATE TABLE t_skills (
	id serial,
	developer_id integer NOT NULL,
	language_id integer NOT NULL,
	"level" varchar(12) NOT NULL,
	CONSTRAINT t_skills_pkey PRIMARY KEY (id),
	CONSTRAINT t_skills_developer_language_ukey UNIQUE (developer_id, language_id),
	CONSTRAINT t_skills_t_developers_fkey
		FOREIGN KEY (developer_id)
		REFERENCES t_developers (id),
	CONSTRAINT t_skills_t_languages_fkey
		FOREIGN KEY (language_id)
		REFERENCES t_languages (id)
);
