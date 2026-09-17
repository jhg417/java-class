import java.util.Scanner;

class StudentEntry {
    String studentId;
    String name;
}

public class FinalEventCheckIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentEntry[] entries = new StudentEntry[5];

        while (true) {
            System.out.println("\n[취업 특강 접수]");
            System.out.println("1 신청 2 명단 3 취소 4 현황 0 종료");
            System.out.print("선택: ");
            String menu = scanner.nextLine().trim();

            if (menu.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case "1":
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine().trim();
                    System.out.print("이름: ");
                    String name = scanner.nextLine().trim();

                    if (studentId.isEmpty() || name.isEmpty()) {
                        System.out.println("학번과 이름을 입력하세요.");
                        break;
                    }

                    boolean duplicate = false;
                    for (StudentEntry entry : entries) {
                        if (entry != null && entry.studentId.equals(studentId)) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (duplicate) {
                        System.out.println("해당학번은 이미 신청 완료되었습니다.");
                        break;
                    }

                    int emptyIndex = -1;
                    for (int i = 0; i < entries.length; i++) {
                        if (entries[i] == null) {
                            emptyIndex = i;
                            break;
                        }
                    }
                    if (emptyIndex == -1) {
                        System.out.println("마감되었습니다.");
                        break;
                    }

                    StudentEntry newEntry = new StudentEntry();
                    newEntry.studentId = studentId;
                    newEntry.name = name;
                    entries[emptyIndex] = newEntry;
                    System.out.println(name + " 학생의 신청이 완료되었습니다.");
                    break;

                case "2":
                    int displayed = 0;
                    for (int i = 0; i < entries.length; i++) {
                        if (entries[i] != null) {
                            displayed++;
                            System.out.println((i + 1) + "번: "
                                    + entries[i].studentId + " " + entries[i].name);
                        }
                    }
                    if (displayed == 0) {
                        System.out.println("등록된 신청자가 없습니다.");
                    }
                    break;

                case "3":
                    System.out.print("취소할 학번: ");
                    String cancelId = scanner.nextLine().trim();
                    int cancelIndex = -1;
                    for (int i = 0; i < entries.length; i++) {
                        if (entries[i] != null
                                && entries[i].studentId.equals(cancelId)) {
                            cancelIndex = i;
                            break;
                        }
                    }
                    if (cancelIndex == -1) {
                        System.out.println("해당 학번의 신청이 없습니다.");
                    } else {
                        String cancelledName = entries[cancelIndex].name;
                        entries[cancelIndex] = null;
                        System.out.println(cancelledName + " 학생의 신청을 취소했습니다.");
                    }
                    break;

                case "4":
                    int count = 0;
                    for (StudentEntry entry : entries) {
                        if (entry != null) {
                            count++;
                        }
                    }
                    System.out.println("현재 신청: " + count + "명");
                    System.out.println("남은 자리: " + (entries.length - count) + "명");
                    break;

                default:
                    System.out.println("0부터 4까지 선택하세요.");
            }
        }
    }
}