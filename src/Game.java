
import java.util.Scanner;

public class Game
{
    private Grid grid;
    private Grid battleField;
    private WavPlayer ora;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private boolean wannaStart = false;
    private String bgPic = "img//bIG_mOOD.png";
    private String userPic = "img//jojo.gif";
    private String enemy = "img//enemy.gif";

    public Game() {
        titleScreen();
        if(wannaStart){
            grid = new Grid(20, 20, bgPic);
            ora = new WavPlayer("ora.wav");
            userRow = 18;
            userCol = 10;
            msElapsed = 0;
            updateTitle();
            grid.setImage(new Location(userRow, userCol), userPic);
            grid.setImage(new Location(4, 2), enemy);
        }
    }

    public void play() {

        while (!isGameOver()) {
            grid.pause(100);
            handleKeyPress();
//            System.out.println(grid.checkLastKeyPressed());
            if (msElapsed % 300 == 0) {
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
                System.out.println(38);
                if(userRow > 0) {
                    if(userRow != 0){
                        if(equalsWithNulls(grid.getImage(new Location(userRow - 1, userCol)), enemy)){
                            attack(enemy);
                        }
                    }
                    grid.setImage(new Location(userRow, userCol), null);
                    userRow--;
                    grid.setImage(new Location(userRow, userCol), userPic);
                }
                break;
            case 40 :
                System.out.println(40);
                if(userRow != grid.getNumRows() - 1) {
                    if(equalsWithNulls(grid.getImage(new Location(userRow + 1, userCol)), enemy)){
                        attack(enemy);
                    }

                    grid.setImage(new Location(userRow, userCol), null);
                    userRow++;
                    grid.setImage(new Location(userRow, userCol), userPic);
                }
                break;
            case 37 :
                System.out.println(37);
                if(userCol > 0) {
                    if(userCol != 0){
                        if(equalsWithNulls(grid.getImage(new Location(userRow, userCol - 1)), enemy)){
                            attack(enemy);
                        }
                    }
                    grid.setImage(new Location(userRow, userCol), null);
                    userCol--;
                    grid.setImage(new Location(userRow, userCol), userPic);
                }
                break;
            case 39 :
                System.out.println(39);
                if(userCol != grid.getNumCols() - 1) {
                    if(userCol != grid.getNumCols() - 1){
                        if(equalsWithNulls(grid.getImage(new Location(userRow, userCol + 1)), enemy)){
                            attack(enemy);
                        }
                    }
                    grid.setImage(new Location(userRow, userCol), null);
                    userCol++;
                    grid.setImage(new Location(userRow, userCol), userPic);
                }
                break;

//            case 13 :
//                System.out.println(13);
//                wannaStart = true;
//                break;
            default:
//                System.out.println("Invalid Key pressed");
        }
    }
    //  public void populateRightEdge() {
//
//  }
//
//  public void scrollLeft() {
//
//  }

    public void titleScreen() {
        Grid start = new Grid(5, 5, "img//NOT_DONE.png");
        start.setTitle("Title Screen");
//        start.setImage(new Location(3, 2), "img//Start.png");
        while (wannaStart) {
            Scanner starting = new Scanner(System.in);
            String words = starting.nextLine();

            if (words.compareTo("") == 1) {
                start.close();
                return;
            }
        }
    }


    public void attack(String foe){
        battleField = new Grid(5,5,"img//BattleField.png");
        battleField.setTitle("Player Attack");
        battleField.setImage(new Location(3,1), userPic);
        battleField.setImage(new Location(3,3), foe);
        battleField.pause(500);
        battleField.setImage(new Location(3,1), null);
        battleField.setImage(new Location(3,2), userPic);
        battleField.pause(500);
        battleField.setImage(new Location(3,3), foe.substring(0,foe.length()-4)+"Attack.gif");
        ora.startSound();
        battleField.pause(500);
        battleField.setImage(new Location(3,3), null);
        battleField.pause(500);
        battleField.setImage(new Location(3,2), null);
        battleField.setImage(new Location(3,1), userPic);
        battleField.pause(500);
        battleField.close();

    }

    /*public void handleCollision(Location loc) {
        if((userCol == loc.getCol() - 1 || userCol == loc.getCol() + 1) && (userRow == loc.getRow() - 1 || userRow == loc.getRow() + 1)){
            if(grid.getImage(loc).equals(enemy)){
                attack(enemy);

            }
            if(grid.getImage(loc).equals("kono_dio_da.gif")){
                attack("kono_dio_da.gif");
            }


        }

    }*/

    //Credit to Mikera on stack overflow
    public static boolean equalsWithNulls(String a, String b) {
        if (a == b) {
            return true;
        }
        if ((a == null)||(b == null)) {
            return false;
        }
        return a.equals(b);
    }

    public int getScore() {
        return 0;
    }

    public void updateTitle() {
        grid.setTitle("Game:  " + getScore());
    }

    public boolean isGameOver() {
        return false;
    }

    public static void test() {
        Game game = new Game();
        game.play();

    }

    public static void main(String[] args) {
        test();
    }


}
