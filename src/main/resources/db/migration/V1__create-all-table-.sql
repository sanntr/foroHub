-- Se crea la base de datos en inglés por fines prácticos

-- entidad perfil
CREATE TABLE profiles (
    profile_id BIGINT AUTO_INCREMENT NOT NULL,
    profile VARCHAR(25) NOT NULL unique,
    PRIMARY KEY(profile_id)
);

-- entidad usuario
CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT NOT NULL,
    status boolean not null,
    name VARCHAR(225) NOT NULL,
    email VARCHAR(120) NOT NULL unique,
    password VARCHAR(225) NOT NULL,
    profile_id BIGINT NOT NULL,

    PRIMARY KEY(user_id),
    FOREIGN KEY(profile_id) REFERENCES profiles(profile_id)
);

-- entidad curso
CREATE TABLE courses (
    course_id BIGINT AUTO_INCREMENT NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    category VARCHAR(30) NOT NULL,

    PRIMARY KEY(course_id)
);

-- entidad tópico
CREATE TABLE topics (
    topic_id BIGINT AUTO_INCREMENT NOT NULL,
    topic_title VARCHAR(225) NOT NULL,
    message TEXT,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    author BIGINT NOT NULL,
    course_id BIGINT,

    PRIMARY KEY(topic_id),
    FOREIGN KEY(author) REFERENCES users(user_id),
    FOREIGN KEY(course_id) REFERENCES courses(course_id)
);

-- entidad respuesta
CREATE TABLE replies (
    replies_id BIGINT AUTO_INCREMENT NOT NULL,
    message text not null,
    topic_id BIGINT NOT NULL,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    author BIGINT NOT NULL,

    PRIMARY KEY(replies_id),
    FOREIGN KEY(topic_id) REFERENCES topics(topic_id),
    FOREIGN KEY(author) REFERENCES users(user_id)
);
