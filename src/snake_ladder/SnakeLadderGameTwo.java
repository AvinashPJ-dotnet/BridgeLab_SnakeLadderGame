package snake_ladder;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderGameTwo {
    //constants
    final int LADDER=1;
    final int SNAKE=2;
    final int BOARD_SIZE=100;
    //player class object
    Player playerOne=new Player();
    public void startGame(){
        int switchPlayer = 1;
        while(playerOne.playerPosition < BOARD_SIZE) {

            switch (switchPlayer) {
                case 1:
                    movePlayer(playerOne);
                    break;
                default:
                    break;
            }

        }
        System.out.println(playerOne.playerPosition);
        System.out.println(playerOne.dieCount);
        System.out.println(playerOne.diePositionList);

    }
    public int rollTheDice(){
        int diceNumber=((int)Math.floor(Math.random()*10)%6)+1;
        return diceNumber;
    }

    public void movePlayer(Player player){
        player.playerPreviousPosition= player.playerPosition;
        int dieValue=rollTheDice();
        int choice=((int)Math.floor(Math.random()*10)%3)+1;
        switch (choice){
            case LADDER:
                player.playerPosition+=dieValue;
                break;
            case SNAKE:
                player.playerPosition-=dieValue;
                break;
            default:
                break;
        }
        if(player.playerPosition<0){
            player.playerPosition=0;
        }
        //check whether player mover above Board size
        if (player.playerPosition>BOARD_SIZE)
            player.playerPosition= player.playerPreviousPosition;
        player.dieCount++;
        player.diePositionList.add(dieValue);


    }

}
