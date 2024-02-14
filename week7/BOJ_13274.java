import java.util.*;
import java.io.*;

public class BOJ_13274 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr= new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long[] temp = new long[N];

        for(int i = 0 ; i < K ; i++){
            int idx = 0;
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()) - 1;
            int R = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int curr = L;

            for(int j = 0 ; j < L ; j++){
                while (curr < R && arr[curr] + X <= arr[j]){
                    temp[idx++] = arr[curr++] + X;
                }
                temp[idx++] = arr[j];
            }

            for(int j = R ; j < N ; j++ ){
                while(curr < R && arr[curr] + X <= arr[j]){
                    temp[idx++] = arr[curr++] + X;
                }
                temp[idx++] = arr[j];
            }
            while(curr < R){
                temp[idx++] = arr[curr++] + X;
            }

            for(int j = 0 ; j < N ; j++){
                arr[j] = temp[j];
            }
        }

        System.out.println(Arrays.toString(arr).replaceAll("\\[", "").replaceAll("\\]","").replaceAll(",\\s"," "));

    }
}
