import java.util.*;    //importamos los paquetes de java.util
import java.util.stream.*;  //importamos los paquetes de java.util.stream


public class CentroApoyo {  //creamos la clase CentroApoyo

    private static List<Estudiante> estudiantes = Arrays.asList(   //base de datos de los estudiantes

            new Estudiante("Ana", "Programacion", 6.5),
            new Estudiante("Luis", "Programacion", 3.2),
            new Estudiante("Maria", "Programacion", 5.8),
            new Estudiante("Carlos", "Programacion", 4.1),
            new Estudiante("Sofia", "Programacion", 6.0),

            new Estudiante("Pedro", "BasesDatos", 5.5),
            new Estudiante("Javier", "BasesDatos", 2.9),
            new Estudiante("Camila", "BasesDatos", 6.7),
            new Estudiante("Valentina", "BasesDatos", 4.5),
            new Estudiante("Diego", "BasesDatos", 3.8),

            new Estudiante("Fernanda", "Redes", 5.0),
            new Estudiante("Miguel", "Redes", 6.2),
            new Estudiante("Daniela", "Redes", 3.1),
            new Estudiante("Tomas", "Redes", 4.3),
            new Estudiante("Ignacia", "Redes", 6.9),

            new Estudiante("Benjamin", "Paradigmas", 5.6),
            new Estudiante("Vicente", "Paradigmas", 4.8),
            new Estudiante("Jose", "Paradigmas", 3.4),
            new Estudiante("Martina", "Paradigmas", 6.1),
            new Estudiante("Florencia", "Paradigmas", 5.9),

            new Estudiante("Antonia", "Matematica", 6.4),
            new Estudiante("Alonso", "Matematica", 2.5),
            new Estudiante("Renata", "Matematica", 4.0),
            new Estudiante("Matias", "Matematica", 5.2),
            new Estudiante("Francisco", "Matematica", 3.7),

            new Estudiante("Constanza", "Fisica", 6.8),
            new Estudiante("Andres", "Fisica", 4.4),
            new Estudiante("Paula", "Fisica", 3.3),
            new Estudiante("Rodrigo", "Fisica", 5.1),
            new Estudiante("Catalina", "Fisica", 6.0)

    );
//verificamos a donde pertenece cada estudiante
    public static boolean perteneceAcurso(String nombre, String curso) {

        return estudiantes.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                //filtramos a los estudiantes
                .anyMatch(e -> e.getCurso().equalsIgnoreCase(curso));
                //verificamos a que curso pertenecen
    }
//verificacion si el estudiante esta aprobado o desaprobado
    public static boolean estaAprobado(String nombre) {

        return estudiantes.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .anyMatch(e -> e.getNota() >= 4.0);
    }

    public static boolean estaReprobado(String nombre) {

        return estudiantes.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .anyMatch(e -> e.getNota() < 4.0);
    }

    //solicitamos el nombre de un estudiante y mostramos su curso, nota y estado academico.

    public static void mostrarEstadoEstudiante() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        estudiantes.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .ifPresentOrElse(e -> {
                            System.out.println("\nNombre: " + e.getNombre());
                            System.out.println("Curso: " + e.getCurso());
                            System.out.println("Nota: " + e.getNota());

                            if (e.getNota() >= 4.0) {
                                System.out.println("Estado: Aprobado");
                            } else {
                                System.out.println("Estado: Reprobado");
                            }
                        },

                        () -> System.out.println("Estudiante no encontrado."));
    }
    //calculadora basica que realiza operaciones

    public static void calculadora() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo numero: ");
        double num2 = scanner.nextDouble();

        System.out.print("Ingrese la operación (+, -, *, /): ");
        String operacion = scanner.next();

        switch (operacion) {

            case "+":
                System.out.println("Resultado: " + (num1 + num2));
                break;

            case "-":
                System.out.println("Resultado: " + (num1 - num2));
                break;

            case "*":
                System.out.println("Resultado: " + (num1 * num2));
                break;

            case "/":
                if (num2 != 0) {
                    System.out.println("Resultado: " + (num1 / num2));
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                }
                break;

            default:
                System.out.println("Operación no valida.");
        }
    }
// menu del sistema que permite acceder a las funciones
    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n----Centro de apoyo academico----");
            System.out.println("1. Consultar estado del estudiante");
            System.out.println("2. Verificar el curso");
            System.out.println("3. Calculadora");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el salto de linea

            switch (opcion) {

                case 1:
                    mostrarEstadoEstudiante();
                    break;

                case 2:

                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese curso: ");
                    String curso = scanner.nextLine();

                    if (perteneceAcurso(nombre, curso)) {
                        System.out.println("El estudiante pertenece al curso.");
                    } else {
                        System.out.println("El estudiante no pertenece al curso.");
                    }

                    break;

                case 3:
                    calculadora();
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }
    public static void main(String[] args) {

        menu();

    }
}


