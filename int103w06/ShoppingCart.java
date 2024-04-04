package market;

import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart<G> {
    private Map<G, Integer> m;

    public ShoppingCart() {
        m = new TreeMap<>();
    }

    public int add(G g) {
        var x = m.get(g);
        if (x == null) x = 0;
        x++;
        m.put(g, x);
        return x;
    }

    public int remove(G g) {
        var x = m.remove(g);
        return x == null ? 0 : x;
    }

    public Set<G> getAll() {
        return m.keySet();
    }

    public int get(G g) {
        var x = m.get(g);
        return x == null ? 0 : x;
    }
}
