
import java.io.*;
import java.util.*;

public class BaseballGame2 {
    public static void main(String[] args) {
        int[] answer = CPU();  // 컴퓨터가 뽑은 정답 숫자 배열
        int[] guess = new int[3];  // 사용자가 입력한 추측 숫자 배열
        int attempts = 0;  // 시도 횟수

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("세 자리 숫자를 입력하세요: ");

            // 사용자로부터 세 자리 숫자 입력받기
            try {
                String input = reader.readLine();
                guess[0] = Character.getNumericValue(input.charAt(0));
                guess[1] = Character.getNumericValue(input.charAt(1));
                guess[2] = Character.getNumericValue(input.charAt(2));
            } catch (IOException e) {
                e.printStackTrace();
            }

            int strikes = Strike(answer, guess);  // 스트라이크 개수 계산
            int balls = Ball(answer, guess);  // 볼 개수 계산

            attempts++;  // 시도 횟수 증가

            System.out.println(attempts + "번째 시도 :" + strikes + "S " + balls + "B");

            if (strikes == 3) {
                System.out.println(attempts+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;  // 게임 종료
            }
        } try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[] CPU() {
        int[] answer = new int[3];
        Random random = new Random();
        for (int i = 0; i < answer.length; i++) {
            answer[i] = random.nextInt(10);  // 0부터 9까지의 무작위 숫자
        }

        return answer;
    }
    public static int Strike(int[] answer, int[] guess) {
        int strikes = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == guess[i]) {
                strikes++;
            }
        } return strikes;
    }
    public static int Ball(int[] answer, int[] guess) {
        int balls = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < guess.length; j++) {
                if (answer[i] == guess[j] && i != j) {
                    balls++;
                }
            }
        } return balls;
    }
}

