-- 10 doctor rekord névvel
INSERT INTO doctor (id, name, department) VALUES (1, 'Dr. Kovács', 'Kardiológia');
INSERT INTO doctor (id, name, department) VALUES (2, 'Dr. Szabó', 'Neurológia');
INSERT INTO doctor (id, name, department) VALUES (3, 'Dr. Nagy', 'Sebészet');
INSERT INTO doctor (id, name, department) VALUES (4, 'Dr. Tóth', 'Urológia');
INSERT INTO doctor (id, name, department) VALUES (5, 'Dr. Farkas', 'Onkológia');
INSERT INTO doctor (id, name, department) VALUES (6, 'Dr. Kiss', 'Dermatológia');
INSERT INTO doctor (id, name, department) VALUES (7, 'Dr. Horváth', 'Endokrinológia');
INSERT INTO doctor (id, name, department) VALUES (8, 'Dr. Molnár', 'Gyermekgyógyászat');
INSERT INTO doctor (id, name, department) VALUES (9, 'Dr. Balogh', 'Reumatológia');
INSERT INTO doctor (id, name, department) VALUES (10, 'Dr. Varga', 'Gasztroenterológia');

-- 1 patient
INSERT INTO patient (id, name) VALUES (1, 'János Péter');

-- 1 appointment ehhez a doktorhoz és pácienshez
INSERT INTO appointment (id, doctor_id, patient_id, date)
VALUES (1, 1, 1, DATE '2025-06-10');
