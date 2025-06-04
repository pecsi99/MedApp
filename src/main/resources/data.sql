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

-- 1 appointment ehhez a doktorhoz és pácienshez
INSERT INTO appointment (id, doctor_id, patient_id, date)
VALUES (1, 1, 1, DATE '2025-06-10');
