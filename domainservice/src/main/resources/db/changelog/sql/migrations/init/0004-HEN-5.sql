-- Insert sample data into key_profile table
INSERT INTO key_profile (key_profile_name, key_length, key_type, key_source, storage_key_profile)
VALUES ('KeyProfile1', 128, 'AES', 'GENERATED', NULL),
       ('KeyProfile2', 192, 'TripleDES', 'IMPORTED', NULL),
       ('KeyProfile3', 256, 'AES', 'DERIVED', NULL);

-- Insert sample data into key_usage table
INSERT INTO key_usage (key_profile_id, key_usage)
VALUES (1, 'ENCRYPT'),
       (1, 'DECRYPT'),
       (2, 'ENCRYPT'),
       (2, 'DECRYPT'),
       (3, 'SIGN'),
       (3, 'VERIFY'),
       (3, 'DERIVE');