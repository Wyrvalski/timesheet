insert into auth.user
(name,
email,
password
)
VALUES
('Administrador',
'admin@admin.com',
'{bcrypt}$2y$12$BCeI1Qe4mF/3W/EqPCGCKuhbsHXjKlTlxJKdP08LgQu6gyDX4mt9W');

insert into auth.user
(name,
email,
password,
team)
VALUES
('Programador 1',
'dev1@dev1.com',
'{bcrypt}$2y$12$4D8AODNvaWQhhIY8seG6PuoQwEUtNymqabfQiSIar8awzGAnYoqNK',
'Cliente A');

insert into auth.user
(name,
email,
password,
team)
VALUES
('Programador 2',
'dev2@dev2.com',
'{bcrypt}$2y$12$6/lNPsup/VjJTwXIBRCzLuImAJJy2Vnun/d9bBLOKRnX2YWVjWw9W',
'Cliente A;Cliente B');

insert into auth.authority
(name)
VALUES
('USER');

insert into auth.authority
(name)
VALUES
('ADMIN');


insert into auth.user_authority
(user_id,
authority)
VALUES
(1,
'USER');

insert into auth.user_authority
(user_id,
authority)
VALUES
(1,
'ADMIN');

insert into auth.user_authority
(user_id,
authority)
VALUES
(2,
'USER');

insert into auth.user_authority
(user_id,
authority)
VALUES
(3,
'USER');

insert into auth.oauth_client_details
(client_id,
resource_ids,
client_secret,
scope,
authorized_grant_types,
authorities,
access_token_validity,
refresh_token_validity)
VALUES
('timesheet',
'resources',
'{bcrypt}$2y$12$eWFH.Ny.k6ddRivpxnIiYejz19iHsFlVIlBt9Gxx3SnjorqmWW9mq',
'read,write',
'password,refresh_token',
'ADMIN,USER',
'1800',
'3600');