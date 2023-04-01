USE `comicstore-db`;

create table if not exists clients (
                         id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         client_id VARCHAR(40),
                         store_id VARCHAR(40),
                         first_name VARCHAR(50),
                         last_name VARCHAR(50),
                         email VARCHAR(50),
                         phone_number VARCHAR(50),
                         total_bought DECIMAL(6,2),
                         rebate DECIMAL(10,2)
);
create table if not exists stores (
                        id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        store_id VARCHAR(40),
                        inventory_id VARCHAR(40),
                        date_opened DATE,
                        street_address VARCHAR(50),
                        province VARCHAR(50),
                        city VARCHAR(50),
                        postal_code VARCHAR(50),
                        email VARCHAR(50),
                        phone_number VARCHAR(50)
);
create table if not exists card_games (
                            id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            card_id VARCHAR(40),
                            card_game_name VARCHAR(50),
                            company VARCHAR(50),
                            release_date DATE,
                            is_active BIT
);


create table if not exists tournaments (
                                          id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                          card_id VARCHAR(40),
                                          tournament_id VARCHAR(40),
                                          entry_cost DECIMAL(6,2),
                                          client_id VARCHAR(40)
);


create table if not exists tournament_players (
                                                  tournament_id VARCHAR(40),
                                                  client_id VARCHAR(40)
);




create table if not exists tournament_results (
                                                  tournament_id VARCHAR(40),
                                                  client_id VARCHAR(40),
                                                  victories INTEGER,
                                                  defeats INTEGER,
                                                  draws INTEGER
);


create table if not exists card_game_sets (
                                    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                    card_id VARCHAR(40),
                                    name VARCHAR(40),
                                    release_date DATE,
                                    number_of_cards INTEGER
                                );


create table if not exists inventories (
                                    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                    inventory_id VARCHAR(40),
                                    type VARCHAR(40),
                                    store_id VARCHAR(40),
                                    last_updated DATE
);