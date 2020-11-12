ALTER TABLE auth.oauth_access_token ADD CONSTRAINT pk_oauth_access_token PRIMARY KEY (token_id);
ALTER TABLE auth.oauth_refresh_token ADD CONSTRAINT pk_oauth_refresh_token PRIMARY KEY (token_id);

UPDATE auth.oauth_client_details SET
authorized_grant_types = 'password,refresh_token,authorization_code,implicit',
scope = 'trust,read,write',
access_token_validity = 7200,
refresh_token_validity = 14400;