CREATE TABLE IF NOT EXISTS Client (id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3),
                                    UNIQUE (name));

CREATE TABLE IF NOT EXISTS Planet (id VARCHAR(36) PRIMARY KEY, name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1));

CREATE TABLE IF NOT EXISTS Ticket (id INT AUTO_INCREMENT PRIMARY KEY,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    client_id INT,
                                    from_planet_id VARCHAR(10),
                                    to_planet_id VARCHAR(10),
                                    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES Client(id),
                                    CONSTRAINT fk_from_planet FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
                                    CONSTRAINT fk_to_planet FOREIGN KEY (to_planet_id) REFERENCES Planet(id),
                                    CONSTRAINT valid_planet_pair CHECK (from_planet_id <> to_planet_id));