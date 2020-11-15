create TABLE projects.users (
 "user_id" SERIAL NOT NULL,
 "email" varchar(255) UNIQUE NOT NULL,
 "name" varchar (255) NOT NULL,
 PRIMARY KEY ("user_id")
);

CREATE TABLE projects.project_name (
    "project_id" SERIAL NOT NULL,
    "name" varchar(255) UNIQUE NOT NULL,
    PRIMARY KEY("project_id")
);

CREATE TABLE projects.projects_user_hours(
    "project_id" int REFERENCES projects.project_name ("project_id") NOT NULL,
    "user_id" int REFERENCES projects.users ("user_id") NOT NULL,
    "hour" time NOT NULL
);

