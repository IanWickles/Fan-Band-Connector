BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,email_address) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','user@gmail.com');
INSERT INTO users (username,password_hash,role,email_address) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'admin@gmail.com');
INSERT INTO users (username,password_hash,role,email_address) VALUES ('manager','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_MANAGER', 'manager@gmail.com');

COMMIT TRANSACTION;
