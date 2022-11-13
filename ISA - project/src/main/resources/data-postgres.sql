
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Balzakova','58','43.27','44.23');
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Sekspirova','23','43.27','44.23');
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Alekse Santica','12','43.27,','44.23');
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Mire Santica','18','45.27,','44.23');
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Sime Milosevica','88','45.27,','44.23');
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Mire Miroslavica','77','45.27,','44.23');
insert  into  address (country,city,street,street_number,lon,lat) values ('Srbija','Novi Sad','Cara Dusana','19','45.27,','44.23');



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


INSERT INTO role (name) VALUES ('ROLE_CLIENT'),
                               ('ROLE_ADMIN'),
                               ('ROLE_MEDICALSTAFF'),
                               ('ROLE_UNAUTH');

insert into medical_staff (id,email, password, first_name, last_name, address_id, phone_number, jmbg, gender,blood_transfusion_center_id,is_active, role_id) values (nextval('my_seq_gen_user'),'markomarkovic@gmail.com', 'admin','Marko', 'Markovic', 4, '0601231231', 439545, 'MALE',1,true, 2);
insert into medical_staff (id,email, password, first_name, last_name, address_id, phone_number, jmbg, gender,blood_transfusion_center_id,is_active, role_id) values (nextval('my_seq_gen_user'),'petarpetrovic@gmail.com', 'admin','Petar', 'Petrovic', 5, '0601231231', 439545, 'MALE',1,true, 2);
insert into medical_staff (id,email, password, first_name, last_name, address_id, phone_number, jmbg, gender,blood_transfusion_center_id,is_active, role_id) values (nextval('my_seq_gen_user'),'zoranzoranovic@gmail.com', 'admin','Zoran', 'Zoranovic', 6, '0601231231', 439545, 'MALE',1,true, 2)
/*insert into client (id, email, password, first_name, last_name, address_id, phone_number, jmbg, gender,
                    is_active, role_id, penalty, graded_center, occupation, organization_information, filled_out_survey)
values (nextval('my_seq_gen_user'), 'client@gmail.com', '$2a$10$34m5dosyTARXnOiqIEdM8uXyosZYQtDy75QBPPS7S91Iirn5ORQ8O',
        'Marko', 'Markovic', 1, '0601231231', 439545, 'MALE', true, 1 , 0, false, 'student', 'ftn', false);*/
