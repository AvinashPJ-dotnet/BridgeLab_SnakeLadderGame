package snake_ladder;

import java.util.Arrays;

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
    public int[] createPositionForPlayer(int totalPlayers){
        for (int i = 0; i <totalPlayers ; i++) {
            playerPositionVariables[i]=0;
        }
        return playerPositionVariables;
    }
    public void startGame(){
        int[] totalPlayerPosition=createPositionForPlayer(totalPlayers);
        System.out.println(Arrays.toString(totalPlayerPosition));
        rollTheDice();
    }

    public void rollTheDice(){
        int diceNumber=((int)Math.floor(Math.random()*10)%6)+1;
        System.out.println("dice number: "+diceNumber);
    }

}
