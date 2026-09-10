import java.util.Scanner;

public class FinalMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("시작 단(2~9): ");
        int startDan = scanner.nextInt(); // 시작단 입력
                System.out.print("끝 단(2~9): ");
        int endDan = scanner.nextInt(); // 끝단 입력

        boolean invalid = startDan < 2 || endDan > 9; // 시작단이 2보다 작거나 끝 단이 9보다 클때 invalid true
        if (invalid) {
            System.out.println("2~9 범위를 순서대로 입력하세요.");
        } else {
            for (int dan = startDan; dan<=endDan; dan++) { //
                System.out.println("[" + dan + "단]");
                for (int number = 1; number <= 9; number++) {
                    int result = dan * number;
                    System.out.println(dan + " x " + number + " = " + result);
                }
                System.out.println();
            }
        }
    }
}
