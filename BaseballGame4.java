
import java.util.*;

public class BaseballGame4 {
    public static void main(String[] args) {
        int[] answer = new int[3]; // 컴퓨터가 뽑은 정답 숫자 배열
        int[] guess = new int[3]; // 사용자가 입력한 추측 숫자 배열
        int attempts = 0; // 시도 횟수

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        Random rand = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < answer.length; i++) {
            int randomNumber = rand.nextInt(10);
            set.add(randomNumber);
        }
        int a = 0;
        for (int number : set) {
            answer[a] = number;
            a++;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("세 자리 숫자를 입력하세요: ");
            // 사용자로부터 세 자리 숫자 입력받기
            int input = scanner.nextInt();
            guess[0] = input / 100;
            guess[1] = (input / 10) % 10;
            guess[2] = input % 10;

            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < answer.length; i++) {
                if (answer[i] == guess[i]) {
                    strikes++;
                } else {
                    for (int j = 0; j < guess.length; j++) {
                        if (answer[i] == guess[j] && i != j) {
                            balls++;
                        }
                    }
                }
            }
            attempts++; // 시도 횟수 증가

            System.out.println(attempts + "번째 시도 :" + strikes + "S " + balls + "B");

            if (strikes == 3) {
                System.out.println(attempts + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break; // 게임 종료
            }
        }
        scanner.close();
    }
}
