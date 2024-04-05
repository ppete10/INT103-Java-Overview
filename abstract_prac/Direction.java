package testEnum;

public enum Direction {
    North(0), East(90), south(180), West(270);

    private final int Direction;

    Direction(int direction) {
        Direction = direction;
    }

    public int getDirection() {
        return Direction;
    }
}

class Main2 {
    public static void main(String[] args) {
        for (Direction d : Direction.values()) {
            System.out.println(d + " " + d.getDirection());
        }
    }
}
