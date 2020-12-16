import org.javatuples.Pair;

public enum Direction {
    N("North", new Pair<>(-1,0)),
    S("south", new Pair<>(1,0)),
    E("East", new Pair<>(0,-1)),
    O("Western", new Pair<>(0,1)) ;
    private String direction;
    private Pair<Integer, Integer> move;

    Direction(String direction, Pair<Integer, Integer> move) {
        this.direction = direction;
        this.move = move;
    }

    public String getDirection() {
        return direction;
    }

    public Pair<Integer, Integer> getMove() {
        return move;
    }
}
