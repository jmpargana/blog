CREATE TABLE IF NOT EXISTS article (
    id uuid DEFAULT random_uuid() PRIMARY KEY,
    title text,
    content text
);