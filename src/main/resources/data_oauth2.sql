

/* client_secret column is set as the encrypted value of "secret" - the password for the clients  */
INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity,
 refresh_token_validity, additional_information, autoapprove)
VALUES
    ('test', '$2a$12$7tITKSx4vEnqDkfzSaFGy.kFqluBspL4LuIqgn2uN7775/6biKkrG', 'foo,read,write',
     'password,authorization_code,refresh_token,client_credentials,password', null, 'ADMIN, USER', 36000, 36000, null, true);
INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity,
 refresh_token_validity, additional_information, autoapprove)
VALUES
    ('sampleClientId', '$2a$10$F2dXfNuFjqezxIZp0ad5OeegW43cRdSiPgEtcetHspiNrUCi3iI6O', 'read,write,foo,bar',
     'implicit', null, 'ADMIN, USER', 36000, 36000, null, false);
INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity,
 refresh_token_validity, additional_information, autoapprove)
VALUES
    ('barClientIdPassword', '$2a$10$F2dXfNuFjqezxIZp0ad5OeegW43cRdSiPgEtcetHspiNrUCi3iI6O', 'bar,read,write',
     'password,authorization_code,refresh_token', null, 'USER', 36000, 36000, null, true);
