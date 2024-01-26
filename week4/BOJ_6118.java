import java.util.*;
import java.io.*;

public class BOJ_6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());

            graph[ai].add(bi);
            graph[bi].add(ai);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] cnt = new int[N+1];
        boolean[] visited = new boolean[N+1];

        int idx = -1;
        int max = -1;
        int max_cnt = -1;
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : graph[curr]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    cnt[next] = cnt[curr] + 1;
                }
            }
        }

        for(int i = 0 ; i <= N ; i++){
            if(cnt[i] > max){
                max = cnt[i];
                idx = i;
                max_cnt = 1;
            }else if(cnt[i] == max){
                max_cnt++;
            }
        }

        System.out.println(idx+" "+cnt[idx]+" "+max_cnt);



    }
}
