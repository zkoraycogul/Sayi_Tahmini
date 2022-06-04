import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selectedNumber;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        while (right < 5) {

            System.out.print("Sayi giriniz : ");
            selectedNumber = input.nextInt();

            if (selectedNumber < 0 || selectedNumber > 99) {
                System.out.println("Lütfen 0-100 arasında bir değer giriniz.");
                if (isWrong) {
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5-right));
                } else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }

            if (selectedNumber == number) {
                System.out.println("Kazandınız!");
                isWin = true;
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz !");
                if (selectedNumber > number) {
                    System.out.println(selectedNumber + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(selectedNumber + " sayısı, gizli sayıdan küçüktür.");
                }

                wrong[right++] = selectedNumber;
                System.out.println("Kalan hakkı : " + (5-right));
            }
        }

        if (!isWin) {
            System.out.println("Kaybettiniz ! ");
            if (!isWrong) {
                System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
            }
        }

    }
}

