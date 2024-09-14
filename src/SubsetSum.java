public class SubsetSum {


    /*Verifica si existe un subconjunto que de la suma */
    public static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (set[n - 1] > sum) {
            return isSubsetSum(set, n - 1, sum);
        }
        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }


    /*Este es el metodo principal queverifica si existe el subconjunto con la suma objetivo */
    public static void main(String[] args) {
        int[] set = {50, 20, 67, 2, 4, 5, 6, 7};
        int sum = 9;
        int n = set.length;

        System.out.println("¿Existe un subconjunto con la suma objetivo " + sum + "?");
        if (isSubsetSum(set, n, sum)) {
            System.out.println("sí");
        } else {
            System.out.println("no");
        }
    }
}
