import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPath {



    public void insertInGraph(int src, int dest, int time, int cost, Node[] adList,int m)
    {
        Node desti=new Node(dest,cost,time);

        desti.changeD(time*m+cost);
        for(int i=0;i<adList.length;i++)
        {
            if (adList[i].value == src) {
                adList[i].cost = cost;
                adList[i].time = time;
                insertInList(adList[i], desti);
                break;
            }
        }

    }

    public void insertInList(Node head,Node node){
        if(head.next==null){
            head.next=node;
            node.next=null;
            System.out.println("insert after -->"+head.value);
        }
        else{
            insertInList(head.next,node);
        }

    }


    public void sortPriority(Node [] list,int source,int destination,int cost){
        PriorityQueue<Node> neighbours = new PriorityQueue<>(list.length,new CityComparator());
        for(int i=0;i<list.length;i++)
        {
            if(list[i].value==source)
                list[i].d=0;
            neighbours.add(list[i]);
        }
        buildSP(list,neighbours,source,destination,cost,0);

    }

    public void buildSP(Node [] list,PriorityQueue<Node> neighbours,int source, int destination,int cost,int t)
    {

            for(int i=0;i<list.length;i++)
            {

                    Node src = list[neighbours.poll().value - 1];
                if(src.next!=null)
                {
                    Node dest = list[src.next.value - 1];


                    isSmaller(list, src, dest, src.next, cost);


                    neighbours.clear();
                    neighbours.addAll(Arrays.asList(list));
                    for (int j = -1; j < i; j++) {
                        neighbours.poll();
                    }
                }

            }
    }







    public void isSmaller(Node []list,Node src,Node dest,Node next,int cost) {

//        for(int i=0;i<list.length;i++)
//            System.out.println(" ana "+list[i].value+" time bta3y: "+list[i].time+" t bta3y "+list[i].t+"   d bta3y "+list[i].d);

        int calc = 0;
        if (src.parent != null) {

            calc = src.d + next.d + (src.t + 1) * cost;
//            System.out.println("ana "+ next.value+ " 3andy ahl bey2oolo: "+calc+" m3aya:"+next.d);

        }
        else
            {
            calc = src.d + next.d + src.t * cost;
//            System.out.println("ana "+ src.value+ " bey2oolo: "+calc+" ma3aya "+next.d);
            }
        if (calc<dest.d)
        {

            dest.d = calc;
            dest.time=next.time;

            dest.parent = src;
            if(dest.parent.parent!=null)
            dest.t=dest.parent.t+1;
            else
                dest.t=0;

        }
        if(next.nextnotNull())
        {
            isSmaller(list,src, list[next.next.value - 1],next.next, cost);
        }


    }
}
