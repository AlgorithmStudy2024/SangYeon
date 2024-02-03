import java.io.*;
import java.util.*;

public class BOJ_1005 {
    public static int[] D, linked;
    public static boolean[][] map;
    public static int N,K,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            D = new int[N+1]; // 건설 시간 배열

            map = new boolean[N+1][N+1];    // 건물 별 연결 여부 배열
            linked = new int[N+1];    // 건물에 연결된 갯수 배열

            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= N ; i++){
                D[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0 ; i < K ; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = true;
                linked[y]++;
            }

            W = Integer.parseInt(br.readLine());

            int result = calc();

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }

    public static int calc(){
        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[N+1];

        // 진입선 없는 노드 찾기
        for(int i = 1 ; i < N+1 ; i++){
            if (linked[i] == 0){
                result[i] = D[i];
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int i = 1 ; i < N+1 ; i++){
                if(map[curr][i]){
                    result[i] = Math.max(result[i], result[curr] + D[i]);
                    --linked[i];

                    if(linked[i] == 0){
                        q.add(i);
                    }
                }

            }
        }

        return result[W];
    }


}
