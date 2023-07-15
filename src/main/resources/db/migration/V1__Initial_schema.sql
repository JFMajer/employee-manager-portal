CREATE TABLE employee (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    job_title VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    image_url VARCHAR(200) NOT NULL,
    employee_code VARCHAR(20) NOT NULL,
    version integer NOT NULL,
    created_date timestamp NOT NULL,
    last_modified_date timestamp NOT NULL
);