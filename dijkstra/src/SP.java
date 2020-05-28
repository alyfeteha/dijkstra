import java.util.Scanner;

public class SP {
    public static void main(String[] args) {
        kestraRun();

    }

    private static void kestraRun()
    {
        ShortestPath shortp = new ShortestPath();
        System.out.println("Enter cost M:\n");
        Scanner input1 = new Scanner(System.in);
        int m = input1.nextInt();

        System.out.println("Enter number of cities:\n");
        Scanner input2 = new Scanner(System.in);
        int cities = input2.nextInt();

        System.out.println("Enter number of routes:\n");
        Scanner input3 = new Scanner(System.in);
        int routes = input3.nextInt();

        System.out.println("Enter source , destination , time and cost:\n");
        Scanner s = new Scanner(System.in);

        Scanner d = new Scanner(System.in);

        Scanner t = new Scanner(System.in);

        Scanner c = new Scanner(System.in);


        Node[] adList = new Node[cities];

        for (int z = 0; z < cities; z++) {
            adList[z] = new Node(z + 1, 0, 0);
        }

        for (int i = 0; i < routes; i++) {
            int sr = s.nextInt();
            int des = d.nextInt();
            int time = t.nextInt();
            int cost = c.nextInt();

            shortp.insertInGraph(sr, des, time, cost, adList, m);

        }


        System.out.println("Enter source city:\n");
        Scanner input4 = new Scanner(System.in);
        int source = input4.nextInt();


        System.out.println("Enter desitnation city:\n");
        Scanner input5 = new Scanner(System.in);
        int destination = input5.nextInt();
        shortp.sortPriority(adList,source,destination,m);
        int totalTime=0;
        adList[source-1].time=0;
        totalTime=printPath(adList[destination-1],totalTime);



//        System.out.println("topman time="+adList[source-1].time);
        System.out.println("price= $"+adList[destination-1].d);
        totalTime+=adList[destination-1].t;
        System.out.println("time= "+totalTime);



    }
    public static int printPath(Node dest,int time)
    {

        if(dest.parent!=null)
        {

            time=printPath(dest.parent,time)+dest.time;
        }
        System.out.println("-->"+dest.value);
        return time;
    }
    public static void printAll(Node head)
    {

            System.out.println("->"+head.value);
            if (head.next!=null)
                printAll(head.next);

    }
}


