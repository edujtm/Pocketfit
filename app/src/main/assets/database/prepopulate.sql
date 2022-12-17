CREATE TABLE IF NOT EXISTS exercises(
    exerciseId INTEGER NOT NULL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS repetitions(
    repetitionId INTEGER NOT NULL PRIMARY KEY,
    weight INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    workoutId INTEGER NOT NULL,
    exerciseId INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS workouts(
    workoutId INTEGER NOT NULL PRIMARY KEY,
    date INTEGER
);

-- TODO: Add major group later
-- Chest
-- Back
-- Arms
-- Abdominals
-- Legs
-- Shoulders
CREATE TABLE IF NOT EXISTS muscles(
    muscleId INTEGER NOT NULL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS worked_muscles(
    exerciseId INTEGER NOT NULL,
    muscleId INTEGER NOT NULL,
    PRIMARY KEY (exerciseId, muscleId)
);

INSERT INTO exercises VALUES (1, "Leg Press");
INSERT INTO exercises VALUES (2, "Single Arm French Press");
INSERT INTO exercises VALUES (3, "Bench Press");
INSERT INTO exercises VALUES (4, "Peck Deck");

INSERT INTO muscles VALUES (1, "Calves");
INSERT INTO muscles VALUES (2, "Hamstrings");
INSERT INTO muscles VALUES (3, "Quadriceps");
INSERT INTO muscles VALUES (4, "Glutes");
INSERT INTO muscles VALUES (5, "Biceps");
INSERT INTO muscles VALUES (6, "Triceps");
INSERT INTO muscles VALUES (7, "Forearms");
INSERT INTO muscles VALUES (8, "Trapezius");
INSERT INTO muscles VALUES (9, "Latissimus Dorsi");
INSERT INTO muscles VALUES (10, "Pectoral");

INSERT INTO worked_muscles VALUES (1, 3);
INSERT INTO worked_muscles VALUES (2, 6);
INSERT INTO worked_muscles VALUES (3, 5);
INSERT INTO worked_muscles VALUES (3, 6);
INSERT INTO worked_muscles VALUES (3, 10);
INSERT INTO worked_muscles VALUES (4, 10);

