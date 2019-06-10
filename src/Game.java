public class Game
{
    private Grid grid;
    private Grid battleField;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;
    private String bgPic = "img//NOT_DONE.png";
    private String userPic = "img//fruit-catcher-idle.png";

    public Game()
    {
        grid = new Grid(20, 20, bgPic);
        userRow = 0;
        userCol = 0;
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        updateTitle();
        grid.setImage(new Location(userRow, 0), userPic);
    }
    public void play()
    {
        while (!isGameOver())
        {
            grid.pause(100);
            handleKeyPress();
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
                userRow--;
                break;
            case 40 :
                userRow++;
                break;
            case 37 :
                userCol--;
                break;
            case 39 :
                userCol++;
                break;
        }
    }
    //  public void populateRightEdge() {
//
//  }
//
//  public void scrollLeft() {
//
//  }

    public void attack(){
        battleField = new Grid(5, 5);
        battleField.setTitle("Battle");
    }

    public void handleCollision(Location loc) {
        if(userCol == loc.getCol() && userRow == loc.getRow()){
            if(grid.getImage(loc).equals("enemy.gif")){
                Grid battle = new Grid(5,5);

            }
            if(grid.getImage(loc).equals("kono_dio_da.gif")){

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

