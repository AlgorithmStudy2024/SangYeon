import java.util.*;
import java.io.*;

public class BOJ_5549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        char[][] map = new char[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] jmap = new int[M+1][N+1];
        int[][] omap = new int[M+1][N+1];
        int[][] imap = new int[M+1][N+1];

        for(int i = 1 ; i < M+1 ; i++){
            for(int j = 1 ; j < N+1 ; j++){
                char curr = map[i-1][j-1];
                if(curr == 'J'){
                    jmap[i][j]++;
                }else if(curr == 'O'){
                    omap[i][j]++;
                }else if(curr == 'I'){
                    imap[i][j]++;
                }
                jmap[i][j] = jmap[i][j-1] + jmap[i-1][j] - jmap[i-1][j-1] + jmap[i][j];
                omap[i][j] = omap[i][j-1] + omap[i-1][j] - omap[i-1][j-1] + omap[i][j];
                imap[i][j] = imap[i][j-1] + imap[i-1][j] - imap[i-1][j-1] + imap[i][j];
            }
        }

        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            sb.append(jmap[rx][ry] - jmap[rx][ly-1] - jmap[lx-1][ry] + jmap[lx-1][ly-1]).append(" ");
            sb.append(omap[rx][ry] - omap[rx][ly-1] - omap[lx-1][ry] + omap[lx-1][ly-1]).append(" ");
            sb.append(imap[rx][ry] - imap[rx][ly-1] - imap[lx-1][ry] + imap[lx-1][ly-1]).append(" ").append("\n");
        }


        System.out.println(sb.toString());

    }
}
