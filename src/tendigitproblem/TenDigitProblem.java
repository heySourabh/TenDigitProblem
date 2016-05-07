package tendigitproblem;

import java.util.Arrays;
import util.AllPossibilities;

public class TenDigitProblem {
    public static void main(String[] args) {
        int[] limits = new int[10];
        for (int i = 0; i < limits.length; i++) {
            limits[i] = 10;
        }

        AllPossibilities possibilities = new AllPossibilities(limits);
        int[] numbers;
        while (true) {
            numbers = possibilities.getNext();
            if (numbers == null) {
                System.out.println("Covered all possibilities");
                break;
            }
            // Lets print out the current possibility
            codeToRunForThisPossibility(numbers);
        }
    }

    private static void codeToRunForThisPossibility(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if(count(numbers, i) != numbers[i]) {
                return;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
    
    private static int count(int[] numbers, int digit) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == digit) {
                count++;
            }
        }        
        return count;
    }
}
