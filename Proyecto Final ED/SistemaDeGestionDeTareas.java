import java.util.*;

public class SistemaDeGestionDeTareas {
    
    //Aqui se realiza un menu donde el usuario podra elegir la opcion de su agrado
    private static GestorDeTareas gestor = new GestorDeTareas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    crearTarea();
                    break;
                case 2:
                    asignarTarea();
                    break;
                case 3:
                    completarTarea();
                    break;
                case 4:
                    verTareasPendientes();
                    break;
                case 5:
                    deshacerUltimaAccion();
                    break;
                case 6:
                    mostrarTareasPorPrioridad();
                    break;
                case 7:
                    buscarTareaPorTitulo(); // Búsqueda de tarea
                    break;
                case 8:
                    gestor.mostrarGrafoTareas(); // Mostrar dependencias de tareas
                    break;
                case 9:
                    salir = true;
                    System.out.println("Saliendo del sistema de gestión de tareas...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\nMenu de Gestion de Tareas:");
        System.out.println("1. Crear nueva tarea");
        System.out.println("2. Asignar tarea a empleado");
        System.out.println("3. Completar tarea");
        System.out.println("4. Ver tareas pendientes");
        System.out.println("5. Deshacer ultima accion");
        System.out.println("6. Mostrar tareas por prioridad");
        System.out.println("7. Buscar tarea por titulo");
        System.out.println("8. Mostrar grafo de tareas");
        System.out.println("9. Salir");
        System.out.print("Elige una opcion: ");
    }

    public static void crearTarea() {
        System.out.print("Ingresa el título de la tarea: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingresa la descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingresa la prioridad de la tarea (1-10): ");
        int prioridad = scanner.nextInt();
        scanner.nextLine();

        gestor.crearTarea(titulo, descripcion, prioridad);
    }

    public static void asignarTarea() {
        System.out.print("Ingresa el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();

        // Mostramos las tareas creadas para asignar una
        System.out.println("Tareas disponibles para asignar:");
        gestor.verTareasPendientes();
        System.out.print("Ingresa el número de la tarea que deseas asignar: ");
        int indexTarea = scanner.nextInt();
        scanner.nextLine();
        //If en caso de ingresar caracter no valido
        List<Tarea> listaTareas = gestor.getListaTareas();
        if (indexTarea < 0 || indexTarea >= listaTareas.size()) {
            System.out.println("Numero de tarea no valido.");
        } else {
            Tarea tarea = listaTareas.get(indexTarea);
            gestor.asignarTareaAEmpleado(idEmpleado, tarea);
        }
    }

    public static void completarTarea() {
        System.out.println("Tareas pendientes:");
        gestor.verTareasPendientes();
        System.out.print("Ingresa el numero de la tarea que deseas completar: ");
        int indexTarea = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        List<Tarea> listaTareas = gestor.getListaTareas();
        if (indexTarea < 0 || indexTarea >= listaTareas.size()) {
            System.out.println("Numero de tarea no valido.");
        } else {
            Tarea tarea = listaTareas.get(indexTarea);
            gestor.completarTarea(tarea);
        }
    }

    public static void verTareasPendientes() {
        gestor.verTareasPendientes();
    }

    public static void deshacerUltimaAccion() {
        gestor.deshacerUltimaAccion();
    }

    public static void mostrarTareasPorPrioridad() {
        gestor.mostrarTareasPorPrioridad();
    }

    public static void buscarTareaPorTitulo() {
        System.out.print("Ingresa el titulo de la tarea que deseas buscar: ");
        String titulo = scanner.nextLine();
        gestor.buscarTareaPorTitulo(titulo);
    }
}
