import java.util.*;

public class GestorDeTareas {
    
    private LinkedList<Tarea> listaTareas; // Usando LinkedList para almacenar tareas
    private Stack<Tarea> tareasCompletadas; // Usando Stack para almacenar tareas completadas
    private PriorityQueue<Tarea> colaPrioridad; // Usando Cola de Prioridad para manejar tareas
    private HashMap<String, Tarea> mapaTareas; // Usando HashMap para buscar tareas por título
    private ArbolBinario arbolTareas; // Usando un árbol binario para organizar tareas

    public GestorDeTareas() {
        this.listaTareas = new LinkedList<>();
        this.tareasCompletadas = new Stack<>();
        this.colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Tarea::getPrioridad)); // Comparador para prioridad
        this.mapaTareas = new HashMap<>(); // Inicializar el HashMap
        this.arbolTareas = new ArbolBinario(); // Inicializar el árbol binario
    }

    // Método para crear una nueva tarea
    public void crearTarea(String titulo, String descripcion, int prioridad) {
        Tarea nuevaTarea = new Tarea(titulo, descripcion, prioridad);
        listaTareas.add(nuevaTarea); // Agregamos la tarea a la lista
        colaPrioridad.offer(nuevaTarea); // También la agregamos a la cola de prioridad
        mapaTareas.put(titulo, nuevaTarea); // Guardamos la tarea en el HashMap
        arbolTareas.agregarTarea(nuevaTarea); // Agregamos la tarea al árbol binario
        System.out.println("Tarea creada: " + nuevaTarea);
    }

    // Método para asignar una tarea a un empleado (aquí simplificado)
    public void asignarTareaAEmpleado(int idEmpleado, Tarea tarea) {
        System.out.println("Tarea asignada al empleado con ID: " + idEmpleado);
    }

    // Método para completar una tarea
    public void completarTarea(Tarea tarea) {
        if (listaTareas.remove(tarea)) {
            tareasCompletadas.push(tarea); // Apilamos la tarea completada
            System.out.println("Tarea completada: " + tarea);
        } else {
            System.out.println("No se pudo completar la tarea.");
        }
    }

    // Método para mostrar todas las tareas pendientes
    public void verTareasPendientes() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            for (int i = 0; i < listaTareas.size(); i++) {
                System.out.println(i + ". " + listaTareas.get(i));
            }
        }
    }

    // Método para deshacer la última acción de completar una tarea
    public void deshacerUltimaAccion() {
        if (!tareasCompletadas.isEmpty()) {
            Tarea ultimaTareaCompletada = tareasCompletadas.pop(); // Sacamos la tarea de la pila
            listaTareas.add(ultimaTareaCompletada); // La restauramos a la lista de tareas
            colaPrioridad.offer(ultimaTareaCompletada); // También la agregamos de nuevo a la cola de prioridad
            mapaTareas.put(ultimaTareaCompletada.getTitulo(), ultimaTareaCompletada); // Restaurar en el HashMap
            arbolTareas.agregarTarea(ultimaTareaCompletada); // Restaurar en el árbol binario
            System.out.println("Ultima acción deshecha. Tarea restaurada: " + ultimaTareaCompletada);
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    // Método para obtener la lista de tareas (para otras funcionalidades)
    public LinkedList<Tarea> getListaTareas() {
        return listaTareas;
    }

    // Método para mostrar tareas por prioridad
    public void mostrarTareasPorPrioridad() {
        if (colaPrioridad.isEmpty()) {
            System.out.println("No hay tareas para mostrar.");
            return;
        }

        System.out.println("Tareas ordenadas por prioridad:");
        while (!colaPrioridad.isEmpty()) {
            Tarea tarea = colaPrioridad.poll(); // Sacamos la tarea de la cola
            System.out.println(tarea);
        }
    }

    // Método para buscar una tarea por título
    public void buscarTareaPorTitulo(String titulo) {
        Tarea tarea = mapaTareas.get(titulo);
        if (tarea != null) {
            System.out.println("Tarea encontrada: " + tarea);
        } else {
            System.out.println("No se encontró ninguna tarea con el título: " + titulo);
        }
    }

    // Método para mostrar el grafo de tareas (simplificado)
    public void mostrarGrafoTareas() {
        System.out.println("Mostrando grafo de tareas...");
        // Aquí puedes implementar la lógica para mostrar las dependencias entre tareas si fuera necesario
    }
}
