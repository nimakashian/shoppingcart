
insert into ADDRESS ( ID, address_Detail, EMAIL, NAME, PHONE, DESCRIPTION)
values ('11','tehran ....','a@g.com','user name','009898123', 'address to send the order');
insert into ADDRESS ( ID, address_Detail, EMAIL, NAME, PHONE, DESCRIPTION)
values ('12','tehran ....','b@g.com','manager name','009898124', 'address to call manager');
insert into ADDRESS ( ID, address_Detail, EMAIL, NAME, PHONE, DESCRIPTION)
values ('13','tehran ....','a@g.com','admin name','009898123', 'address to call the administrator');
-- -- ---------------------------------------
insert into ACCOUNT (ID,USERNAME, ACTIVE, PASSWORD, USERROLE, DESCRIPTION, CREATED, ADDRESS_ID)
values (random_uuid(),'user', 1,
        '123', 'client','who able to sale',sysdate,'11');
insert into ACCOUNT (ID,USERNAME, ACTIVE, PASSWORD, USERROLE, DESCRIPTION, CREATED, ADDRESS_ID)
values (random_uuid(),'manager', 1,
        '123', 'manager','who mange the orders',sysdate,'12');
insert into ACCOUNT (ID,USERNAME, ACTIVE, PASSWORD, USERROLE, DESCRIPTION, CREATED, ADDRESS_ID)
values (random_uuid(),'admin', 1,
        '123', 'ADMIN','who manage the shop',sysdate,'13');
-- ----------------
insert into PRODUCT (ID,PCODE, NAME, PRICE,  EXPIRE, DESCRIPTION, RESIDUE)
values (random_uuid(),'p001', 'Mastering Spring 5.0', 100, '2020-09-11 10:34:02.18', 'Copyright © 2017 Packt Publishing',100);

insert into PRODUCT (ID,PCODE, NAME, PRICE,  EXPIRE, DESCRIPTION, RESIDUE)
values (random_uuid(),'p002', 'Pro Spring 5', 50, '2020-09-11 10:34:02.18','5th Edition',100);

insert into PRODUCT (ID,PCODE, NAME, PRICE,  EXPIRE, DESCRIPTION, RESIDUE)
values (random_uuid(),'p003', 'Java 7', 120, '2020-09-11 10:34:02.18','Pocket Guide Robert Liguori Patricia Liguori',100);

insert into PRODUCT (ID,PCODE, NAME, PRICE,  EXPIRE, DESCRIPTION, RESIDUE)
values (random_uuid(),'p004', 'Oracle XML Parser', 120, '2020-10-11 10:34:02.18','Copyright © 2017 Packt Publishing',100);

insert into PRODUCT (ID,PCODE, NAME, PRICE,  EXPIRE, DESCRIPTION, RESIDUE)
values (random_uuid(),'p005', 'CSharp Tutorial for Beginers', 110, '2020-11-11 10:34:02.18','Copyright © 2018 Packt Publishing',100);

-------------------------------------
--insert into orders values('11','2019-09-11 16:22:04.262+04:30','bying today','2019-09-11 16:22:04.262+04:30','2019-09-11 16:22:04.262+04:30','1000','345','admin','11','NEW')