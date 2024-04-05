package school;

public enum Level { UNDERGRAD, MASTER, PHD };

public class Level {
    private int value;

    public final static Level UNDERGRAD = new Level(0);
    public final static Level MASTER = new Level(1);
    public final static Level PHD = new Level(2);
    
    private Level(int value) { this.value = value; }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Level other = (Level) obj;
        return this.value == other.value;
    }

    @Override
    public String toString() {
        return switch (value) {
            case 0 -> "UNDERGRAD";
            case 1 -> "MASTER";
            case 2 -> "PHD";
            default -> null;
        };
    }
}

