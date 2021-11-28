import java.util.*;
import java.io.*;
public class Karan {
    HashSet<Integer> vertices = new HashSet<>();
    Edges[] create_graph()throws Exception{
        int c=0,st=0;
        File file = new File("D:\\OOPD_Project\\Graphs.txt\\Graph1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while(br.readLine()!=null){
            st++;
        }
        Edges edge_arr[] = new Edges[st];
        while((str = br.readLine())!=null){
            int s = Integer.parseInt(str.split("")[0]);
            int e = Integer.parseInt(str.split("")[1]);
            vertices.add(s);
            vertices.add(e);
            Edges ob = new Edges(e,s);
            edge_arr[c++] = ob;
        }
        return edge_arr;
    }
    int[][] create_adjacency_matrix(Edges[] edge_arr){
        int num_edges = edge_arr.length;
        int v = this.vertices.size();
        int ad_matrix[][] = new int[v][v];

        for(int i=0;i<num_edges;i++){
            Edges ob = edge_arr[i];
            int a = ob.get_from_node_id();
            int b = ob.get_to_node_id();
            ad_matrix[a][b]=ob.weight;
        }
        return ad_matrix;
    }

}