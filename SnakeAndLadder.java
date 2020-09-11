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
    
    public static void main(String[] args) {
    	//obj for player1
        SnakeAndLadder player1 = new SnakeAndLadder();
        System.out.println("Player position:"+player1.position);
        System.out.println("Dice value:"+player1.rollDice());
}
}