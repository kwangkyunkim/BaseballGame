
import java.util.*;
public class BaseballGame3 {
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

    public static void main(String[] args) {
        int[] CPU = new int[3];
        int[] choice = new int[3];
        int counts = 0;
        System.out.println("시작");
        Random rand = new Random();
        for (int i = 0; i < CPU.length; i++) {
            CPU[i] = rand.nextInt(10);
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("입력을 하세요:");
            int input = sc.nextInt();
            choice[0] = input / 100;
            choice[1] = (input / 10) % 10;
            choice[2] = input % 10;

            int strikes = Strikes(CPU, choice);
            int ball = Ball(CPU, choice);

            counts++;

            System.out.println(counts + "번쨰 시도:" + strikes + "S" + ball + "B");

            if (strikes == 3) {
                System.out.println(counts + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }

        }
        sc.close();

    }


    public static int Strikes(int[] cpu, int[] choice){
        int st=0;
        for(int i = 0;i < cpu.length;i++){
            if(cpu[i]==choice[i]){
                st++;
            }
        }
        return st;
    }
    public static int Ball(int[] cpu, int[] choice){
        int ball=0;
        for(int i = 0;i < cpu.length;i++){
            for(int j = 0;j < choice.length;j++){
                if(cpu[i]==choice[j] && i!=j){
                    ball++;
                }
            }
        }
        return ball;
    }
}
