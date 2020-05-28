public class Node {


    public int value=0;
    public int cost=0;
    public int time=0;
    public int d=10000;
    public Node next=null;
    public Node parent=null;
    public int t=0;

    public Node(int value,int cost,int time){
        this.value=value;
        this.cost=cost;
        this.time=time;

    }
    public void changeD(int dval)
    {
        this.d=dval;
    }
    public boolean nextnotNull()
    {
        if (this.next==null)
            return false;
        else
            return true;
    }
}
