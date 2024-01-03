import java.util.*;
import java.io.*;

public class BOJ_2669 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[100][100];

        for(int i = 0 ; i < 4 ; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            for(int a = x1 ; a < x2 ; a++){
                for(int b = y1 ; b < y2 ; b++){
                    if(arr[a][b] != 1){
                        arr[a][b] = 1;
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0 ; i < 100 ; i++){
            for(int j = 0 ; j < 100 ; j++){
//                System.out.print(arr[i][j]+" ");
                if(arr[i][j] == 1){
                    result++;
                }
            }
//            System.out.println();
        }

        System.out.println(result);
    }
}
