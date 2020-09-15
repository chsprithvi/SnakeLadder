import java.util.*;

public class SnakeAndLadder{
    int position=0;
   	
    //Function for rolling a dice
	public int rollDice()
	{
		Random rand=new Random();
		//Random Number from 1 to 6  
		int diceResult=rand.nextInt(6)+1;
		return diceResult;
    }

	//function for playing game
	public void startGame(String playerName) {
		        
        System.out.println("#########--New Throw--########");		
        int pos = getPosition();
        System.out.println("The present position of "+playerName+" is: "+pos);
        
        //Rolling a dice
		int diceValue = rollDice();
		
		System.out.println("The number on dice is "+diceValue);
        
        //option function
        int optionResult = option();
        
        switch(optionResult){
			//Ladder Position
			case 1 :
				System.out.println("You got a Ladder");
				pos += diceValue;
				if(pos > 100){
					int numberNeed = 100 - this.getPosition();
					
					System.out.println("Sorry, You need " + numberNeed + " to Win");
					pos -= diceValue;
                }
				
				if(pos == 100 ) {
					this.setPosition(pos);
					System.out.println("+++++++++++++Winning Player+++++++++++++");
					System.out.println(playerName);
					System.out.println("Hurray You Win, You are at "+this.getPosition());
					System.exit(0);
				}
				this.setPosition(pos);
				System.out.println("The position of the player is "+this.getPosition());
				//If got ladder then calling play function
                this.startGame(playerName);
                break;
			
			//Snake Position
			case 2:
				System.out.println("You got a Snake");
				pos -= diceValue;
				
				this.setPosition(pos);
				
				System.out.println("The position of the player is "+this.getPosition());
				break;
			
			//No Play
			default:
				System.out.println("You got a NoPlay");
				System.out.println("The position of the player is "+this.getPosition());
			
        }
    }

	/**
	 * @return : position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		// If position < 0, then Position is assigned to zero
		if(position < 0)
		{
			position = 0;
			
		}
		this.position = position;
	}
	 
    /*
     *options for the position movement
	 * 1-Ladder
	 * 2-Snake
     * 3-NO-PLay
	 */
	public int option(){
	    Random rand = new Random();
		//random number in 1-3
		int value = rand.nextInt(3)+1;
		return value;
	} 
 
    public static void main(String[] args) {
		//Creating object for SnakeAndLadder Class
		int numberOfPlayers=2;
		ArrayList<SnakeAndLadder> playerList = new ArrayList<SnakeAndLadder>(numberOfPlayers);
		
		for(int i = 0; i < numberOfPlayers; i++) {
			SnakeAndLadder ObjSnakeLadder = new SnakeAndLadder();
			playerList.add(ObjSnakeLadder);
		}
		System.out.println(playerList);
		
		while(true) {
			for(int i = 0; i < playerList.size(); i++) {
				int playerNumber = i + 1;
				System.out.println("\n Game Started for Player"+playerNumber);
				playerList.get(i).startGame("Player "+playerNumber);
			}		
		}
	} 
}
