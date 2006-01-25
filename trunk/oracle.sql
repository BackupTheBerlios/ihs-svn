create table ihs_config ( key varchar2(1024) not null, value varchar2(1024) );
alter table ihs_config add constraint ihs_config_pkey primary key(key);
create view ihs_view_config as select key,value from ihs_config;

CREATE OR REPLACE FUNCTION ihs_config_set(a_key IN ihs_config.key%TYPE, a_val IN ihs_config.value%TYPE) RETURN integer IS
    CURSOR cur_exists IS SELECT -1 FROM ihs_config WHERE key=a_key;
    id integer := -1;
BEGIN
    OPEN cur_exists;
    FETCH cur_exists INTO id;
    IF cur_exists%NOTFOUND = TRUE THEN
        INSERT INTO ihs_config (key,value) VALUES(a_key,a_val);
    ELSE
        UPDATE ihs_config SET value=a_val WHERE key=a_key;
    END IF;
    CLOSE cur_exists;
    RETURN 0;
END;
/
show errors;

create table ihs_administrators ( login varchar2(512) not null check( login<> '' ), value varchar2(512) );
alter table ihs_administrators add constraint ihs_administrators_pkey primary key(login);
create view ihs_view_administrators as select login,password from ihs_administrators;

CREATE OR REPLACE FUNCTION ihs_administrator_add
(a_login IN ihs_administrators.login%TYPE,
a_pass IN ihs_administrators.password%TYPE) RETURN INTEGER IS
	CURSOR cur_login IS SELECT 1 FROM ihs_administrators WHERE login=a_login;
	ret INTEGER;
BEGIN
	ret := 0;
 
	OPEN cur_login;
	FETCH cur_login INTO ret;
	IF cur_login%NOTFOUND = TRUE THEN
		INSERT INTO ihs_administrators (login,password)
			VALUES(a_login,a_pass);
		ret := 0;
	ELSE
		ret := -1;
	END IF;
	CLOSE cur_login;
  
	RETURN ret;
END;
/
show errors;

CREATE OR REPLACE FUNCTION ihs_administrator_rm
(a_login IN ihs_administrators.login%TYPE)
RETURN INTEGER IS
BEGIN
	DELETE FROM ihs_administrators WHERE login=a_login;
	RETURN 0;
END;
/
show errors;

CREATE OR REPLACE FUNCTION ihs_administrator_change
(a_login IN ihs_administrators.login%TYPE,
a_pass IN ihs_administrators.password%TYPE)
RETURN INTEGER IS
BEGIN
	UPDATE ihs_administrators SET password=a_pass WHERE login=a_login;
	IF SQL%ROWCOUNT = 1 THEN
		RETURN 0;
	END IF;
	RETURN -1;
END;
/
show errors;
