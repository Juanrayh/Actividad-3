class Nodo {
    Tarea tarea;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(Tarea tarea) {
        this.tarea = tarea;
        this.izquierda = null;
        this.derecha = null;
    }
}
// Se crea una clase de ArbolBinario donde almacena las tareas con prioridad
public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void agregarTarea(Tarea tarea) {
        raiz = agregarRecursivo(raiz, tarea);
    }

    private Nodo agregarRecursivo(Nodo nodo, Tarea tarea) {
        if (nodo == null) {
            return new Nodo(tarea);
        }

        if (tarea.getPrioridad() < nodo.tarea.getPrioridad()) {
            nodo.izquierda = agregarRecursivo(nodo.izquierda, tarea);
        } else {
            nodo.derecha = agregarRecursivo(nodo.derecha, tarea);
        }

        return nodo;
    }

}
