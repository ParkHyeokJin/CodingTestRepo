import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = br.readLine().split(" ");
        int v = Integer.parseInt(VE[0]);
        int e = Integer.parseInt(VE[1]);
        int k = Integer.parseInt(br.readLine());

        int[] answer = new int[v + 1];              //각 노드에서 최단거리를 입력할 결과 배열 (시작노드는 0으로, 나머지는 무한대(∞)로 입력한다.)
        Arrays.fill(answer, Integer.MAX_VALUE);     //가장 큰값으로 초기화

        boolean[] visited = new boolean[v + 1];     //방문 정보관리
        List<Node>[] nodes = new ArrayList[v+1];    //2차원 배열을 생성 하여 그래프 정보를 입력한다.
        for(int i = 0; i <= v; i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i ++){
            String[] SEV = br.readLine().split(" ");
            int sn = Integer.parseInt(SEV[0]);
            int en = Integer.parseInt(SEV[1]);
            int vn = Integer.parseInt(SEV[2]);

            nodes[sn].add(new Node(en, vn));
        }

        Dijkstra(visited, nodes, answer, k);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < answer.length; i++){
            if(answer[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void Dijkstra(boolean[] visited, List<Node>[] nodes, int[] answer, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(k, 0));
        answer[k] = 0; //시작 노드는 0으로 초기화.
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if(visited[curNode.end]){
                continue;   //방문한 노드이면 패스.
            }
            visited[curNode.end] = true;       //방문 체크
            for(Node nextNode : nodes[curNode.end]){
                if(answer[nextNode.getEnd()] > answer[curNode.getEnd()] + nextNode.weight){
                    answer[nextNode.getEnd()] = answer[curNode.getEnd()] + nextNode.weight;    //가중치 업데이트
                    queue.add(new Node(nextNode.getEnd(), answer[nextNode.getEnd()]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        private int end;
        private int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}