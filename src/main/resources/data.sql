-- Facilities
INSERT INTO facilities (
        id,
        name,
        type,
        address,
        deleted,
        created_at,
        updated_at
    )
VALUES (
        1,
        'City Clinic',
        'General',
        '123 Main St',
        false,
        now(),
        now()
    ),
    (
        2,
        'Downtown Hospital',
        'Specialized',
        '456 Elm St',
        false,
        now(),
        now()
    ),
    (
        3,
        'Eastside Medical',
        'Urgent Care',
        '789 Oak St',
        false,
        now(),
        now()
    ),
    (
        4,
        'West End Health',
        'Family',
        '1010 Pine Ave',
        false,
        now(),
        now()
    ),
    (
        5,
        'Northview Center',
        'Pediatric',
        '222 Maple Blvd',
        false,
        now(),
        now()
    );
-- Patients
INSERT INTO patients (
        id,
        name,
        age,
        gender,
        facility_id,
        deleted,
        created_at,
        updated_at
    )
VALUES (1, 'John Doe', 30, 'M', 1, false, now(), now()),
    (2, 'Jane Smith', 45, 'F', 1, false, now(), now()),
    (
        3,
        'Mike Johnson',
        60,
        'M',
        2,
        false,
        now(),
        now()
    ),
    (4, 'Emma Lee', 29, 'F', 3, false, now(), now()),
    (
        5,
        'Chris Brown',
        50,
        'M',
        2,
        false,
        now(),
        now()
    ),
    (6, 'Sara Kim', 34, 'F', 3, false, now(), now()),
    (7, 'David Park', 41, 'M', 4, false, now(), now()),
    (8, 'Lena Adams', 37, 'F', 4, false, now(), now()),
    (
        9,
        'Ali Mahmoud',
        25,
        'M',
        5,
        false,
        now(),
        now()
    ),
    (
        10,
        'Nora Hossain',
        32,
        'F',
        5,
        false,
        now(),
        now()
    ),
    (
        11,
        'Tariq Amin',
        39,
        'M',
        1,
        false,
        now(),
        now()
    ),
    (
        12,
        'Zahra Alvi',
        28,
        'F',
        1,
        false,
        now(),
        now()
    ),
    (
        13,
        'Tom Nguyen',
        52,
        'M',
        2,
        false,
        now(),
        now()
    ),
    (
        14,
        'Rita Singh',
        46,
        'F',
        2,
        false,
        now(),
        now()
    ),
    (
        15,
        'Mona Elbaz',
        31,
        'F',
        3,
        false,
        now(),
        now()
    ),
    (
        16,
        'Adam Jones',
        63,
        'M',
        3,
        false,
        now(),
        now()
    ),
    (17, 'Mei Zhang', 26, 'F', 4, false, now(), now()),
    (
        18,
        'Carlos Ruiz',
        48,
        'M',
        4,
        false,
        now(),
        now()
    ),
    (
        19,
        'Fatima Noor',
        33,
        'F',
        5,
        false,
        now(),
        now()
    ),
    (
        20,
        'Hassan Nabil',
        44,
        'M',
        5,
        false,
        now(),
        now()
    );