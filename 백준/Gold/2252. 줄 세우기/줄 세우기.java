import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);
        
        int[] count = new int[n + 1];
        List<Integer>[] nodes = new ArrayList[n + 1];
        
        for(int i = 0; i <= n; i++){
            nodes[i] = new ArrayList();
        }
        for(int i = 0; i < m; i++){
            String[] AB = br.readLine().split(" ");
            int a = Integer.parseInt(AB[0]);
            int b = Integer.parseInt(AB[1]);
            nodes[a].add(b);
            count[b]++;
        }
        
        Queue<Integer> queue = new PriorityQueue();
        for(int i = 1; i<= n; i++){
            if(count[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node).append(" ");
            
            List<Integer> now = nodes[node];
            for(int i = 0; i < now.size(); i++){
                count[now.get(i)]--;
                if(count[now.get(i)]==0){
                    queue.offer(now.get(i));
                }
            }
        }
        System.out.println(sb);
        
    }
}