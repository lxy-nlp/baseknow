package Offer.DataStructure;

import java.util.*;


class Graph
{
//    private final int V;
//    private int E;
//    private Bag<Integer> adj;
//    public Graph(int V)
//    {
//        this.V = V;
//        this.E = 0;
//        adj = (Bag<Integer>[]) new Bag[V];
//        for(int v = 0; v < V; v++)
//        {
//            adj[v] = new Bag<Integer>();
//        }
//    }

}

public class GraphProblem {

//    public void deepFirstSearch(Graph G,int s)
//    {
//        boolean[] marked = new boolean[G.V()];
//        int edgeTo = new int[G.V()];
//        dfs(G,s);
//    }

    public void  dfs(Graph G,int v)
    {
//        marked[v] = true;
//        for(int w:G.adj(v))
//        {
//            if(int w: G.adj(v))
//            {
//                edgeTo[w] = v;
//                dfs(G,w);
//            }
//        }
    }

    // 拓扑排序
    public List<Integer> topologicalSort(int n,int[][] adj)
    {
        List<Integer> topo = new ArrayList();
        int[] inner = new int[n];
        for(int[] parent:adj)
            for(int child : parent)
                inner[child]++;

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        {
            if(inner[i] == 0)
                deque.offer(i);
        }

        while(!deque.isEmpty())
        {
            int cur = deque.poll();
            topo.add(cur);
            for(int child : adj[cur])
            {
                inner[child]--;
                if(inner[child] == 0)
                    deque.offer(child);
            }
        }
        return topo.size() == n ? topo: new ArrayList<>();
    }

    public void DeepFirstSearch()
    {

    }
    public void dfs(int i,boolean[] visited)
    {
        visited[i] = true;
        for(int j = 0; j < visited.length;j++)
        {
            if(visited[j] == false)
                dfs(j,visited);
        }
    }

    public void bfs(int i, boolean[] visited)
    {
        Queue<Integer> note = new LinkedList<>();
    }

}
