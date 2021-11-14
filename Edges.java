public class Edges extends Vertices{
int start;
int end;
int weight;

Edges(int start, int end , int weight){
    super(weight);
    this.start = start;
    this.end = end;
    this.weight = weight;
}

}