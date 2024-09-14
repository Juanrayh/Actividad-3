import java.util.Stack;

public class ReverseStack {

    /*Esto invierte la pila otorgada */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        reverse(stack);
        insertAtBottom(stack, temp);
    }


/*Inserta un elemento al fina de la pila */
    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, item);
        stack.push(temp);
    }


    /*Este metodo es el que muestra la pila normal e invertida, se encarga de hacer el proceso de esta misma */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Stack original: " + stack);
        reverse(stack);
        System.out.println("Stack invertido: " + stack);
    }
}
