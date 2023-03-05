import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // выбрасываем случайное целое число от 0 до 2000
        int i = rand.nextInt(2001);
        System.out.println("i = " + i);

        // считаем номер старшего значащего бита числа i
        int n = 0;
        for (int j = 1 << 15; j > 0; j >>= 1) {
            if ((i & j) != 0) {
                n = (int) Math.ceil(Math.log(j + 1) / Math.log(2));
                break;
            }
        }
        System.out.println("n = " + n);

        // находим все кратные n числа в диапазоне от i до Short.MAX_VALUE
        List<Integer> m1 = new ArrayList<Integer>();
        for (int j = i; j <= Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1.add(j);
            }
        }
        System.out.println("m1 = " + m1);

        // находим все некратные n числа в диапазоне от Short.MIN_VALUE до i
        List<Integer> m2 = new ArrayList<Integer>();
        for (int j = Short.MIN_VALUE; j <= i; j++) {
            if (j % n != 0) {
                m2.add(j);
            }
        }
        System.out.println("m2 = " + m2);
    }
}