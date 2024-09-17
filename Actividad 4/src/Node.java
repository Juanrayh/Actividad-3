public class Node {
    int id; 
    String nombre; 
    Node izquierdo, derecho; 

    /* constructor para crear un nuevo nodo */
    public Node(int id, String nombre) {
        this.id = id; 
        this.nombre = nombre; 
        izquierdo = derecho = null; 
    }
}
