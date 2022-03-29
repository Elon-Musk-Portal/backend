CREATE TABLE IF NOT EXISTS tweets
(
    id           SERIAL PRIMARY KEY,
    tweet_id     BIGINT,
    created_date timestamp,
    updated_date timestamp,
    link         VARCHAR(512),
    tags         VARCHAR(1024)
);
