-- Table: facilities
CREATE TABLE IF NOT EXISTS facilities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(100) NOT NULL,
    address TEXT NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);
-- Table: patients
CREATE TABLE IF NOT EXISTS patients (
    id SERIAL PRIMARY KEY,
    facility_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    age INT CHECK (age > 0),
    gender VARCHAR(10) CHECK (gender IN ('Male', 'Female', 'Other')),
    deleted BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_facility FOREIGN KEY (facility_id) REFERENCES facilities(id) ON DELETE CASCADE
);