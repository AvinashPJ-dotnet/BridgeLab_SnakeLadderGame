package snake_ladder;

import java.util.Arrays;
import java.util.Scanner;

public class SnakeLadderGame {
    int totalPlayers=0;
    int[] playerPositionVariables;
    public SnakeLadderGame(int numberOfPlayers){
        if (numberOfPlayers==0){
            System.out.print("Minimum One player is needed..");
            System.exit(0);
        }
        totalPlayers=numberOfPlayers;
        playerPositionVariables =new int[totalPlayers];
    }
    public void createPositionForPlayer(int totalPlayers){
        for (int i = 0; i <totalPlayers ; i++) {
            playerPositionVariables[i]=0;
        }
    }
    public void startGame(){
        createPositionForPlayer(totalPlayers);
//        int[] totalPlayerPosition=createPositionForPlayer(totalPlayers);
//        System.out.println(Arrays.toString(totalPlayerPosition));
        int dieValue=rollTheDice();
        movePlayer(dieValue);
    }

    public int rollTheDice(){
        int diceNumber=((int)Math.floor(Math.random()*10)%6)+1;
        return diceNumber;
    }

    public void movePlayer(int dieValue){
        final int LADDER=1;
        final int SNAKE=2;
//        System.out.println("For ladder Enter 1:\nFor Snake Enter 2:\nFor No Play Enter 3:");
//        Scanner in = new Scanner(System.in);
        int choice=((int)Math.floor(Math.random()*10)%3)+1;
        System.out.println("choice is: "+choice);
        int playerCurrentPosition=playerPositionVariables[0];
        switch (choice){
            case LADDER:
                playerCurrentPosition+=dieValue;
                break;
            case SNAKE:
                playerCurrentPosition-=dieValue;
                break;
            default:
                break;
        }
        playerPositionVariables[0]= playerCurrentPosition;
        System.out.println("player position is: "+playerPositionVariables[0] + " and choice value is: "+choice);
    }
}
