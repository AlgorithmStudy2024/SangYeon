import java.util.*;
import java.io.*;

public class BOJ_5568 {
    static String[] arr;
    static int N, K;
    static HashSet<String> set = new HashSet<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new String[N];
        check = new boolean[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = br.readLine();
        }

        dfs(0, "");

        System.out.println(set.size());
    }

    public static void dfs(int cnt, String curr){
        if(cnt == K){
            set.add(curr);
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(check[i])
                continue;
            check[i] = true;
            dfs(cnt + 1, curr+arr[i]);
            check[i] = false;
        }
    }
}
