INSERT INTO Client (name) VALUES ('John Smith'),
                              ('Alice Johnson'),
                              ('Michael Wang'),
                              ('Emily Jones'),
                              ('Daniel Kim'),
                              ('Sophia Chen'),
                              ('Matthew Brown'),
                              ('Emma Lee'),
                              ('Olivia Martinez'),
                              ('James Nguyen');

INSERT INTO Planet (id, name) VALUES ('MARS', 'Mars'),
                                  ('VEN', 'Venus'),
                                  ('EAR', 'Earth'),
                                  ('JUP', 'Jupiter'),
                                  ('SAT', 'Saturn');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (1, 'MARS', 'EAR'),
                                                                 (2, 'VEN', 'JUP'),
                                                                 (3, 'EAR', 'SAT'),
                                                                 (4, 'MARS', 'VEN'),
                                                                 (5, 'JUP', 'SAT'),
                                                                 (6, 'VEN', 'EAR'),
                                                                 (7, 'EAR', 'MARS'),
                                                                 (8, 'MARS', 'JUP'),
                                                                 (9, 'SAT', 'EAR'),
                                                                 (10, 'JUP', 'MARS');
