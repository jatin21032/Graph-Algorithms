import java.io.*;
import java.util.*;
public  class Traversal 
{
public void dfs_util(int v, int[][] graph, boolean visited[], ArrayList<int[]> order)
    {
        visited[v] = true;
        order.add(v);
        for(int i = 0; i < graph[v].size; i++)
            if(graph[v][i] == 1 and (!visisted[i]))
                dfs_util(i, graph, visited, order);
    }

    ArrayList<int[]> dfs(int start, int Vertices, int[][] graph)
    {
        ArrayList<int[]> order;
        boolean visited[] = new boolean[Vertices]; 
        dfs_util(start, graph, visited, order);
        return order;
    }

    ArrayList<int[]> bfs(int start, int Vertices, int[][] graph)
    {
        ArrayList<int[]> order;
        boolean visited[] = new boolean[Vertices]; 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        visited[start]=true;
        queue.add(start);
        
        while (!queue.isEmpty())
        {
            v = queue.get(0);
 
            order.add(v);
            queue.remove(queue.get(0));
 
            for(int i = 0; i < Vertices; i++)
            {
                if (graph[v][i] == 1 && (!visited[i]))
                {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return order;
    }
}

class Main{
    public static void main(String args[]) 
    { 
        int noOfVertices = 3;
        int[][] graph = new int[noOfVertices][noOfVertices];
        //dfs(0, noOfVertices, graph);
        //bfs(0, noOfVertices, graph);
    } 