import java.util.Random;

public class SnakeAndLadder
{
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
	public void startGame() {
		
		System.out.println("*********SnakeAndLadder********");

		while (this.getPosition()<100) {
			System.out.println("#########--New Throw--########");		
        int pos = getPosition();
        System.out.println("The present position of player is: "+pos);
        
        //Rolling a dice
        int diceValue = rollDice();
        System.out.println("The number on dice is "+diceValue);
        
        //option function
        int optionResult = option();
        
        switch(optionResult){
		    //Ladder on block 
		    case 1 :
			    System.out.println("******LADDER******");
				pos += diceValue;
				if(pos > 100)
				{
					int numberNeed = 100 - this.getPosition();
					System.out.println("You need "+numberNeed+" to Win");
					continue;
				}
				if(pos == 100) 
				{
					this.setPosition(pos);
					System.out.println(" ^_^ You Win ^_^ \n You are at "+this.getPosition());
				}
				this.setPosition(pos);
			    break;
		    //Snake on block
		    case 2:
			    System.out.println("*****SNAKE*****");
			    pos -= diceValue;
		    	this.setPosition(pos);
		    	break;
		    //No change
		    default:
		    	System.out.println("*******NO-PLAY*******");
        }

        System.out.println("The NEW-position of the player is "+this.getPosition());    
        
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
    	//obj for player1
        SnakeAndLadder player1 = new SnakeAndLadder();
        System.out.println("Player position:"+player1.position);
        
        player1.startGame();
}
}
