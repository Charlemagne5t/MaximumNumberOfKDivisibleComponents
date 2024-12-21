import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    int res = 1;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        Node root = new Node(0, values[0]);
        
        
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            vis[cur.num] = true;
            List<Integer> neighbours = g.get(cur.num);
            for(Integer neig : neighbours) {
                if(!vis[neig]) {
                    vis[neig] = true;
                    Node next = new Node(neig, values[neig]);
                    q.offer(next);
                    cur.children.add(next);
                }
            }
        }
        sum(root, k);
        print(root);

        

        return res;

    }
    int sum(Node node, int k) {
        node.sum = node.val;
        for(Node child : node.children) {
            node.sum += sum(child, k);
        }
        if(node.num % k == 0) {
            res++;
            return 0;
        }
        return node.sum;
    }
    void print(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println("Node # " + cur.num + " val: " + cur.val + " ||||| sum :  " + cur.sum);
            for(Node child : cur.children) {
                q.offer(child);
            }
        }
    }
}

class Node {
    int num;
    int val;
    int sum = 0;
    
    List<Node> children = new ArrayList<>();
    Node(int  num, int val) {
        this.val = val;
        this.num = num;
    }
}