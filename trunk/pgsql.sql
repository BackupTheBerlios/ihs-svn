create table ihs_config ( key text not null, value text );
alter table ihs_config add constraint ihs_config_pkey primary key(key);
create view ihs_view_config as select key,value from ihs_config;

CREATE OR REPLACE FUNCTION ihs_config_set(ihs_config.key%TYPE, ihs_config.value%TYPE) RETURNS integer AS '
DECLARE
	a_key ALIAS FOR $1;
	a_val ALIAS FOR $2;
    id integer := -1;
BEGIN
    IF( EXISTS (SELECT -1 FROM ihs_config WHERE key=a_key) ) THEN
        UPDATE ihs_config SET value=a_val WHERE key=a_key;
	ELSE
        INSERT INTO ihs_config (key,value) VALUES(a_key,a_val);
    END IF;
    RETURN 0;
END;' language 'plpgsql';

create table ihs_administrators ( login text not null check( login<> '' ), password text check( password<>'' ));
alter table ihs_administrators add constraint ihs_administrators_pkey primary key(login);
create view ihs_view_administrators as select login,password from ihs_administrators;

create table ihs_groups (group_name text not null check( group_name<> ''));
alter table ihs_groups add constraint ihs_groups_pkey primary key(group_name);
create view ihs_view_groups as select group_name from ihs_groups;
insert into ihs_groups values('administrator');

create table ihs_admins_groups(login text references ihs_administrators (login) not null, group_name text references ihs_groups (group_name) );
alter table ihs_admins_groups add constraint ihs_admins_groups_pkey primary key(login,group_name);
create view ihs_view_admins_groups as select login,group_name from ihs_admins_groups;

CREATE OR REPLACE FUNCTION ihs_administrator_add
(ihs_administrators.login%TYPE, ihs_administrators.password%TYPE) RETURNS INTEGER AS '
DECLARE
	a_login ALIAS FOR $1;
	a_pass ALIAS FOR $2;
	ret INTEGER;
BEGIN
	ret := 0;
 
	IF ( EXISTS (SELECT 1 FROM ihs_administrators WHERE login=a_login) ) THEN
		ret := -1;
	ELSE
		INSERT INTO ihs_administrators (login,password)
			VALUES(a_login,a_pass);
		INSERT INTO ihs_admins_groups (login,group_name)
			VALUES(a_login,'administrator');
		ret := 0;
	END IF;
	RETURN ret;
END;' language 'plpgsql';

CREATE OR REPLACE FUNCTION ihs_administrator_rm
(ihs_administrators.login%TYPE)
RETURNS INTEGER AS '
DECLARE
	a_login ALIAS FOR $1;
BEGIN
	DELETE FROM ihs_administrators WHERE login=a_login;
	RETURN 0;
END;' language 'plpgsql';

CREATE OR REPLACE FUNCTION ihs_administrator_change
(ihs_administrators.login%TYPE,
ihs_administrators.password%TYPE)
RETURNS INTEGER AS '
DECLARE
	a_login ALIAS FOR $1;
	a_pass ALIAS FOR $2;
	rows integer;
BEGIN
	UPDATE ihs_administrators SET password=a_pass WHERE login=a_login;
	GET DIAGNOSTICS rows = ROW_COUNT;
	IF rows = 1 THEN
		RETURN 0;
	END IF;
	RETURN -1;
END;' language 'plpgsql';

commit;
