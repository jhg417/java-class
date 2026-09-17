import java.util.Arrays;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] original = {10, 20, 30};
        int[] longer = Arrays.copyOf(original, 5);
        int[] shorter = Arrays.copyOf(original, 2);
// longer: [10, 20, 30, 0, 0]
// shorter: [10, 20]
    }
}