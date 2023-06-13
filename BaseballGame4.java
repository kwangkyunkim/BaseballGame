
import java.util.*;

public class BaseballGame4 {
    public static void main(String[] args) {
        int[] cpu = new int[3]; // 컴퓨터가 뽑은 정답 숫자 배열
        int[] choice = new int[3]; // 사용자가 입력한 추측 숫자 배열
        int attempts = 0; // 시도 횟수

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        Random rand = new Random();
        for (int i = 0; i < cpu.length; i++) {
            cpu[i] = rand.nextInt(10);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("세 자리 숫자를 입력하세요: ");

            // 사용자로부터 세 자리 숫자 입력받기
            int input = scanner.nextInt();
            choice[0] = input / 100;
            choice[1] = (input / 10) % 10;
            choice[2] = input % 10;

            int strikes = countStrikes(cpu, choice); // 스트라이크 개수 계산
            int balls = countBalls(cpu, choice); // 볼 개수 계산

            attempts++; // 시도 횟수 증가

            System.out.println(attempts + "번째 시도 :" + strikes + "S " + balls + "B");

            if (strikes == 3) {
                System.out.println(attempts+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break; // 게임 종료
            }
        }

        scanner.close();
    }

    // 스트라이크 개수를 계산하는 메소드
    public static int countStrikes(int[] cpu, int[] choice) {
        int strikes = 0;

        for (int i = 0; i < cpu.length; i++) {
            if (cpu[i] == choice[i]) {
                strikes++;
            }
        }

        return strikes;
    }

    // 볼 개수를 계산하는 메소드
    public static int countBalls(int[] cpu, int[] choice) {
        int balls = 0;

        for (int i = 0; i < cpu.length; i++) {
            for (int j = 0; j < choice.length; j++) {
                if (cpu[i] == choice[j] && i != j) {
                    balls++;
                }
            }
        }

        return balls;
        // 끝
    }
}

