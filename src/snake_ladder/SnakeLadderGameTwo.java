package snake_ladder;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderGameTwo {
    //constants
    final int LADDER=1;
    final int SNAKE=2;
    final int BOARD_SIZE=5;
    //player class object
    Player playerOne=new Player();
    Player playerTwo=new Player();
    public void startGame(){
        int switchPlayer = 1;//switch player with incrementing and decrementing value
        while(playerOne.playerPosition < BOARD_SIZE && playerTwo.playerPosition < BOARD_SIZE ) {
            switch (switchPlayer) {
                case 1:
                    if(!movePlayer(playerOne))//if function returns true then it is ladder and not incrementing switch player
                        switchPlayer++;
                    break;
                default:
                    if(!movePlayer(playerTwo));
                        switchPlayer--;
                    break;
            }
        }
        Player playersPositionComparison=checkPlayerPosition(playerOne.playerPosition,playerTwo.playerPosition);
        System.out.println("Winner position: "+playersPositionComparison.playerPosition);
        System.out.println("Total die count: "+playersPositionComparison.dieCount);
        System.out.println("Every die position: "+playersPositionComparison.diePositionList);
    }
    public int rollTheDice(){
        int diceNumber=((int)Math.floor(Math.random()*10)%6)+1;
        return diceNumber;
    }

    public boolean movePlayer(Player player){
        boolean isLadder=false;
        player.playerPreviousPosition= player.playerPosition;
        int dieValue=rollTheDice();
        int choice=((int)Math.floor(Math.random()*10)%3)+1;
        switch (choice){
            case LADDER:
                player.playerPosition+=dieValue;
                isLadder=true;//if player gets ladder then set it true
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
        return isLadder;
    }
    public Player checkPlayerPosition(Integer playerOnePos,Integer playerTwoPos){
        int compare=playerOnePos.compareTo(playerTwoPos);
        if (compare>0){
            System.out.println("player one wins");
            return playerOne;
        }
        else
        {
            System.out.println("player two wins");
            return playerTwo;
        }
    }

}
