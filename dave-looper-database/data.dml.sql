DELETE FROM t_skills;
DELETE FROM t_developers;
DELETE FROM t_accounts;
DELETE FROM t_languages;
DELETE FROM t_roles;

INSERT INTO t_languages (code, "name") VALUES 
	('CD001', 'Java'), ('CD002', 'JavaScript'), ('CD003', 'HTML');

INSERT INTO t_roles (code, "name") VALUES 
	('ROLE_DEV', 'Developer'), ('ROLE_MODERATOR', 'Moderator');
	
INSERT INTO t_accounts (username, "password", role_id) VALUES 
	('toto@domain.com', '$2a$12$Ya5Ah0.3BSj809H14XuUtu1gsQup2u3bLCWzk1fSfMf765WuzWWla', (SELECT id FROM t_roles r WHERE r.code = 'ROLE_DEV')),
	('foo@domain.com', '$2a$12$Ya5Ah0.3BSj809H14XuUtu1gsQup2u3bLCWzk1fSfMf765WuzWWla', (SELECT id FROM t_roles r WHERE r.code = 'ROLE_MODERATOR'));

INSERT INTO t_developers (registration_number, firstname, lastname, account_id) VALUES 
	('a411665', 'Toto', 'DUPONT', (SELECT id FROM t_accounts a WHERE a.username = 'toto@domain.com')),
	('a215698', 'Foo', 'DURAND', (SELECT id FROM t_accounts a WHERE a.username = 'foo@domain.com'));

INSERT INTO t_skills (developer_id, language_id, "level") VALUES 
	((SELECT id FROM t_developers d WHERE d.registration_number = 'a411665'), (SELECT id FROM t_languages l WHERE l.code = 'CD001'), 'NOOB'),
	((SELECT id FROM t_developers d WHERE d.registration_number = 'a411665'), (SELECT id FROM t_languages l WHERE l.code = 'CD002'), 'APPRENTICE'),
	((SELECT id FROM t_developers d WHERE d.registration_number = 'a411665'), (SELECT id FROM t_languages l WHERE l.code = 'CD003'), 'NORMAL'),
	((SELECT id FROM t_developers d WHERE d.registration_number = 'a215698'), (SELECT id FROM t_languages l WHERE l.code = 'CD001'), 'MOUNT_STUPID');
