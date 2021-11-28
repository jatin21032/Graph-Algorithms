import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Graphs {
    static ArrayList<int[]> raw_graph = new ArrayList<int[]>();
    static HashMap<Integer,Integer> unique_vertices = new HashMap<Integer,Integer>(); 
    static int startVertex;
     public static  void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\HP\\Dropbox\\PC\\Documents\\IIITD\\FIRST_SEM\\OOPD\\Project\\data\\facebook_combined.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        
        int r=0;
        while ((str = br.readLine()) != null){
            int[]  row = new int[2];
            row[0] = Integer.parseInt(str.split(" ")[0]);
            row[1] = Integer.parseInt(str.split(" ")[1]);
            raw_graph.add(row);
            if(!unique_vertices.containsValue(row[0])){
              unique_vertices.put(r,row[0]);
              r++;
            }
            if(!unique_vertices.containsValue(row[1])){
              unique_vertices.put(r,row[1]);
              r++;
            }
           
           
        }
        //System.out.println("R-----"+r);
        ArrayList<Integer> out = new ArrayList<Integer>();
        Graphs gr = new Graphs();
        BFSTraversal trv = new BFSTraversal();
        out = trv.Traversal(gr.matrixGraph());
        System.out.println("BFS Traveral of Graph "+out);
        
        String fileName = "C:\\Users\\HP\\Dropbox\\PC\\Documents\\IIITD\\FIRST_SEM\\OOPD\\Project\\output\\BFS.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(out.toString());
        
        writer.close();

        APSP apsp = new APSP();
        //apsp.floydWarshall(gr.matrixGraph());
    }

    public Edges[][] matrixGraph(){
      int noOfVertices = unique_vertices.size();
      System.out.println("no of vertices : "+ noOfVertices);
      System.out.println("no of edges : "+ raw_graph.size());
      Edges[][] graph = new Edges[noOfVertices][noOfVertices];
      int k=0;
      while(k<raw_graph.size()){
          int[] r = raw_graph.get(k);
          //System.out.println("adding at row "+r[0]+"and column "+r[1]);
          Vertices v1 = new Vertices();
          Vertices v2 = new Vertices();
          v1.setNodeID(r[0]);
          v2.setNodeID(r[1]);
          Edges e = new Edges(v1,v2);
          
          e.createEdge();
          if(k==0){
            startVertex = 0;
          }
          int x=0,y=0;
         
          for(Entry<Integer, Integer> entry: unique_vertices.entrySet()) {
           if(entry.getValue() == r[0]) {
              x= entry.getKey();
              break;
            }
          }
          for(Entry<Integer, Integer> entry: unique_vertices.entrySet()) {
            if(entry.getValue() == r[1]) {
               y = entry.getKey();
               break;
             }
           }
           //System.out.println("SIZE of X ,Y:::"+x+" "+y);
          graph[x][y] = e;
          k++;
      }
    /*for(int i=0;i<noOfVertices;i++){
        for(int j=0;j<noOfVertices;j++){
          System.out.print(graph[i][j].weight+" ");
        }
          System.out.print("\n");
    }*/
      return graph;
    }
}
