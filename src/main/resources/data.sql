INSERT IGNORE INTO restaurant_table_type (name) VALUES ('window');
INSERT IGNORE INTO restaurant_table_type (name) VALUES ('private');
INSERT IGNORE INTO restaurant_table_type (name) VALUES ('near toilet');
INSERT IGNORE INTO restaurant_table_type (name) VALUES ('middle');

INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (1, 3);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (2, 1);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (3, 1);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (4, 1);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (5, 2);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (6, 2);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (7, 2);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (8, 2);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (9, 4);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (10, 4);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (11, 4);
INSERT IGNORE INTO restaurant_table (table_number, type_id) VALUES (12, 4);

INSERT IGNORE INTO schedule (schedule_name, start_time, end_time, schedule_status, guest_id, table_id)
VALUES ('Reservation for 2 people', '2026-03-10 12:00:00', '2026-03-10 14:00:00', 'Ongoing', null, 1);

INSERT IGNORE INTO schedule (schedule_name, start_time, end_time, schedule_status, guest_id, table_id)
VALUES ('Reservation for 4 people', '2026-03-10 15:00:00', '2026-03-10 17:00:00', 'Ongoing', null, 2);

INSERT IGNORE INTO schedule (schedule_name, start_time, end_time, schedule_status, guest_id, table_id)
VALUES ('Reservation for 6 people', '2026-03-11 18:00:00', '2026-03-11 20:00:00', 'Ongoing', null, 1);

INSERT IGNORE INTO schedule (schedule_name, start_time, end_time, schedule_status, guest_id, table_id)
VALUES ('Reservation for 3 people', '2026-03-12 13:00:00', '2026-03-12 15:00:00', 'Ongoing', null, 3);