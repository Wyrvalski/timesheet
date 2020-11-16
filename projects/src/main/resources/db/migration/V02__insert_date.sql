INSERT INTO projects.users(
 user_id,
 email,
 name
)
VALUES
(
1,
'admin@admin.com',
'Administrador'
);

INSERT INTO projects.users(
 user_id,
 email,
 name
)
VALUES
(
2,
'dev1@dev1.com',
'Programador 1'
);

INSERT INTO projects.users(
 user_id,
 email,
 name
)
VALUES
(
3,
'dev2@dev2.com',
'Programador 2'
);

INSERT INTO projects.project_name(
    project_id,
    name
)
VALUES (
1,
'Projeto A'
);

INSERT INTO projects.project_name(
    project_id,
    name
)
VALUES (
2,
'Projeto B'
);

INSERT INTO projects.projects_user_hours(
    project_id,
    user_id,
    hour
)
VALUES (
    1,
    2,
    '00:00'
);

INSERT INTO projects.projects_user_hours(
    project_id,
    user_id,
    hour
)
VALUES (
    1,
    3,
    '00:00'
);

INSERT INTO projects.projects_user_hours(
    project_id,
    user_id,
    hour
)
VALUES (
    2,
    3,
    '00:00'
);
