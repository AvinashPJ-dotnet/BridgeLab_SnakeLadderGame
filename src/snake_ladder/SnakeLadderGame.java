package snake_ladder;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeLadderGame {
    int totalPlayers=0;
    int[] playerPositionVariables;
    int BOARD_SIZE=100;
    public SnakeLadderGame(int numberOfPlayers){
        if (numberOfPlayers==0){
            System.out.print("Minimum One player is needed..");
            System.exit(0);
        }
        totalPlayers=numberOfPlayers;
        playerPositionVariables =new int[totalPlayers];
    }
    public void setInitialPositionForPlayer(int totalPlayers){
        for (int i = 0; i <totalPlayers ; i++) {
            playerPositionVariables[i]=0;
        }
    }
    public void startGame(){
        setInitialPositionForPlayer(totalPlayers);
        movePlayer();
    }

    public int rollTheDice(){
        int diceNumber=((int)Math.floor(Math.random()*10)%6)+1;
        return diceNumber;
    }

    public void movePlayer(){
        final int LADDER=1;
        final int SNAKE=2;
        List<Integer> diePosition = new ArrayList<>();
        int dieCount=0;
        while (playerPositionVariables[0]<BOARD_SIZE){
            int dieValue=rollTheDice();
            int previousPosition=0;
            int choice=((int)Math.floor(Math.random()*10)%3)+1;
            int playerCurrentPosition=playerPositionVariables[0];
            diePosition.add(dieValue);
            dieCount++;
            previousPosition=playerCurrentPosition;
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
            if(playerCurrentPosition<0){
                playerCurrentPosition=0;
            }
            //check whether player mover above Board size
            if (playerCurrentPosition>BOARD_SIZE)
                playerPositionVariables[0]= previousPosition;
            else
                playerPositionVariables[0]= playerCurrentPosition;
        }
        System.out.println("player position is: "+playerPositionVariables[0]);
        System.out.println("Total Die count is: "+dieCount);
        System.out.println("every rolled die position: "+ Arrays.asList(diePosition));
    }
}
