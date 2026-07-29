import java.sql.*;

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

    public static void MostrarAlumnos(Connection con){
        String sql = "SELECT id, matricula, nombre, edad, sexo, correo FROM [Tabla 1]";

        try (PreparedStatement statement = con.prepareStatement(sql);
        ResultSet rs = statement.executeQuery()){
            System.out.println("ID | MATRICULA | NOMBRE | EDAD | SEXO | CORREO");
            boolean HayAlumnos = false;
            while (rs.next()){
                HayAlumnos = true;
                int id = rs.getInt("id");
                String matricula = rs.getString("matricula");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String sexo = rs.getString("sexo");
                String correo = rs.getString("correo");

                System.out.println(id+" | "+matricula+" | "+nombre+" | "+edad +" | "+sexo +" | "+correo);
            }

            if(!HayAlumnos){
                System.out.println("No hay alumnos en la base de datos");
            }

        }
        catch (SQLException e){

            System.out.println("Error al consultar la base de datos "+e.getMessage());
        }
    }

    public static void ModificarAlumno(Connection con, String matricula, String NuevoNombre, int NuevoEdad, String NuevoSexo, String NuevoCorreo){
    String sql = "UPDATE [Tabla 1] SET nombre = ?, edad = ?, sexo = ?, correo = ? WHERE matricula = ?";
    try(PreparedStatement statement = con.prepareStatement(sql)){
        statement.setString(1, NuevoNombre);
        statement.setInt(2, NuevoEdad);
        statement.setString(3, NuevoSexo);
        statement.setString(4, NuevoCorreo);
        statement.setString(5, matricula);

        int filasAfectadas = statement.executeUpdate();
        if(filasAfectadas > 0){
            System.out.println("Cambios realizados con exito en la matricula "+matricula);
        }
        else {
            System.out.println("Algo salio mal");
        }
    }catch(SQLException e){

    }
    }
}
