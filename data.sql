
INSERT INTO PERSON (FIRSTNAME,LASTNAME,EMAIL,ADDRESS,CITY,PASSWORD,DTYPE) VALUES ('Robert','Exampler','robert@example.com','Example street','San Francisco','81dc9bdb52d04dc20036dbd8313ed055','Customer');
INSERT INTO PERSON (FIRSTNAME,LASTNAME,EMAIL,ADDRESS,CITY,PASSWORD,DTYPE) VALUES ('Admin','Admin','admin@example.com','Example street','Belmont','81dc9bdb52d04dc20036dbd8313ed055','Administrator');
INSERT INTO PERSON (FIRSTNAME,LASTNAME,EMAIL,ADDRESS,CITY,PASSWORD,DTYPE) VALUES ('Jack','Frost','jack@example.com','Example Blvd','San Francisco','81dc9bdb52d04dc20036dbd8313ed055','Customer');
INSERT INTO PERSON (FIRSTNAME,LASTNAME,EMAIL,ADDRESS,CITY,PASSWORD,DTYPE) VALUES ('Payment','User','paymentUser@dukescom','-','-','58175e1df62779046a3a4e2483575937','Customer');

INSERT INTO GROUPS (NAME, DESCRIPTION) VALUES ('USERS', 'Users of the store');
INSERT INTO GROUPS (NAME, DESCRIPTION) VALUES ('ADMINS', 'Administrators of the store');

INSERT INTO PERSON_GROUPS (GROUPS_ID,EMAIL) VALUES (1,'robert@example.com');
INSERT INTO PERSON_GROUPS (GROUPS_ID,EMAIL) VALUES (2,'admin@example.com');
INSERT INTO PERSON_GROUPS (GROUPS_ID,EMAIL) VALUES (1,'jack@example.com');
INSERT INTO PERSON_GROUPS (GROUPS_ID,EMAIL) VALUES (1,'paymentUser@dukescom');