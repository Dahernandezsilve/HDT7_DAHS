import java.util.Comparator;

public class TextComparator<K> implements Comparator<K> {

    @Override
    public int compare(K o1, K o2) {
        String p1 = o1.toString();
        String p2 = o2.toString();
        return 0;
    }
}
