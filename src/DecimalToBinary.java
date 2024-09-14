import java.util.Scanner;

public class DecimalToBinary {


    /*Esto convierte el numero decimal en numero binario utiliando la recursividad */
    public static String decimalToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return decimalToBinary(n / 2) + (n % 2);
    }


    /*Este metodo convierte el numero decimal otorgado por el usuario para convertirlo en binario
     * utilizando el metodo decimalToBinary y lo imprime en la terminal
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número decimal: ");
        int decimal = scanner.nextInt();
        System.out.println("El número binario es: " + decimalToBinary(decimal));
        
        scanner.close();
    }
}
