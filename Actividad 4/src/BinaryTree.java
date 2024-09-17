public class BinaryTree {
    Node raiz;

    /* constructor de la clase BinaryTree. Inicializa el arbol vacío */
    public BinaryTree() {
        raiz = null;
    }

    /* inserta un nuevo nodo con el ID y nombre proporcionados en el arbol */
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    /* metodo recursivo para insertar un nuevo nodo en el arbol */
    private Node insertarRecursivo(Node actual, int id, String nombre) {
        if (actual == null) {
            return new Node(id, nombre);
        }

        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        } else {
            System.out.println("El ID " + id + " ya existe. No se puede insertar duplicados.");
        }

        return actual;
    }

    /* busca un nodo en el arbol con el ID especificado */
    public Node buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    /* metodo recursivo para buscar un nodo en el arbol */
    private Node buscarRecursivo(Node actual, int id) {
        if (actual == null) {
            return null;
        }

        if (id == actual.id) {
            return actual;
        }

        return id < actual.id
                ? buscarRecursivo(actual.izquierdo, id)
                : buscarRecursivo(actual.derecho, id);
    }

    /* elimina un nodo del arbol con el ID especificado */
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    /* metodo recursivo para eliminar un nodo del arbol */
    private Node eliminarRecursivo(Node actual, int id) {
        if (actual == null) {
            System.out.println("El ID " + id + " no se encontró en el árbol.");
            return null;
        }

        if (id < actual.id) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, id);
        } else if (id > actual.id) {
            actual.derecho = eliminarRecursivo(actual.derecho, id);
        } else {
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            } else if (actual.izquierdo == null) {
                return actual.derecho;
            } else if (actual.derecho == null) {
                return actual.izquierdo;
            } else {
                Node sucesor = encontrarMinimo(actual.derecho);
                actual.id = sucesor.id;
                actual.nombre = sucesor.nombre;
                actual.derecho = eliminarRecursivo(actual.derecho, sucesor.id);
            }
        }

        return actual;
    }

    /* encuentra el nodo con el valor minimo en el subarbol dado */
    private Node encontrarMinimo(Node actual) {
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }

    /* realiza un recorrido en inorden del arbol y lo imprime */
    public void recorridoInorden() {
        System.out.print("Recorrido Inorden: ");
        recorridoInordenRecursivo(raiz);
        System.out.println();
    }

    /* metodo recursivo para realizar el recorrido en inorden */
    private void recorridoInordenRecursivo(Node actual) {
        if (actual != null) {
            recorridoInordenRecursivo(actual.izquierdo);
            System.out.print("(" + actual.id + ", " + actual.nombre + ") ");
            recorridoInordenRecursivo(actual.derecho);
        }
    }

    /* realiza un recorrido en preorden del arbol y lo imprime */
    public void recorridoPreorden() {
        System.out.print("Recorrido Preorden: ");
        recorridoPreordenRecursivo(raiz);
        System.out.println();
    }

    /* metodo recursivo para realizar el recorrido en preorden */
    private void recorridoPreordenRecursivo(Node actual) {
        if (actual != null) {
            System.out.print("(" + actual.id + ", " + actual.nombre + ") ");
            recorridoPreordenRecursivo(actual.izquierdo);
            recorridoPreordenRecursivo(actual.derecho);
        }
    }

    /* realiza un recorrido en postorden del arbol y lo imprime */
    public void recorridoPostorden() {
        System.out.print("Recorrido Postorden: ");
        recorridoPostordenRecursivo(raiz);
        System.out.println();
    }

    /* metodo recursivo para realizar el recorrido en postorden */
    private void recorridoPostordenRecursivo(Node actual) {
        if (actual != null) {
            recorridoPostordenRecursivo(actual.izquierdo);
            recorridoPostordenRecursivo(actual.derecho);
            System.out.print("(" + actual.id + ", " + actual.nombre + ") ");
        }
    }

    /* muestra una representacion visual del arbol en la consola */
    public void mostrarArbol() {
        mostrarArbolRecursivo(raiz, "", true);
    }

    /* metodo recursivo para mostrar el arbol de forma visual */
    private void mostrarArbolRecursivo(Node actual, String espacio, boolean esUltimo) {
        if (actual == null) {
            return;
        }

        System.out.print(espacio);
        if (esUltimo) {
            System.out.print("└─ ");
            espacio += "   ";
        } else {
            System.out.print("├─ ");
            espacio += "│  ";
        }
        System.out.println(actual.id + " (" + actual.nombre + ")");
        mostrarArbolRecursivo(actual.izquierdo, espacio, false);
        mostrarArbolRecursivo(actual.derecho, espacio, true);
    }
}
