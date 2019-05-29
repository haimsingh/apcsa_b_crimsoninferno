public class Game
{
    private Grid grid;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;

    public Game()
    {
        grid = new Grid(100, 100);
        userRow = 0;
        userCol = 0;
        msElapsed = 0;
        timesGet = 0;
        timesAvoid = 0;
        updateTitle();
        grid.setImage(new Location(userRow, 0), "catch.png");
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
    public void handleCollision(Location loc) {
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

