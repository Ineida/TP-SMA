import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Environnement {
    private  String[][] grid;
    private  int sizeGrid;
    private  int i;
    private double kPlus;
    private  double kMinus;
    ///20 agents
    private Agent[][] agents;
    private int nA;
    private int nB;
    private int nbAgents;
    private  Random random;

    public Environnement(int sizeGrid, int i, Double kPlus, Double kMinus, int nA, int nB, int nbAgents) {
        this.nA = nA;
        this.nB = nB;
        this.nbAgents = nbAgents;
        this.sizeGrid = sizeGrid;
        this.i = i;
        this.kMinus = kMinus;
        this.kPlus= kPlus;

        this.random = new Random();

        this.grid = new String[sizeGrid][sizeGrid];
        for (int j = 0; j< nB; j++) {
                addElement("B");
        }
        for (int j = 0; j < nB; j++) {
            addElement("A");
        }

        for (int j = 0; j < nbAgents;j++) {
            placeAgent(new Agent());
        }
    }

    public Environnement(){
        this(50, 1, 0.1, 0.3, 200,200, 20);
    }

    private void addElement( String object){
        int x = random.nextInt(sizeGrid);
        int y = random.nextInt(sizeGrid);
        while (hasObject(x,y)){
          x = random.nextInt(sizeGrid);
          y = random.nextInt(sizeGrid);
        }
        grid[x][y] = object;
    }

    private void placeAgent(Agent agent){
        int x = random.nextInt(sizeGrid);
        int y = random.nextInt(sizeGrid);
        while (hasAgent(x, y))  {
            x = random.nextInt(sizeGrid);
            y = random.nextInt(sizeGrid);
        }
        agents[x][y] = agent;
    }

    private boolean hasAgent(int x, int y){
        return  agents[x][y]  != null;
    }

    private boolean hasObject(int x, int y){
        return grid[x][y].equals("A") || grid[x][y].equals("B");
    }

    private boolean isDirectionAvailable(Agent agent, Direction direction){
        int nextX = agent.getPosition().getX() + direction.getMove().getValue0();
        int nextY = agent.getPosition().getY() + direction.getMove().getValue1();
        if (nextX < 0 || nextY < 0 || nextY >= sizeGrid || nextX >= sizeGrid){
            return false;
        }

        return hasAgent(nextX, nextY);
    }

    public List<Direction> availableDirection(Agent agent){
        List<Direction> availableDirection = new ArrayList<>();
        Direction N = Direction.N;
        Direction S = Direction.S;
        Direction E = Direction.E;
        Direction O = Direction.O;
        if( isDirectionAvailable(agent, N)){
            availableDirection.add(N);

        }if (isDirectionAvailable(agent, S)){
            availableDirection.add(S);

        }if (isDirectionAvailable(agent, E)){
            availableDirection.add(E);

        }if (isDirectionAvailable(agent, O)){
            availableDirection.add(O);
            
        }
        return availableDirection;
    }
}
