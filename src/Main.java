import java.util.*;

public class Main {
    public static int rows;
    public static int cols;
    public static ArrayList<Integer> keys = new ArrayList<>();

    public static int countOccurrences(int[][] grid, int target) {
        int count = 0;
        for (int[] rows : grid) {
            for (int num : rows) {
                if (num == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void addOccurrencesToKeys(int[][] grid) {
        for (int i = 1; i<=rows; i++) {
            keys.add(countOccurrences(grid, i));
        }
    }

    public static void is_Valid() {
        for (int i = 0; i < rows; i++) {
            if (keys.get(i) == cols) {
                System.out.println("True");
            } else if(keys.get(i)>5) {
                System.out.println("Number "+(i+1)+" has been repeated "+(keys.get(i) - 5)+ " extra times");
            }
            else {
                System.out.println("Number "+(i+1)+" has been repeated "+(5 - keys.get(i))+ " less times");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        rows = in.nextInt();
        System.out.println("Enter number of columns: ");
        cols = in.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<cols; j++){
                System.out.println("Enter row "+(i+1)+" column "+(j+1));
                matrix[i][j] = in.nextInt();
            }
        }
        addOccurrencesToKeys(matrix);

        is_Valid();
    }
}