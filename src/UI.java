import java.util.Scanner;
import java.sql.Connection;

public class UI {
    public static void Menu(Connection con){
        Scanner teclado = new Scanner (System.in);
        boolean menu = true;
        int opc = 0;
        int sx = 0;
        do{
            System.out.println("Menu de Opciones");
            System.out.println("[1] Agregar Alumno");
            System.out.println("[2] Mostrar Alumnos Registrados");
            System.out.println("[3] Modificar Alumno por Matricula");
            System.out.println("[4] Eliminar Alumno por Matricula");
            System.out.println("[5] Cuantos hombres y cuantas mujeres hay");
            System.out.println("[6] Salir");
            opc = teclado.nextInt();
            teclado.nextLine();
            switch(opc){
                case 1:
                    System.out.println("--- INGRESAR DATOS DEL ALUMNO ---");

                    System.out.print("Matricula: ");
                    String matricula = teclado.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Sexo (masculino/femenino): ");
                    System.out.println("[1] Masculino");
                    System.out.println("[2] Femenino");
                    int opcSexo = teclado.nextInt();
                    teclado.nextLine();

                    String sexo = (opcSexo == 1)? "masculino" : "femenino";

                    System.out.print("Correo: ");
                    String correo = teclado.nextLine();

                    try {
                        Alumno nuevoAlumno = new Alumno(matricula, nombre, edad, sexo, correo, con);
                        nuevoAlumno.add(con);
                    } catch (Exception e) {
                        System.out.println("Error al registrar el alumno: " + e.getMessage());
                    }

                    break;
                case 2:
                    Alumno.MostrarAlumnos(con);
                    break;
                case 3:
                    System.out.println("Modificar alumno por matricula");
                    System.out.println("Ingresar la matricula del alumno a modificar");
                    String matMod = teclado.nextLine();

                    System.out.println("Ingresar los nuevos datos");
                    System.out.println("Ingresar el nuevo Nombre");
                    String NuevoNombre = teclado.nextLine();
                    System.out.println("Ingresar la nueva edad");
                    int NuevoEdad = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Ingresar Sexo");
                    System.out.println("[1] Masculino");
                    System.out.println("[2] Femenino");
                    int opcNSexo = teclado.nextInt();
                    teclado.nextLine();

                    String NuevoSexo = (opcNSexo == 1)? "Masculino" : "Femenino";

                    System.out.println("Ingresar nuevo correo");
                    String NuevoCorreo = teclado.nextLine();

                    Alumno.ModificarAlumno(con, matMod, NuevoNombre, NuevoEdad, NuevoSexo, NuevoCorreo);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }while(menu == true);
    }
}
