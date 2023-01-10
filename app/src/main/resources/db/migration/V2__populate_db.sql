INSERT INTO client (name)
VALUES
    ('Serhii'),
    ('Kate'),
    ('Mark'),
    ('Andrew'),
    ('Lambert'),
    ('John'),
    ('Keli'),
    ('Olga'),
    ('Max'),
    ('Svitlana');

INSERT INTO planet (id, name)
VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('PLUTO', 'Pluto'),
    ('SAT', 'Saturn'),
    ('NEPT', 'Neptune');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'VEN', 'MARS' ),
    (5, 'PLUTO', 'VEN' ),
    (2, 'NEPT', 'PLUTO' ),
    (7, 'MARS', 'VEN' ),
    (10, 'VEN', 'SAT' ),
    (8, 'SAT', 'MARS' ),
    (3, 'VEN', 'MARS' ),
    (4, 'MARS', 'PLUTO' ),
    (6, 'NEPT', 'MARS' ),
    (9, 'VEN', 'NEPT' );


