import java.io.*;
import java.util.*;

public class BOJ_15666 {
    static int N, M;
    static int[] arr, save;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        save = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb.toString());

    }

    public static void dfs(int start, int depth){
        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(save[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;    // 똑같은 수열이 나오는 것을 막기 위해 선언
        for(int i = start ; i < N ; i++){
            int now = arr[i];
            if(now != before){
                before = now;
                save[depth] = arr[i];
                dfs(i, depth+1);
            }
        }

    }
}
