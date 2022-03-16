BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE hall';

EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE hall(
  id number(10) NOT NULL,
  name varchar2(255) DEFAULT NULL,
  location varchar2(225) DEFAULT NULL,
  PRIMARY KEY (id));


-- Generate ID using sequence and trigger

CREATE SEQUENCE hall_seq START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER hall_seq_tr
 BEFORE INSERT ON hall FOR EACH ROW
 WHEN (NEW.id IS NULL)

BEGIN
SELECT hall_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/

INSERT INTO hall (id, name, location) VALUES (1,'RR Hall', 'London');
INSERT INTO hall (id, name, location) VALUES (2,'KK Hall', 'Washington');
INSERT INTO hall (id, name, location) VALUES (3,'Golden Mahal', 'France');

Begin
   execute immediate 'Drop table event';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
create table event(id number(19),event_name varchar2(255),organiser varchar2(255),organiser_number varchar2(255),hall_id number(20) NOT NULL, PRIMARY KEY(id), FOREIGN KEY (hall_id) REFERENCES hall (id));

-- Generate ID using sequence and trigger
create sequence event_seq start with 1 increment by 1;
create or replace trigger event_seq_tr
before insert on event for each row
when (new.id is null)
begin 
select event_seq.nextval into :new.id from dual;
end;
/
INSERT INTO event (id, event_name, organiser, organiser_number, hall_id) VALUES (1,'Birthday Party','Robert','7894561230', 1);

INSERT INTO event (id, event_name, organiser, organiser_number, hall_id) VALUES (2,'Sports Ceremony','William','7894567890', 1);

INSERT INTO event (id, event_name, organiser, organiser_number, hall_id) VALUES (3,'Home Fest','Jessy','968520147', 2);

INSERT INTO event (id, event_name, organiser, organiser_number, hall_id) VALUES (4,'Wedding Event','Peter','8523697410', 2);

INSERT INTO event (id, event_name, organiser, organiser_number, hall_id) VALUES (5,'Roto Fest','Stuart','9874563201', 3);

INSERT INTO event (id, event_name, organiser, organiser_number, hall_id) VALUES (6,'Carving Street','Wilson','8569320147', 3);