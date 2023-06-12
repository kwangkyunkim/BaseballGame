
import java.util.*;
//- 컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759
//        - 사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.
//        - 컴퓨터는 사용자가 입력한 세자리 숫자에 대해서, 아래의 규칙대로 스트라이크(S)와 볼(B)를 알려줍니다.
//        - 숫자의 값과 위치가 모두 일치하면 S
//        - 숫자의 값은 일치하지만 위치가 틀렸으면 B
//        - 기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록됩니다.
//        - 숫자 3개를 모두 맞춘 경우, 게임을 종료합니다.

//- Java, JS에서 랜덤하게 숫자를 만드는 함수는 여러가지 방법이 있습니다.
//        - 참고 키워드) Java 랜덤 숫자 생성, Javascript 랜덤 숫자 생성
//        - 3자리수가 모두 달라야하기 때문에, 889, 282등의 숫자가 나오면 안되겠죠? 여러가지 방법을 생각해보세요.
//        - 구현은 아래와 같은 순서로 진행해보세요.
//        1. 랜덤 숫자 만들기
//        2. 한자리 숫자에 대해 볼, 스크라이크 판단 하는 부분 구현하기
//        3. 볼, 스트라이크를 표현하는 부분 구현하기
//        4. 게임 종료하는 부분 구현하기

// 1. 생성값 ,입력값 배열선언
// 2. 시도횟수 -> int 초기화
// 3. 시도+출력 = while=문 // 계산 메소드 = for-문
// 4. 인스턴스 메소드(계산 메소드) 부터 생성
// 5. 인스턴스를 사용하여 class를 작동

public class BaseballGame {
    public static void main(String[] args) {
        int[] answer = CPU();  // 컴퓨터가 뽑은 정답 숫자 배열
        int[] guess = new int[3];  // 사용자가 입력한 추측 숫자 배열
        int attempts = 0;  // 시도 횟수

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("세 자리 숫자를 입력하세요: ");

            // 사용자로부터 세 자리 숫자 입력받기
            int input = scanner.nextInt();
            guess[0] = input / 100;
            guess[1] = (input / 10) % 10;
            guess[2] = input % 10;

            int strikes = Strike(answer, guess);  // 스트라이크 개수 계산
            int balls = Ball(answer, guess);  // 볼 개수 계산

            attempts++;  // 시도 횟수 증가

            System.out.println(attempts + "번째 시도 :" + strikes + "S " + balls + "B");

            if (strikes == 3) {  // 스트라이크 3번이면 종료를 출력 후 반복종료(break)
                System.out.println(attempts+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;  // 게임 종료
            }
        } scanner.close();
    }

    // 1. 랜덤 숫자 만들기
    public static int[] CPU() {
        int[] answer = new int[3];  // 여기서 answer은 전역변수가 아니라서 메소드 cpu 안에서만 작동한다 .
        Random cpu = new Random();  // Random 메소드는 배열의 길이(3) 안에서 무작위로 생성

        for (int i = 0; i < answer.length; i++) {
            answer[i] = cpu.nextInt(10);  // 0부터 9까지의 int-형식의 무작위 숫자
        }

        return answer;
    }
    // 스트라이크 개수를 계산하는 메소드 // 순서까지 맞으면 strikes++
    public static int Strike(int[] answer, int[] guess) {
        int strikes = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == guess[i]) {
                strikes++;
            }
        } return strikes;
    }
    // 볼 개수를 계산하는 메소드 // guess 배열 중 하나라도 맞으면 ball
    public static int Ball(int[] answer, int[] guess) {
        int balls = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < guess.length; j++) { // 순서가 같으면 안되니까 이중포문으로 ..
                if (answer[i] == guess[j] && i != j) { // 순서가 같은 경우는 제외 ( 스트라이크니까 중복삭제 )
                    balls++;
                }
            }
        } return balls;
    }
}
