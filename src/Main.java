import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

void main() {
    try (Connection con = Conexion.getConnection()) {
        System.out.println("El programa jala yey");
        UI.Menu(con);
    } catch (Exception e) {
        System.out.println("Error al conectar o ejecutar el código: " + e.getMessage());
    }
}