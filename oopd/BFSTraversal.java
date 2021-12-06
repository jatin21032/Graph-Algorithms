/**This File is performing BFS traversal by Implementing methods of interface Traversal.
 * Also file is defining the interface Traversal.
 * This class file features the concepts of INHERITENCE and ABSTRACTION by implementing abstract function(GraphTraversal) of an interface.
 */
package oopd;
import java.util.ArrayList;

//Interface
interface Traversal {
    public int startVertex = 10;
    public ArrayList < Integer > GraphTraversal(Edges[][] e);
}

//Class implementing interface
public class BFSTraversal implements Traversal {

    //This function is performing traversal in DFS manner by overriding the interface abstract method.
    @Override
    public ArrayList < Integer > GraphTraversal(Edges[][] AdjMatrix) {

        ArrayList < Integer > outputlist = new ArrayList < Integer > ();
        int[] visited = new int[Graphs.unique_vertices.size()];
        ArrayList < Integer > queue = new ArrayList < Integer > ();
        //Taking queue datastructure to performing traversal
        queue.add(startVertex);
        visited[10] = 1;

        int curr;
        try {
            while (!queue.isEmpty()) {
                curr = queue.get(0);

                // Adding the current node into list
                outputlist.add(Graphs.unique_vertices.get(curr));
                queue.remove(queue.get(0));
                for (int i = 0; i < Graphs.unique_vertices.size(); i++) {

                    try {
                        if (AdjMatrix[curr][i] != null) {
                            if (AdjMatrix[curr][i].weight == 1 && (visited[i] == 0)) {

                                queue.add(i);
                                visited[i] = 1;
                            }
                        }
                    } catch (Exception e) {

                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error while traversing graph!!" + e);
        }
        return outputlist;
    }





}