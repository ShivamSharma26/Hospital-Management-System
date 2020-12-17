
create table PatientInfo(id number(10) primary key,ssnid number(10),name varchar2(20),age number(3),adate varchar2(20),bedtype varchar2(15),
address varchar2(30),city varchar2(10),state varchar2(20),status varchar2(10));

create sequence id
MINVALUE 100000001
MAXVALUE 999999999
START WITH 100000001
INCREMENT by 3;

insert into PatientInfo(id,ssnid,name,age,adate,bedtype,address,city,state,status) values(1234,3456,'rpj',22,'15/06/2020','gen',
'ihjiuhiui','shg','mh','Active');

drop table PatientInfo;

create table Issued_Medicine(id number(9),medicine_id number(10),quantity number(5),primary key(id,medicine_id));
ALTER TABLE Issued_Medicine
ADD FOREIGN KEY (id) REFERENCES PatientInfo(id) on delete cascade;

ALTER TABLE Issued_Medicine
ADD FOREIGN KEY (medicine_id) REFERENCES Medicine(medicine_id) ;

insert into Issued_Medicine values(1234,101,12);
insert into Issued_Medicine values(1234,102,15);
insert into Issued_Medicine values(1234,103,17);


select * from Issued_Medicine ;
create table Medicine(medicine_id number(10) primary key,medicine_name varchar2(50),quantity number(5),rate number(10,2));
select * from Medicine ;

insert into Medicine values(101,'Acebutolol',50,55.50);
insert into Medicine values(102,'Corgard',40,2000);
insert into Medicine values(103,'Tenormin',45,100);

create table Issued_Test(id number(10),test_id number(10),primary key(id,test_id));
insert into Issued_Test values (1234,211);
insert into Issued_Test values (1234,222);
insert into Issued_Test values (1234,233);


create table Test(test_id number(10) primary key,test_name varchar2(20),test_charge number(8,2));
insert into Test values(211,'blood',400);
insert into Test values(222,'hemo',125);
insert into Test values(233,'highbp',500);



drop table Test;
