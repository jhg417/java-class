import java.util.Scanner;
public class FinalNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int answer = (int) (Math.random() * 99) + 1;
        while (true) {
            System.out.print("숫자 입력(1~100): ");
            int guess = scanner.nextInt();
            if (guess == answer) {
                System.out.println(answer +" 정답입니다!");
                break;
            } else if (guess < answer) {
                System.out.println("더 큰 수를 입력하세요");
                continue;
            } else {
                System.out.println("더 작은 수를 입력하세요");
                continue;
            }
        }
        System.out.println("게임을 종료합니다.");
    }
}