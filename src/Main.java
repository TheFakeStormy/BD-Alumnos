import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

void main() {
    try (Connection con = Conexion.getConnection()) {
        System.out.println("El programa jala yey");
        Alumno nuevoAlumno = new Alumno("001", "Pedro", 19, "masculino", "pedro@mail.com", con);
        nuevoAlumno.add(con);

        System.out.println("El programa se ha finalizado correctamente");
    } catch (Exception e) {
        System.out.println("Error al conectar o insertar desde el código: " + e.getMessage());
    }
}