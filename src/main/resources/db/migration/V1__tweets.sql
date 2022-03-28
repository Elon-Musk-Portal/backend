CREATE TABLE IF NOT EXISTS tweets
(
    id   BIGINT PRIMARY KEY,
    created timestamp,
    link VARCHAR(512)
);
