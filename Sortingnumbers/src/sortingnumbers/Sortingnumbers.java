package sortingnumbers;

import java.util.*;

public class Sortingnumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("how many numbers do you want to input?");
        int num = input.nextInt();
        int numbers[] = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.println("number" + i);
            numbers[i] = input.nextInt();
        }
        Arrays.sort(numbers);

        System.out.println("Your numbers in order from smallest to largest:" + Arrays.toString(numbers));

        double sum = 0.0;
        for (double numb : numbers) {
            sum += numb;
        }

        double average = sum / numbers.length;
        System.out.println("the average is :" + average);
    }

}
