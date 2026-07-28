import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

void main() {

    String sql = "INSERT INTO [Tabla 1] (id, matricula, nombre, edad, sexo, correo) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection con = Conexion.getConnection()){
        System.out.println("El programa jala yey");
        con.close();
        System.out.println("El programa se ha finalizado correctamente");
    } catch (Exception e) {
        System.out.println("Error al conectar o insertar desde el código: " + e.getMessage());
    }
}