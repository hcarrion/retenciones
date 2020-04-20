create table oauth_access_token (
  token_id VARCHAR(255),
  token MEDIUMBLOB,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication MEDIUMBLOB,
  refresh_token VARCHAR(255)
);

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token MEDIUMBLOB,
  authentication MEDIUMBLOB
);

create table oauth_code (
  code VARCHAR(255), authentication MEDIUMBLOB
);