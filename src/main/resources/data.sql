-- Insert facilities
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS facilities;
CREATE TABLE facilities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(100),
    address VARCHAR(255),
    deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);
CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    age INTEGER,
    facility_id INTEGER REFERENCES facilities(id),
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);
INSERT INTO facilities (
        name,
        type,
        address,
        deleted,
        created_at,
        updated_at
    )
VALUES (
        'Test Clinic',
        'Clinic',
        '123 Main St',
        false,
        now(),
        now()
    ),
    (
        'City Hospital',
        'Hospital',
        '456 Elm St',
        false,
        now(),
        now()
    ),
    (
        'Downtown Medical Center',
        'Clinic',
        '789 Oak Ave',
        false,
        now(),
        now()
    ),
    (
        'Sunrise Health Center',
        'Hospital',
        '1010 Maple Dr',
        false,
        now(),
        now()
    );
-- Insert patients
INSERT INTO patients (name, age, facility_id)
VALUES ('John Doe', 30, 1),
    ('Jane Smith', 25, 1),
    ('Ahmed Ali', 45, 2),
    ('Emily Clark', 52, 2),
    ('Mohamed Ibrahim', 33, 3),
    ('Sara Johnson', 28, 4),
    ('Khaled Nasser', 60, 4);