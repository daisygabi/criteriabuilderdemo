-- Companies --
INSERT INTO "company"(id, username, email, address, city, country, cif, public_name, phone, created_at, updated_at)
VALUES (1, 'GCSoftware', 'gcsoftware@email.com', 'Somewhere Street', 'Bled', 'Slovenia', 'ER3423432432',
        'Gabi and Cristi Labs',
        '+23432636543', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
INSERT INTO "company"(id, username, email, address, city, country, cif, public_name, phone, created_at, updated_at)
VALUES (2, 'Bread Company', 'wemakebread@email.com', 'Somewhere Street', 'Bohink', 'Slovenia', 'ER3425732',
        'We Make Bread',
        '+234322277', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
ALTER SEQUENCE company_id_seq RESTART WITH 4;

-- Trades --
INSERT INTO "trade"(id, name, created_at, updated_at)
VALUES (1, 'Software Development', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
INSERT INTO "trade"(id, name, created_at, updated_at)
VALUES (2, 'Baker', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
INSERT INTO "trade"(id, name, created_at, updated_at)
VALUES (3, 'Mechanical Engineer', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
INSERT INTO "trade"(id, name, created_at, updated_at)
VALUES (4, 'Electrician', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
INSERT INTO "trade"(id, name, created_at, updated_at)
VALUES (5, 'Financial Economist', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
INSERT INTO "trade"(id, name, created_at, updated_at)
VALUES (6, 'Executive', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
INSERT INTO "trade"(id, name, created_at, updated_at)
VALUES (7, 'Product Owner', '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
ALTER SEQUENCE trade_id_seq RESTART WITH 9;

-- Current jobs --
INSERT INTO "company_service"(id, trade_id, company_id, created_at, updated_at)
VALUES (1, 1, 3, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
INSERT INTO "company_service"(id, trade_id, company_id, created_at, updated_at)
VALUES (2, 3, 2, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000');
ALTER SEQUENCE company_service_id_seq RESTART WITH 4;

-- Company handy persons --
INSERT INTO "company_handy_person"(id, full_name, company_id, trade_id, created_at, updated_at, comment)
VALUES (1, 'Gigel Smith', 1, 1, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000', 'a comment');
INSERT INTO "company_handy_person"(id, full_name, company_id, trade_id, created_at, updated_at, comment)
VALUES (2, 'Mark Dom', 1, 3, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000', 'another comment');
ALTER SEQUENCE company_handy_person_id_seq RESTART WITH 4;

-- Users that have an account --
INSERT INTO platform_user(id, full_name, email, city, country, phone, created_at, updated_at)
VALUES (1, 'Twain Boat', 'twain@email.com', 'Bled', 'Slovenia', '+3425354', '2020-08-03 15:57:22.000000',
        '2020-08-03 15:57:22.000000');
INSERT INTO platform_user(id, full_name, email, city, country, phone, created_at, updated_at)
VALUES (2, 'Michel Purple', 'purple@email.com', 'Gadnz', 'Poland', '+242534354', '2020-08-03 15:57:22.000000',
        '2020-08-03 15:57:22.000000');
INSERT INTO platform_user(id, full_name, email, city, country, phone, created_at, updated_at)
VALUES (3, 'Nobody Under The Sun', 'maketechinclusive@email.com', 'Europe', 'EU', '+122534354', '2020-08-03 15:57:22.000000',
        '2020-08-03 15:57:22.000000');
ALTER SEQUENCE platform_user_id_seq RESTART WITH 4;

-- Users looking to buy a service --
INSERT INTO "user_request_service"(id, user_id, handyman_id, created_at, updated_at, request_status)
VALUES (1, 1, 2, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000', 0);
INSERT INTO "user_request_service"(id, user_id, handyman_id, created_at, updated_at, request_status, user_feedback_title)
VALUES (2, 2, 1, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000', 1, 'Going good so far');
INSERT INTO "user_request_service"(id, user_id, handyman_id, created_at, updated_at, request_status, user_feedback_description)
VALUES (3, 2, 1, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000', 0, 'What a pleasure to work with this person');
INSERT INTO "user_request_service"(id, user_id, handyman_id, created_at, updated_at, request_status)
VALUES (4, 1, 1, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000', 2);
INSERT INTO "user_request_service"(id, user_id, handyman_id, created_at, updated_at, request_status, user_feedback_title)
VALUES (5, 1, 1, '2020-08-03 15:57:22.000000', '2020-08-03 15:57:22.000000', 6, 'False advertising');
ALTER SEQUENCE user_request_service_id_seq RESTART WITH 10;
