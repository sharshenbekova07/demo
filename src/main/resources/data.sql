


create  table  if not exists users(
                                      id bigserial primary key ,
                                      user_name varchar not null  unique ,
                                      password varchar not null ,
                                      phone_number varchar not null  unique
);

create  table if not exists messages(
                                        id bigserial primary key ,
                                        author_id bigint references users(id),
                                        text_message text,
                                        date_create timestamp with time zone default now()

    );

create table if not exists readed_messages(
                                               id bigserial primary key ,
                                               message_id bigint references messages(id),
                                               recipient_id bigint references users(id),
                                               readed boolean default  false,
                                               constraint  some_readed unique (message_id,recipient_id)

 );


-- create  table if not exists m2m_users_messages (
--                                                    recipient_id bigint references users(id),
--                                                    message_id bigint references messages(id),
--                                                    readed_id bigint references readed_messages(id)
--
-- );

-- drop  table m2m_users_messages;

insert into users(user_name, password, phone_number)
VALUES
('user_1','Qwe123@','+996_1'),
('user_2','Qwe123@','+996_2'),
('user_3','Qwe123@','+996_3'),
('user_4','Qwe123@','+996_4'),
('user_5','Qwe123@','+996_5'),
('user_6','Qwe123@','+996_6'),
('user_7','Qwe123@','+996_7'),
('user_8','Qwe123@','+996_8'),
('user_9','Qwe123@','+996_9');

insert into messages(author_id, text_message)
VALUES
(1,'message_1'),  (1,'message_2'),   (1,'message_3'),  (1,'message_4'),
(2,'message_5'),  (2,'message_6'),   (2,'message_7'),  (2,'message_8'),
(3,'message_9'),  (3,'message_10'),  (3,'message_11'), (3,'message_12'),
(4,'message_13'),  (4,'message_14'), (4,'message_15'), (4,'message_16'),
(5,'message_17'),  (5,'message_18'), (5,'message_19'), (5,'message_20'),
(6,'message_21'),  (6,'message_22'), (6,'message_23'), (6,'message_24'),
(7,'message_25'),  (7,'message_26'), (7,'message_27'), (7,'message_28'),
(8,'message_29'),  (8,'message_30'), (8,'message_31'), (8,'message_32'),
(9,'message_33'),  (9,'message_34'), (9,'message_35'), (9,'message_36');

insert into readed_messages(message_id, recipient_id, readed)
VALUES (1,1 ,true),(12,3 ,true),(23,5 ,true),(34,7 ,true),
       (2,2 ,true),(13,4 ,true),(24,6 ,true),(35,8 ,true),
       (3,3 ,false),(14,5 ,false),(25,7 ,true),(36,9 ,true),
       (4,4 ,true),(15,6 ,true),(26,8 ,true),
       (5,5 ,true),(16,7 ,true),(27,9 ,false),
       (6,6 ,true),(17,8 ,false),(28,1 ,true),
       (7,7 ,false),(18,9 ,true),(29,2 ,false),
       (8,8 ,true),(19,1 ,false),(30,3 ,true),
       (9,9 ,true),(20,2 ,true),(31,4 ,true),
       (10,1 ,false),(21,3 ,true),(32,5 ,true),
       (11,2 ,true),(22,4 ,false),(33,6 ,false),

       (1,3 ,false),(12,5 ,true),(23,7 ,true),(34,9 ,true),
       (2,4 ,true),(13,6 ,true),(24,8 ,true),(35,1 ,false),
       (3,5 ,true),(14,7 ,false),(25,9 ,true),(36,2 ,true),
       (4,6 ,true),(15,8 ,true),(26,1 ,true),
       (5,7 ,false),(16,9 ,false),(27,2 ,true),
       (6,8 ,true),(17,1 ,true),(28,3 ,false),
       (7,9 ,false),(18,2 ,true),(29,4 ,true),
       (8,1 ,true),(19,3 ,false),(30,5 ,false),
       (9,2 ,false),(20,4 ,true),(31,6 ,true),
       (10,3 ,true),(21,5 ,false),(32,7 ,true),
       (11,4 ,false),(22,6 ,true),(33,8 ,false);