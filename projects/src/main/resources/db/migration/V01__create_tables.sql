create TABLE projects.users (
 "user_id" SERIAL NOT NULL,
 "email" varchar(255) UNIQUE NOT NULL,
 "name" varchar (255) NOT NULL,
 PRIMARY KEY (user_id)
);

CREATE TABLE projects.project_name (
    "project_id" SERIAL NOT NULL,
    "name" varchar(255) UNIQUE NOT NULL,
    PRIMARY KEY("project_id")
);

CREATE TABLE projects.projects_user_hours(
    id SERIAL NOT NULL,
    user_id int NOT NULL,
    project_id int NOT NULL,
    "hour" varchar(255) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_users
        FOREIGN KEY("user_id")
            REFERENCES users("user_id"),
    CONSTRAINT fk_projects
        FOREIGN KEY("project_id")
            REFERENCES project_name("project_id")
);

