/**This Class represent the Edges class where we are inheriting the Vertices class. We are using functions and properties of Vertices class through this.
 * 
 */
package oopd;
public class Edges extends Vertices {
    Vertices start;
    Vertices end;
    public int weight = 0;

    //constructor to initialise data members
    Edges(Vertices start, Vertices end) {
        super();
        this.start = start;
        this.end = end;
        this.weight = 0;
    }

    //Function to get Vertex from NodeID specified. 
    //Here we are using the function getNodeID from the VErtices class
    public Vertices getNodefromID(int id) {
        if (start.getNodeID() == id) {
            return start;
        } else {
            return end;
        }

    }
    //This function creating edge between the two vertices on edge object by assigning the weight 1
    public void createEdge() {
        this.weight = 1;
    }

}