CREATE TABLE IF NOT EXISTS exercises(
    id INTEGER NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
);

CREATE TABLE IF NOT EXISTS repetitions(
    id INTEGER NOT NULL PRIMARY KEY,
    quantity INTEGER NOT NULL,
    workoutId INTEGER NOT NULL,
    exerciseId INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS workouts(
    id INTEGER NOT NULL,
    date INTEGER NOT NULL,
);

INSERT INTO exercises VALUES ("Leg Press");
INSERT INTO exercises VALUES ("Single Arm French Press");
INSERT INTO exercises VALUES ("Bench Press");
INSERT INTO exercises VALUES ("Peck Deck");
