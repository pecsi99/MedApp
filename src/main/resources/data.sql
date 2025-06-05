-- 10 doctor rekord névvel
INSERT INTO doctor (name, department) VALUES ('Dr. Kovács', 'Kardiológia');
INSERT INTO doctor ( name, department) VALUES ('Dr. Szabó', 'Neurológia');
INSERT INTO doctor ( name, department) VALUES ('Dr. Nagy', 'Sebészet');
INSERT INTO doctor ( name, department) VALUES ('Dr. Tóth', 'Urológia');
INSERT INTO doctor ( name, department) VALUES ('Dr. Farkas', 'Onkológia');
INSERT INTO doctor ( name, department) VALUES ('Dr. Kiss', 'Dermatológia');
INSERT INTO doctor ( name, department) VALUES ('Dr. Horváth', 'Endokrinológia');
INSERT INTO doctor ( name, department) VALUES ('Dr. Molnár', 'Gyermekgyógyászat');
INSERT INTO doctor ( name, department) VALUES ('Dr. Balogh', 'Reumatológia');
INSERT INTO doctor ( name, department) VALUES ('Dr. Varga', 'Gasztroenterológia');

-- 1 patient
INSERT INTO patient ( name) VALUES ( 'János Péter');
INSERT INTO patient ( name) VALUES ( 'Kis Pista');
INSERT INTO patient ( name) VALUES ( 'Vas Péter');
INSERT INTO patient ( name) VALUES ( 'Bakó Mária');
INSERT INTO patient ( name) VALUES ( 'Nagy Lajos');
INSERT INTO patient ( name) VALUES ( 'Kovács Béla');
INSERT INTO patient ( name) VALUES ( 'Király Károly');
INSERT INTO patient ( name) VALUES ( 'Sidló Kitti');
INSERT INTO patient ( name) VALUES ( 'Kuszi Gyula');
INSERT INTO patient ( name) VALUES ( 'Szűcs Szandra');

INSERT INTO appointment (doctor_id, date_time) VALUES (1, '2025-06-10 14:30:00');
INSERT INTO appointment (doctor_id, date_time) VALUES (2, '2025-06-11 09:00:00');
INSERT INTO appointment (doctor_id, date_time) VALUES (3, '2025-06-12 11:00:00');
INSERT INTO appointment (doctor_id, date_time) VALUES (4, '2025-06-13 08:30:00');
INSERT INTO appointment (doctor_id, date_time) VALUES (5, '2025-06-14 15:00:00');
INSERT INTO appointment (doctor_id, patient_id, date_time) VALUES (6,6,'2025-06-14 15:00:00');
;

