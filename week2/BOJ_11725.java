import java.util.*;
import java.io.*;

public class BOJ_11725 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 각 노드의 부모를 저장하는 배열
        int[] parent = new int[N+1];

        // 연결 리스트 배열
        ArrayList<Integer>[] a = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            a[i] = new ArrayList<>();
        }

        // 방문 체크
        boolean[] check = new boolean[N+1];

        StringTokenizer st;
        for(int i = 1 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 방향이 없으니까 둘 다 추가
            a[x].add(y);
            a[y].add(x);
        }

        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            // 현재 노드에 있는 다음 노드를 탐색
            for(int next : a[curr]){
                if(check[next])
                    continue;
                check[next] = true;
                queue.add(next);
                // 다음 노드의 부모가 현재 노드라고 표시
                parent[next] = curr;
            }
        }

        for(int i = 2 ; i <= N ; i++){
            System.out.println(parent[i]);
        }


    }
}
