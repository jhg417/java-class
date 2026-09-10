import java.util.Scanner;

public class FinalOrderKiosk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coffeeCount = 0;
        int sandwichCount = 0;
        int waterCount = 0;
        int orderAmount = 0;
        boolean paid = false;

        orderLoop:
        while (true) {
            System.out.println("\n===== 학과 행사 간식 주문 =====");
            System.out.println("1. 커피 2,500원");
            System.out.println("2. 샌드위치 4,500원");
            System.out.println("3. 생수 1,000원");
            System.out.println("4. 결제");
            System.out.println("0. 주문 취소");
            System.out.print("메뉴를 선택하세요: ");

            int menu = scanner.nextInt();

            if (menu == 1 || menu == 2 || menu == 3) {
                String productName = switch (menu) {
                    case 1 -> "커피";
                    case 2 -> "샌드위치";
                    default -> "생수";
                };

                int price = switch (menu) {
                    case 1 -> 2500;
                    case 2 -> 4500;
                    default -> 1000;
                };

                int quantity;
                do {
                    System.out.print("수량: ");
                    quantity = scanner.nextInt();

                    if (quantity < 1) {
                        System.out.println("수량은 1개 이상이어야 합니다.");
                    }
                } while (quantity <= 0);

                if (menu == 1) {
                    coffeeCount += 1;
                } else if (menu == 2) {
                    sandwichCount += 1;
                } else {
                    waterCount += 1;
                }

                orderAmount += price * quantity;
                System.out.println(productName + " " + quantity + "개를 담았습니다.");
                System.out.println("현재 주문 금액: " + orderAmount + "원");
                continue;
            }

            if (menu == 4) {
                // TODO 9: 담은 상품이 하나도 없는 경우를 판별한다.
                if (coffeeCount < 1 && sandwichCount < 1 && waterCount < 1) {
                    System.out.println("먼저 상품을 선택하세요.");
                    continue;
                }

                int discountRate;

                // TODO 10: 주문 금액에 맞는 할인율을 결정한다.
                if (orderAmount >= 50000) {
                    discountRate = 10;
                } else if (orderAmount >= 30000) {
                    discountRate = 5;
                } else {
                    discountRate = 0;
                }

                // TODO 11: 할인 금액과 최종 결제 금액을 계산한다.
                int discountAmount = orderAmount * discountRate / 100;
                int paymentAmount = orderAmount - discountAmount;

                System.out.println();
                System.out.println("커피: " + coffeeCount + "개");
                System.out.println("샌드위치: " + sandwichCount + "개");
                System.out.println("생수: " + waterCount + "개");
                System.out.println("주문 금액: " + orderAmount + "원");
                System.out.println("할인율: " + discountRate + "%");
                System.out.println("할인 금액: " + discountAmount + "원");
                System.out.println("결제 금액: " + paymentAmount + "원");

                // TODO 13: 결제 완료 상태를 기록한다.
                paid = true;
                break orderLoop;
            }

            // TODO 14: 주문 취소 메뉴를 선택한 경우의 조건을 작성한다.
            if (menu == 0) {
                break orderLoop;
            }

            System.out.println("0부터 4까지의 메뉴 번호를 입력하세요.");
        }

        if (paid) {
            System.out.println("결제가 완료되었습니다.");
        } else {
            System.out.println("주문을 취소했습니다.");
        }
        scanner.close();
    }
}

