import java.io.*;
import java.util.*;

public class BOJ_2313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N  = Integer.parseInt(br.readLine());
        int total = 0;

        for(int tc = 0 ; tc < N ; tc++){
            int L = Integer.parseInt(br.readLine());
            int[] arr = new int[L];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < L ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = arr[0];
            int m_start = 0;
            int m_end = 0;

            int start = 0;
            int end = 0;

            for(int i = 1 ; i < L ; i++){
                if(arr[i] >= arr[i-1] + arr[i]){
                    start = i;
                    end = i;
                }else {
                    arr[i] = arr[i-1] + arr[i];
                    end = i;
                }

                if(arr[i] > max){
                    max = arr[i];
                    m_start = start;
                    m_end = end;
                } else if(arr[i] == max && m_end - m_start > end - start){
                    max = arr[i];
                    m_start = start;
                    m_end = end;
                }
            }
            total += max;
            sb.append(m_start+1).append(" ").append(m_end+1).append("\n");

        }
        System.out.println(total);
        System.out.println(sb.toString());
    }
}
