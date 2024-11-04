import java.io.File;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

/**
 * Main class that manages a database of bosses and their children using DB4o.
 */
public class Main {

    /**
     * Entry point of the program. Performs various database operations.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Deletes the existing database file to avoid using outdated data.
        File file = new File("BDJefeHijo");
        file.delete();

        // Creates or opens a DB4o database in the specified file.
        ObjectContainer database = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "BDJefeHijo");

        // Stores `Jefe` objects in the database, each with information about the boss
        // and their child.
        database.store(new Jefe("Ángel", 5, 53, new Hijo("Gustavo", 7)));
        database.store(new Jefe("Nieves", 3, 45, new Hijo("Iván", 3)));
        database.store(new Jefe("Jesús", 3, 5, new Hijo("Noelia", 3)));
        database.store(new Jefe("Dolores", 5, 63, new Hijo("Sergio", 7)));
        database.store(new Jefe("Vicki", 3, 5, null)); // This boss has no child assigned.
        database.store(new Jefe("Fátima", 5, 63, new Hijo("Lidia", 27)));
        database.store(new Jefe("Juan Luís", 3, 5, null)); // Another boss without children.
        database.store(new Jefe("Elena", 1, 42, new Hijo("David", 19)));
        database.store(new Jefe("Miguel", 20, 45, new Hijo("Paula", 3)));
        database.store(new Jefe("Jesús", 19, 44, new Hijo("Rubén", 12)));

        try {
            // Executes specified queries and modifications.
            bossesOver55(database);
            incrementMiguelAge(database);
            deleteBossesWithTenureAbove6(database);
            displayAllBosses(database);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Closes the database to release resources.
            database.close();
        }
    }

    /**
     * Displays bosses who are older than 55 years.
     *
     * @param database The database from which to retrieve the data.
     */
    public static void bossesOver55(ObjectContainer database) {
        Query query = database.query();
        query.constrain(Jefe.class);
        query.descend("edad").constrain(55).greater();
        ObjectSet<Jefe> result = query.execute();

        System.out.println("\n(Bosses older than 55 years)");
        displayQueryResult(result);
    }

    /**
     * Increases the age of the boss named Miguel by one year.
     *
     * @param database The database to modify.
     */
    public static void incrementMiguelAge(ObjectContainer database) {
        Query query = database.query();
        query.constrain(Jefe.class);
        query.descend("nombre").constrain("Miguel");
        ObjectSet<Jefe> result = query.execute();

        // If a boss named Miguel is found, increment his age and update in the database
        if (!result.isEmpty()) {
            Jefe miguel = result.next();
            miguel.setEdad(miguel.getEdad() + 1);

            System.out.println("\nAge of Miguel has been updated");
            System.out.println("----------------------------");
            System.out.println(miguel);
            System.out.println();

            database.store(miguel); // Saves the updated object back to the database
        }
    }

    /**
     * Deletes bosses who have more than 6 years of tenure (antiguedad) in the
     * company.
     *
     * @param database The database to perform deletions.
     */
    public static void deleteBossesWithTenureAbove6(ObjectContainer database) {
        Query query = database.query();
        query.constrain(Jefe.class);
        query.descend("antiguedad").constrain(6).greater();
        ObjectSet<Jefe> result = query.execute();

        System.out.println("Proceeding to delete the following records: ");
        System.out.println("-------------------------------------------------------");

        // Iterates over the result set, displaying each boss and deleting them from the
        // database
        while (result.hasNext()) {
            Jefe boss = result.next();
            System.out.println(boss);
            database.delete(boss);
        }
        System.out.println();
    }

    /**
     * Prints the details of the retrieved objects from a query result.
     *
     * @param result The result set of the query to display.
     */
    public static void displayQueryResult(ObjectSet<Jefe> result) {
        System.out.println("Retrieved " + result.size() + " Objects: ");
        System.out.println("----------------------");

        // Prints each boss's details in the result set
        for (Jefe boss : result) {
            System.out.println(boss);
        }
    }

    /**
     * Displays all remaining bosses in the database, including details of their
     * children.
     *
     * @param database The database from which to retrieve the data.
     */
    public static void displayAllBosses(ObjectContainer database) {
        Query query = database.query();
        query.constrain(Jefe.class);
        ObjectSet<Jefe> result = query.execute();

        System.out.println("\nCurrent bosses in the database:");
        System.out.println("-------------------------------------\n");

        // Iterates through each boss, displaying their details and their child's
        // details if available
        while (result.hasNext()) {
            Jefe boss = result.next();
            Hijo child = boss.getHijo();

            System.out.println(boss.getNombre() + "\n---------");
            System.out.println("Tenure: " + boss.getAntiguedad() + " years.");
            System.out.println("Age: " + boss.getEdad() + " years.");
            System.out.println(
                    "Child: " + (child == null ? "No child." : child.getNombre() + ", " + child.getEdad() + " years."));
            System.out.println();
        }
    }
}
