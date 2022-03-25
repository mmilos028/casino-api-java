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
(id, name, is_super_type, user_type_id)
values(110005, 'Casino System', 0, 110002);

insert into user_type
(id, name, is_super_type, user_type_id)
values(110006, 'White Label', 0, 110002);

insert into user_type
(id, name, is_super_type, user_type_id)
values(110007, 'Internet Group', 0, 110002);

insert into user_type
(id, name, is_super_type, user_type_id)
values(110008, 'Web Partner Group', 0, 110002);

insert into user_type
(id, name, is_super_type, user_type_id)
values(110009, 'Point Of Sale Group', 0, 110002);

insert into user_type
(id, name, is_super_type, user_type_id)
values(110010, 'AdminMaster', 0, 110003);

insert into user_type
(id, name, is_super_type, user_type_id)
values(110011, 'Web Partner', 0, 110002);

insert into user_type
(id, name, is_super_type, user_type_id)
values(110012, 'Point Of Sale', 0, 110002);

insert into user_type
(id, name, is_super_type, user_type_id)
values(110013, 'Internet Group', 0, 110004);



insert into user
(id, username, email, password, currency, parent_user_id, user_type_id) 
values(10001, 'ROOT MASTER', 'rootmaster@example.com', 'ROOT MASTER', 'EUR', null, 110001);

insert into user
(id, username, email, password, currency, parent_user_id, user_type_id) 
values(10002, 'Casino', 'casino@example.com', 'Casino', 'EUR', 10001, 110005);

insert into user
(id, username, email, password, currency) 
values(10003, 'test3', 'test3@example.com', 'test3', 'CHF');

insert into user
(id, username, email, password, currency) 
values(10004, 'test4', 'test4@example.com', 'test4', 'ETH');
