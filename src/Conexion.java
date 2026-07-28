import java.sql.*;

public class Conexion{
    private static String server = "localhost";
    private static String port = "1433";
    private static String database = "Alumnos";
    private static String user = "Martin";
    private static String password = "1234";

    public static String getStringConnection()
    {
        return String.format(
                "jdbc:sqlserver://%s:%s;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true;",
                server, port, database, user, password
        );
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(getStringConnection());
    }
}
