import java.util.Scanner;

public class PalindromeNumber {

    /*Esto se encarga de convertir el numero en una string y verificar si es palidromo */
    public static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        return isPalindromeRecursive(str, 0, str.length() - 1);
    }

    /*Este metodo hace el chequeo si es palidrome  */
    private static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    /*Con esto solicitamos que ingrese el numero */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número: ");
        int num = scanner.nextInt();
        
        if (isPalindrome(num)) {
            System.out.println("El número sí es palíndromo.");
        } else {
            System.out.println("El número no es palíndromo.");
        }
        
        scanner.close();
    }
}
