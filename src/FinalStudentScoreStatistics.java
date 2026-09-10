import java.util.Scanner;
public class FinalStudentScoreStatistics {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int studentCount = scanner.nextInt();

        if(studentCount <= 0) { // 예외 처리
            System.out.println("1명 이상 입력하세요.");
        } else {
            int validCount = 0;
            int totalScore = 0;
            int maxScore = 0;
            int minScore = 100;

            int aCount = 0;
            int bCount = 0;
            int cCount = 0;
            int dCount = 0;
            int fCount = 0;

            while(validCount<studentCount) {
                int number = validCount + 1;
                System.out.println(number + "번 점수: ");
                int score = scanner.nextInt();
                validCount++;

                if(score > 100 || score < 0){
                    System.out.println("0~100까지만 입력하세요.");
                    continue;
                }
                totalScore += score;

                if (score > maxScore){
                    maxScore = score; //현재 score가 maxScore보다 클때 현재 score를 maxscore에 대입
                }
                if (score < minScore){
                    minScore = score; //현재 score가 minScore보다 클때 현재 score를 minscore에 대입
                }
                if(score>=95){
                    aCount++;
                } else if (score>=80){
                    bCount++;
                } else if (score>=70){
                    cCount++;
                } else if (score>=60){
                    dCount++;
                } else{
                    fCount++;
                }
            }
            double average = (double)totalScore / studentCount;

            System.out.println("합계: " + totalScore);
            System.out.printf("평균: %.1f%n",average);
            System.out.println("최고점: " + maxScore);
            System.out.println("최저점: " + minScore);

            System.out.printf("A: %d명%n", aCount);
            System.out.printf("B: %d명%n", bCount);
            System.out.printf("C: %d명%n", cCount);
            System.out.printf("D: %d명%n", dCount);
            System.out.printf("F: %d명%n", fCount);
        }
        scanner.close();
    }
}
