import java.util.Comparator;

public class CityComparator implements Comparator<Node> {

    public int compare(Node s1, Node s2) {
        if (s1.d < s2.d)
            return -1;
        else if (s1.d > s2.d)
            return 1;
        return 0;
    }
}
