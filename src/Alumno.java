import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Alumno {
    private int id;
    private String matricula;
    private String nombre;
    private int edad;
    private String sexo;
    private String correo;
    private Connection conexion;

    public Alumno(String matricula, String nombre, int edad, String sexo, String correo, Connection conexion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
        this.conexion = conexion;
    }

    public void add (Connection con) throws SQLException{
        String sql =
                "IF NOT EXISTS (SELECT 1 FROM [Tabla 1] WHERE matricula = ?) " +
                "BEGIN " +
                "INSERT INTO [Tabla 1] (matricula, nombre, edad, sexo, correo) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "END";
        PreparedStatement statement = con.prepareStatement(sql);

        statement.setString(1, this.matricula);

        statement.setString(2, this.matricula);
        statement.setString(3, this.nombre);
        statement.setInt(4, this.edad);
        statement.setString(5, this.sexo);
        statement.setString(6, this.correo);
        int queryExecStatus = statement.executeUpdate();

        if(queryExecStatus > 0){
            System.out.println("Alumno Creado Correctamente");
        }
        else{
            System.out.println("No se cargo ningun dato");
        }
    }
}
