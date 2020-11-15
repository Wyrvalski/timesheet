create TABLE auth.authority (
  "name" varchar(50) NOT NULL,
  PRIMARY KEY ("name")
);

create TABLE auth.oauth_access_token (
  "token_id" varchar(256) DEFAULT NULL,
  "token" bytea DEFAULT NULL,
  "authentication_id" varchar(256) DEFAULT NULL,
  "user_name" varchar(256) DEFAULT NULL,
  "client_id" varchar(256) DEFAULT NULL,
  "authentication" bytea DEFAULT NULL,
  "refresh_token" varchar(256) DEFAULT NULL
);

create TABLE auth.oauth_client_details (
  "client_id" varchar(255) NOT NULL,
  "resource_ids" varchar(255) DEFAULT NULL,
  "client_secret" varchar(255) DEFAULT NULL,
  "scope" varchar(255) DEFAULT NULL,
  "authorized_grant_types" varchar(255) DEFAULT NULL,
  "web_server_redirect_uri" varchar(255) DEFAULT NULL,
  "authorities" varchar(255) DEFAULT NULL,
  "access_token_validity" int DEFAULT NULL,
  "refresh_token_validity" int DEFAULT NULL,
  "additional_information" varchar(4096) DEFAULT NULL,
  "autoapprove" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("client_id")
);

create TABLE auth.oauth_refresh_token (
  "token_id" varchar(256) DEFAULT NULL,
  "token" bytea DEFAULT NULL,
  "authentication" bytea DEFAULT NULL
);

create TABLE auth.user (
  id SERIAL NOT NULL,
  "name" varchar(255) DEFAULT NULL,
  "email" varchar(255) UNIQUE NOT NULL,
  "password" varchar(500) NOT NULL,
  "team" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("id")
);

create TABLE auth.user_authority (
  "user_id" int REFERENCES auth.user (id) NOT NULL ,
  "authority" varchar(50) REFERENCES auth.authority (name) NOT NULL
);