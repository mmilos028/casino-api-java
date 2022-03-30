insert into user_type
(id, name, is_super_type)
values(110001, 'Master', 1);

insert into user_type
(id, name, is_super_type)
values(110002, 'Affiliate', 1);

insert into user_type
(id, name, is_super_type)
values(110003, 'Administrator', 1);

insert into user_type
(id, name, is_super_type)
values(110004, 'Player', 1);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110005, 'Casino System', 0, 110002);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110006, 'White Label', 0, 110002);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110007, 'Internet Group', 0, 110002);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110008, 'Web Partner Group', 0, 110002);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110009, 'Point Of Sale Group', 0, 110002);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110010, 'AdminMaster', 0, 110003);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110011, 'Web Partner', 0, 110002);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110012, 'Point Of Sale', 0, 110002);

insert into user_type
(id, name, is_super_type, parent_user_type_id)
values(110013, 'Internet Group', 0, 110004);



insert into user
(id, username, email, password, currency, user_type_id) 
values(10001, 'ROOT MASTER', 'rootmaster@example.com', 'ROOT MASTER', 'EUR', 110001);

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(12001, 10001, 'ROOT MASTER', null, null);

insert into user
(id, username, email, password, currency, user_type_id) 
values(10002, 'Casino', 'casino@example.com', 'Casino', 'EUR', 110005);

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(12002, 10002, 'Casino', 10001, 'ROOT MASTER');

insert into user
(id, username, email, password, currency, user_type_id) 
values(10003, 'Casino LGA', 'casinolga@example.com', 'Casino LGA', 'EUR', 110005);

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(12003, 10003, 'Casino LGA', 10002, 'Casino');

insert into user
(id, username, email, password, currency, user_type_id) 
values(10004, 'Ultimate777', 'ultimate777@example.com', 'Ultimate777', 'EUR', 110006);

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(12004, 10004, 'Ultimate777', 10003, 'Casino LGA');

insert into user
(id, username, email, password, currency, user_type_id) 
values(10005, 'Ultimate777 POS', 'ultimate777pos@example.com', 'Ultimate777 POS', 'EUR', 110009);

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(12005, 10005, 'Ultimate777 POS', 10004, 'Ultimate777');

insert into user
(id, username, email, password, currency, user_type_id) 
values(10006, 'Ultimate777 WP', 'ultimate777wp@example.com', 'Ultimate777 WP', 'EUR', 110007);

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(12006, 10006, 'Ultimate777 WP', 10004, 'Ultimate777');


insert into user
(id, username, email, password, currency, user_type_id) 
values(10007, 'Ultimate777.com', 'ultimate777com@example.com', 'Ultimate777.com', 'EUR', 110008);

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(12007, 10007, 'Ultimate777.com', 10004, 'Ultimate777');


insert into session_type
(id, name, duration_limit, auto_close)
values(210004, 'SITE_SESSION', 50000, 1);

insert into session_type
(id, name, duration_limit, auto_close)
values(210005, 'INTEGRATION_SESSION', 50000, 0);

