insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Balzakova','58','43.27','44.23');
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Sekspirova','23','43.27','44.23');
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Alekse Santica','12','43.27,','44.23');



insert into work_hours (start_time,end_time) values ('8:00','16:00');
insert into work_hours (start_time,end_time) values ('9:00','16:00');
insert into work_hours (start_time,end_time) values ('8:00','16:00');
insert into work_hours (start_time,end_time) values ('9:00','11:00');
insert into work_hours (start_time,end_time) values ('13:00','15:00');
insert into work_hours (start_time,end_time) values ('9:00','12:00');
insert into work_hours (start_time,end_time) values ('11:00','17:00');
insert into work_hours (start_time,end_time) values ('10:00','12:00');



insert into blood_transfusion_center(name,address_id,average_grade,description,work_hours_id) values('ISA-Center',1,5.0,'Best of all',1);
insert into blood_transfusion_center(name,address_id,average_grade,description,work_hours_id) values('Red Cross',2,4.0,'Bestest',2);
insert into blood_transfusion_center(name,address_id,average_grade,description,work_hours_id) values('Ambulance',3,2.0,'We are the nations most important blood detributor',1);
insert into blood_transfusion_center(name,address_id,average_grade,description,work_hours_id) values('Main Hospital',2,5.0,'We take good care of your blood',1);
insert into blood_transfusion_center(name,address_id,average_grade,description,work_hours_id) values('Center 14-1',3,5.0,'Your blood is safe with us',1);



insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (0,20,1);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (2,20,1);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (7,60,1);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (5,50,1);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (1,40,1);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (3,20,1);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (4,20,2);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (6,20,2);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (1,23,2);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (0,16,3);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (5,25,4);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (7,20,4);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (7,60,5);
insert into blood_bank (blood_type,quantity,blood_transfusion_center_id) values (7,16,5);


insert into role( name) values ('Manager');
insert into role( name) values ('ADMIN');



insert into users(id,email, first_name, gender, is_active, jmbg, last_name, password, phone_number, address_id, role_id)
values(1,'dussanstanimirovic@gmail.com','Dusan','male',false,'0908000120312','Stanimirovic','12345','066428369',1,1);
insert into users(id,email, first_name, gender, is_active, jmbg, last_name, password, phone_number, address_id, role_id)
values(2,'dijanamoc@gmail.com','Dijana','female',false,'0211000120312','Moc','ftn','063412245',2,1);
insert into users(id,email, first_name, gender, is_active, jmbg, last_name, password, phone_number, address_id, role_id)
values(3,'sasakos@gmail.com','Sasa','male',false,'1012000120312','Kosanovic','1234567','066241235',3,2);
insert into users(id,email, first_name, gender, is_active, jmbg, last_name, password, phone_number, address_id, role_id)
values(4,'despacito@gmail.com','Milan','male',false,'2108000120312','Stankovic','54321','066634321',1,null);
insert into users(id,email, first_name, gender, is_active, jmbg, last_name, password, phone_number, address_id, role_id)
values(5,'jivana@gmail.com','Jovana','female',false,'0508000120312','Ivanic','123','060234532',2,null);