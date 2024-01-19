import java.util.*;
import java.io.*;

public class BOJ_12101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<String>[] ans = new ArrayList[11];
        for(int i = 0 ; i < 11 ; i++){
            ans[i] =  new ArrayList<String>();
        }

        ans[1].add("1");

        ans[2].add("1+1");
        ans[2].add("2");

        ans[3].add("1+1+1");
        ans[3].add("1+2");
        ans[3].add("2+1");
        ans[3].add("3");

        for(int i = 4 ; i <= N ; i++){
            for(int j = 1; j <= 3 ; j++){
                for(String s : ans[i-j]){
                    ans[i].add(j+"+"+s);
                }
            }
        }

        if(ans[N].size() >= K){
            System.out.println(ans[N].get(K-1));
        }else {
            System.out.println(-1);
        }

    }
}
