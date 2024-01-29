import java.io.*;

public class BOJ_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int times = 0 ; times < T ; times++){
            int number = Integer.parseInt(br.readLine());
            int result = gold(number);

            sb.append(result).append(" ").append(number - result).append("\n");

        }

        System.out.println(sb.toString());

    }

    public static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) // 소수가 아닐 경우
                return false;
        }
        return true;
    }

    public static int gold(int num){
        int answer = 0;
        for(int i = num / 2 ; i >= 0 ; i--){
            if(isPrime(i)){
                if(isPrime(num-i)){
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}
