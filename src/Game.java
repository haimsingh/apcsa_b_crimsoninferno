public class Game
{
    private Grid grid;
    private Grid battleField;
    private WavPlayer ora;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;
    private String bgPic = "img//get.gif";
    private String userPic = "get.gif";
    private String enemy = "enemy.gif";

    public Game()
    {
        grid = new Grid(20, 20, bgPic);
        ora = new WavPlayer("ora.wav");
        userRow = 0;
        userCol = 0;
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        updateTitle();
        grid.setImage(new Location(userRow, userCol), userPic);
        grid.setImage(new Location(4, 2), enemy);
    }
    public void play()
    {
        while (!isGameOver())
        {
            grid.pause(100);
            handleKeyPress();
            System.out.println(grid.checkLastKeyPressed());
            if (msElapsed % 300 == 0)
            {
//        scrollLeft();
//        populateRightEdge();
            }
            updateTitle();
            msElapsed += 100;
        }
    }
    public void handleKeyPress() {
        int key = grid.checkLastKeyPressed();

        switch(key){
            case 38 :
                if(userRow > 0) {
                    grid.setImage(new Location(userRow, userCol), null);
                    userRow--;
                    grid.setImage(new Location(userRow, userCol), "get.gif");
                }
                break;
            case 40 :
                if(userRow != grid.getNumRows() - 1) {
                    grid.setImage(new Location(userRow, userCol), null);
                    userRow++;
                    grid.setImage(new Location(userRow, userCol), "get.gif");
                }
                break;
            case 37 :
                if(userCol > 0) {
                    grid.setImage(new Location(userRow, userCol), null);
                    userCol--;
                    grid.setImage(new Location(userRow, userCol), "get.gif");
                }
                break;
            case 39 :
                if(userCol != grid.getNumCols() - 1) {
                    grid.setImage(new Location(userRow, userCol), null);
                    userCol++;
                    grid.setImage(new Location(userRow, userCol), "get.gif");
                }
                break;
            default:
                System.out.println("Invalid Key pressed");
        }
    }
    //  public void populateRightEdge() {
//
//  }
//
//  public void scrollLeft() {
//
//  }

    public void attack(String foe){
        battleField = new Grid(5,5,"BattleBackground.png");
        battleField.setTitle("Player Attack");
        battleField.setImage(new Location(3,1), "jojo.gif");
        battleField.setImage(new Location(3,3), enemy);
        battleField.pause(500);
        battleField.setImage(new Location(3,1), null);
        battleField.setImage(new Location(3,2), "jojo.gif");
        battleField.pause(500);
        battleField.setImage(new Location(3,3), enemy.substring(0,enemy.length()-4)+"Attack.gif");
        ora.startSound();
        battleField.pause(500);
        battleField.setImage(new Location(3,3), null);
        battleField.pause(500);
        battleField.setImage(new Location(3,2), null);
        battleField.setImage(new Location(3,1), "jojo.gif");
        battleField.pause(500);
        battleField.close();

    }

    public void handleCollision(Location loc) {
        if(userCol == loc.getCol() && userRow == loc.getRow()){
            if(grid.getImage(loc).equals("enemy.gif")){
                attack("enemy.gif");

            }
            if(grid.getImage(loc).equals("kono_dio_da.gif")){
                attack("kono_dio_da.gif");
            }


        }

    }
    public int getScore()
    {
        return 0;
    }
    public void updateTitle()
    {
        grid.setTitle("Game:  " + getScore());
    }
    public boolean isGameOver()
    {
        return false;
    }
    public static void test()
    {
        Game game = new Game();
        game.play();
    }
    public static void main(String[] args)
    {
        test();
    }
}
