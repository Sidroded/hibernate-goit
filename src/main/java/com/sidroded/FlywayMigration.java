package com.sidroded;

import com.sidroded.database.Database;
import org.flywaydb.core.Flyway;

public class FlywayMigration {
    private final Database database;

    public FlywayMigration(Database database) {
        this.database = database;
    }

    public void flywayMigrate() {
        Flyway flyway = Flyway.configure().dataSource(database.getDbUrl(), database.getDbUser(), database.getDbPass()).load();
        flyway.migrate();
    }
}
