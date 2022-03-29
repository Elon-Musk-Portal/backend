CREATE TABLE IF NOT EXISTS tweets
(
    id       SERIAL PRIMARY KEY,
    tweet_id BIGINT,
    created  timestamp,
    link     VARCHAR(512),
    tags     VARCHAR(1024)
);
