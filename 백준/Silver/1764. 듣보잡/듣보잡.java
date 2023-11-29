import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(br.readLine(), 1);
        }
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String ms = br.readLine();
            map.put(ms, map.getOrDefault(ms, 0) + 1);
            if(map.get(ms) == 2){
                list.add(ms);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String as : list){
            System.out.println(as);
        }
    }
}