-- liquibase formatted sql

-- changeset user:1

CREATE index name_idx
on student (name);

CREATE index name_and_color_idx
on faculty (name,color);
