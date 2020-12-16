import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agent {
    private Position position;
    private final int memoireSize = 10;
    private String memorize;
    private Double pGet;
    private Double pPut;

    public void perception(){}

    public  void action(){
        
    }

    public Direction pickedDirection(){
        List<Direction> directions= new ArrayList<>();
        directions.add(Direction.N) ;
        directions.add(Direction.S);
        directions.add(Direction.E);
        directions.add(Direction.O);

        Direction pickedDirection = directions.get(new Random().nextInt(directions.size()));
        return pickedDirection;
    }

    public Position getPosition() {
        return position;
    }

    public String getMemorize() {
        return memorize;
    }

    public Double getpGet() {
        return pGet;
    }

    public Double getpPut() {
        return pPut;
    }
}
