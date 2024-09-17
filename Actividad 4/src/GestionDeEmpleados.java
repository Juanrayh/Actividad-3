import java.util.Scanner;

public class GestionDeEmpleados {

    /* metodo principal que gestiona el menu y las operaciones de la aplicacion */
    public static void main(String[] args) {
        BinaryTree arbol = new BinaryTree(); 
        Scanner scanner = new Scanner(System.in); 
        int opcion; 

        do {
            
            System.out.println("\n--- Gestión de Empleados (Árbol Binario) ---");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Buscar empleado por ID");
            System.out.println("4. Mostrar recorridos del árbol");
            System.out.println("5. Mostrar árbol completo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Por favor, ingrese un número: ");
                scanner.next(); 
            }

            opcion = scanner.nextInt(); 
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    /* opcion para insertar un nuevo empleado en el arbol */
                    System.out.print("Ingrese el ID del empleado: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Entrada inválida. Por favor, ingrese un número para el ID: ");
                        scanner.next(); 
                    }
                    int idInsertar = scanner.nextInt(); 
                    scanner.nextLine(); 

                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombreInsertar = scanner.nextLine(); 

                    arbol.insertar(idInsertar, nombreInsertar); 
                    System.out.println("Empleado insertado correctamente.");
                    break;

                case 2:
                    /* opcion para eliminar un empleado del arbol */
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Entrada inválida. Por favor, ingrese un número para el ID: ");
                        scanner.next(); 
                    }
                    int idEliminar = scanner.nextInt(); 
                    scanner.nextLine(); 
                    arbol.eliminar(idEliminar); 
                    break;

                case 3:
                    /* opcion para buscar un empleado por ID */
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Entrada inválida. Por favor, ingrese un número para el ID: ");
                        scanner.next(); 
                    }
                    int idBuscar = scanner.nextInt(); 
                    scanner.nextLine(); 

                    Node empleadoEncontrado = arbol.buscar(idBuscar); 
                    if (empleadoEncontrado != null) {
                        System.out.println("Empleado encontrado: ID = " + empleadoEncontrado.id + ", Nombre = " + empleadoEncontrado.nombre);
                    } else {
                        System.out.println("Empleado con ID " + idBuscar + " no encontrado.");
                    }
                    break;

                case 4:
                    /* opcion para mostrar los recorridos del arbol */
                    System.out.println("\nSelecciona el tipo de recorrido:");
                    System.out.println("1. Inorden");
                    System.out.println("2. Preorden");
                    System.out.println("3. Postorden");
                    System.out.print("Opción: ");

                    while (!scanner.hasNextInt()) {
                        System.out.print("Entrada inválida. Por favor, ingrese un número: ");
                        scanner.next(); 
                    }

                    int tipoRecorrido = scanner.nextInt(); 
                    scanner.nextLine(); 

                    switch (tipoRecorrido) {
                        case 1:
                            arbol.recorridoInorden(); 
                            break;
                        case 2:
                            arbol.recorridoPreorden(); 
                            break;
                        case 3:
                            arbol.recorridoPostorden(); 
                            break;
                        default:
                            System.out.println("Opción inválida para recorrido.");
                    }
                    break;

                case 5:
                    /* opcion para mostrar la estructura completa del arbol binario */
                    System.out.println("\nEstructura del Árbol Binario:");
                    arbol.mostrarArbol(); 
                    break;

                case 6:
                    /* opcion para salir del programa */
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    /* mensaje para opciones no validas en el menu */
                    System.out.println("Opción inválida. Por favor, seleccione una opción entre 1 y 6.");
            }

        } while (opcion != 6); 

        scanner.close(); 
    }
}
