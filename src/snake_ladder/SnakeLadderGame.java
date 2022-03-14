package snake_ladder;

public class SnakeLadderGame {
    //constants
    final int LADDER = 1;
    final int SNAKE = 2;
    final int BOARD_SIZE = 100;
    //player class object
    Player playerOne = new Player();
    Player playerTwo = new Player();

    public void startGame() {
        int switchPlayer = 1;//switch player with incrementing and decrementing value
        while (playerOne.playerPosition < BOARD_SIZE && playerTwo.playerPosition < BOARD_SIZE) {
            if (switchPlayer == 1) {
                if (!movePlayer(playerOne))//if function returns true then it is ladder and not incrementing switch player
                    switchPlayer++;
            } else {
                if (!movePlayer(playerTwo)) ;
                switchPlayer--;
            }
        }
        Player playersPositionComparison = checkPlayerPosition(playerOne.playerPosition, playerTwo.playerPosition);
        System.out.println("Winner position: " + playersPositionComparison.playerPosition);
        System.out.println("Total die count: " + playersPositionComparison.dieCount);
        System.out.println("Every die position: " + playersPositionComparison.diePositionList);
    }

    public int rollTheDice() {
        int diceNumber = ((int) Math.floor(Math.random() * 10) % 6) + 1;
        return diceNumber;
    }

    public boolean movePlayer(Player player) {
        boolean isLadder = false;
        player.playerPreviousPosition = player.playerPosition;
        int dieValue = rollTheDice();//calling roll die function here
        int choice = ((int) Math.floor(Math.random() * 10) % 3) + 1;//if choice 1 is ladder,if 2 snake and 3 dont play
        switch (choice) {
            case LADDER:
                player.playerPosition += dieValue;
                isLadder = true;//if player gets ladder then set it true
                if (player.playerPosition > BOARD_SIZE)//check whether player mover above Board size
                    player.playerPosition = player.playerPreviousPosition;
                break;
            case SNAKE:
                player.playerPosition -= dieValue;
                if (player.playerPosition < 0)//check if player position is less then 0 then make it 0
                    player.playerPosition = 0;
                break;
            default:
                break;
        }
        player.dieCount++;
        player.diePositionList.add(dieValue);//add every die value into the list
        return isLadder;
    }

    public Player checkPlayerPosition(Integer playerOnePos, Integer playerTwoPos) {
        int compare = playerOnePos.compareTo(playerTwoPos);
        if (compare > 0) {
            System.out.println("player one wins");
            return playerOne;
        } else {
            System.out.println("player two wins");
            return playerTwo;
        }
    }

}
