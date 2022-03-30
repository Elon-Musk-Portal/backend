CREATE TABLE IF NOT EXISTS tweets
(
    id           SERIAL PRIMARY KEY,
    tweet_id     VARCHAR(512),
    tags         VARCHAR(1024),
    created_date timestamp,
    updated_date timestamp
);
