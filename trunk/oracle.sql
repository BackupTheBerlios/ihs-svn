create table ihs_config ( key varchar2(1024) not null, value varchar2(1024) );
alter table ihs_config add constraint ihs_config_pkey primary key(key);

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
