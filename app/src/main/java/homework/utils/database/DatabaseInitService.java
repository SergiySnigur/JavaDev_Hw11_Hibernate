package homework.utils.database;

import homework.storage.StorageConstants;
import org.flywaydb.core.Flyway;

public class DatabaseInitService {
    public void initDb() {
        String connectionUrl = StorageConstants.CONNECTION_URL;

        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();

        flyway.migrate();
    }
}
