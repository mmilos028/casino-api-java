
--- INSERT USER TYPE
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

--- INSERT CURRENCY
insert into currency
(id, code, name, description)
values(20200, '978', 'EUR', 'Euro');

insert into currency
(id, code, name, description)
values(20201, '777', 'ETH', 'Ethereum');

insert into currency
(id, code, name, description)
values(20202, '112', 'BTC', 'Bitcoin');

insert into currency
(id, code, name, description)
values(20203, '840', 'USD', 'United States Dollar');

insert into currency
(id, code, name, description)
values(20204, '003', 'USDT', 'USDT');

insert into currency
(id, code, name, description)
values(20205, '007', 'USDTE', 'Tether Ethereum');

insert into currency
(id, code, name, description)
values(20206, '006', 'USDTT', 'Tether Tron');

insert into currency
(id, code, name, description)
values(20207, '000', 'FUN', 'Fun currency');

insert into currency
(id, code, name, description)
values(20208, '005', 'LTC', 'Litecoin');

insert into currency
(id, code, name, description)
values(20209, '333', 'DOGE', 'DogeCoin');

insert into currency
(id, code, name, description)
values(20210, '941', 'RSD', 'Republic Serbia Dinar');

insert into currency
(id, code, name, description)
values(20211, '888', 'BCH', 'Bitcoin Cash');

insert into currency
(id, code, name, description)
values(20212, '826', 'GBP', 'Pound Sterling');

insert into currency
(id, code, name, description)
values(20213, '756', 'CHF', 'Swiss Franc');

insert into currency
(id, code, name, description)
values(20214, '203', 'CZK', 'Czeck Koruna');

insert into currency
(id, code, name, description)
values(20215, '008', 'ALL', 'Albanian Lek');

--- INSERT USER
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

-- INSERT PLAYER
insert into user
(id, username, email, password, currency, user_type_id, verification_status, is_banned, language)
values(11001, 'test', 'test@example.com', 'test', 'EUR', 110004, 'EMV', 'N', 'en');

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(13001, 11001, 'test', 10007, 'Ultimate777.com');


insert into user
(id, username, email, password, currency, user_type_id, verification_status, is_banned, language)
values(11002, 'test2', 'test2@example.com', 'test2', 'EUR', 110004, 'KYC', 'N', 'en');

insert into user_for_user
(id, user_to_id, user_to_name, user_for_id, user_for_name)
values(13002, 11002, 'test2', 10007, 'Ultimate777.com');




--- INSERT SESSION TYPE
insert into session_type
(id, name, duration_limit, auto_close)
values(210004, 'SITE_SESSION', 50000, 1);

insert into session_type
(id, name, duration_limit, auto_close)
values(210005, 'INTEGRATION_SESSION', 50000, 0);

--- INSERT BALANCE TYPE
insert into balance_type
(id, name)
values(28001, 'FREE CREDITS');

insert into balance_type
(id, name)
values(28002, 'RESTRICTED CREDITS');

insert into balance_type
(id, name)
values(28003, 'RESTRICTED DEPOSIT');

insert into balance_type
(id, name)
values(28004, 'RESTRICTED BONUS');

insert into balance_type
(id, name)
values(28005, 'RESTRICTED WIN');

insert into balance_type
(id, name)
values(28006, 'RESTRICTED PROMOTION');

--INSERT TRANSACTION TYPE
insert into transaction_type
(id, name, description, transaction_sign)
values(76001, 'DEPOSIT FROM CODE', 'Deposit from code', 1);

insert into transaction_type
(id, name, description, transaction_sign)
values(76002, 'WITHDRAW FROM CODE', 'Withdraw from code', -1);

--INSERT Balance for player into UserWallet
insert into user_wallet
(id, balance, currency, balance_type_id, user_id)
values(7001001, 0.0028, 'BTC', 28001, 11001);

insert into user_wallet
(id, balance, currency, balance_type_id, user_id)
values(7001002, 5.0028, 'LTC', 28001, 11001);

insert into user_wallet
(id, balance, currency, balance_type_id, user_id)
values(7001003, 0.05, 'ETH', 28001, 11001);

insert into user_wallet
(id, balance, currency, balance_type_id, user_id)
values(7001004, 50.05, 'EUR', 28001, 11001);