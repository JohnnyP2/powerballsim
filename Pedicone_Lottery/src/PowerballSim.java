import java.util.*;

/**
 * @author Delaware Technical Community College
 * Topics: Arrays, 2D arrays
 * 
 * Write a simple method to check how many times a certain number has appeared in the last six months 
 * (including both white and red balls).
 * The method should return the number of occurrences of that number and take two arguments - 
 * the 2 dimensional array with all the drawings and one number to search for.
 * Also, write a second method to check how many times a number appears in the red ball drawing.  
 * The return type and parameter list should be the same as the first method above.
 */
public class PowerballSim {
	public static void main(String[] args) {
		
		// The following 2D array holds all six balls drawn for 52 drawings
		// The first 5 spots hold the white balls and the last spot holds the red ball drawn that day
		int powerballNumbers[][] = new int[52][6];
		
		
	
		int numCheck = 60;//The number we are looking for
		int numOfWhiteReps = 0;
		int numOfRedReps = 0;
		int numOfTotalReps = 0;
		
		
		for (int drawings = 0; drawings < 52; drawings++) {
			int whiteDrawn[] = drawBalls(5, initializeBalls(69));
			numOfWhiteReps += repeatingWhite(whiteDrawn, numCheck); //gets the number of how many times the white balls repeats

			
			int redDrawn[] = drawBalls(1, initializeBalls(26));
			numOfRedReps += repeatingRed(redDrawn, numCheck); //gets the number of how many times the red balls repeats


			for (int whiteBalls = 0; whiteBalls < 5; whiteBalls++) {
				powerballNumbers[drawings][whiteBalls] = whiteDrawn[whiteBalls];

			}
			powerballNumbers[drawings][5] = redDrawn[0];

					
		}
		
		
		for (int drawings = 0; drawings < 52; drawings++) {
			System.out.println(Arrays.toString(powerballNumbers[drawings]));
		}
		numOfTotalReps += repeatingLotto(powerballNumbers, numCheck); //gets the number of how many times the red balls repeats

		System.out.println("The number " + numCheck +" repeats "+numOfTotalReps+ " times! \n");
		System.out.println("After checking for the number " + numCheck +" the white balls repeated "+numOfWhiteReps+ " times! \n");
		System.out.println("After checking for the number " + numCheck +" the Red balls repeated "+numOfRedReps+ " times! \n");


	}
	
	/**
	 * @param size - number of balls to initialize
	 * @return an array of integers representing the balls
	 */
	static int[] initializeBalls(int size) {
		int lotteryBalls[] = new int[size];
		for (int i = 0; i < size; i++) {
			lotteryBalls[i] = i;
		}
		return lotteryBalls;
	}
	
	/**
	 * @param size - the number of balls to draw
	 * @param set - the set of balls to draw from
	 * @return an array of integers representing the balls drawn
	 */
	static int[] drawBalls(int size, int[] set) {
		
		// In order to facilitate the shuffle easily, we create/copy an ArrayList
		// ArrayLists are like vectors in C++
		// It has some built in functionality such as shuffle.  It is also resizable.
		// ArrayLists must use setters/getters (add, get, etc.) with index position rather than using [] syntax
		ArrayList<Integer> listCopy = new ArrayList<>();
		
		for (int i: set) {
			listCopy.add(i);
		}
		
		Collections.shuffle(listCopy);
		
		int ballsDrawn[] = new int[size];
		for (int i = 0; i < size; i++) {
			ballsDrawn[i] = listCopy.get(i);
		}
		return ballsDrawn;
	}
	public static int repeatingWhite( int whiteDrawn[], int numCheck)//Looks at all the white balls and checks them 
	{
		int timesRepeated = 0;
		for(int i = 0; i< 5; i++) 
		
		{
			
			
			if(whiteDrawn[i] == numCheck) 
			{
				
				timesRepeated ++;
			}
				
		}
		
		return timesRepeated;
	}
	public static int repeatingRed( int redDrawn[], int numCheck)// Looks at all the red balls and checks them 
	{
		int timesRepeated = 0;
		for(int i = 0; i< 1; i++) 
		
		{
			
			
			if(redDrawn[i] == numCheck) 
			{
				
				timesRepeated ++;
			}
				
		}
		
		return timesRepeated;
	}
	public static int repeatingLotto( int totalDrawn[][], int numCheck)// Looks at all the balls and checks them to see how many times they repeat 
	{
		int timesRepeated = 0;
		for(int i = 0; i< 52; i++) 
		
		{
			
			for(int j = 0; j < 6; j++)
				
			{	
				if(totalDrawn[i][j] == numCheck) 
				{
					timesRepeated ++;
				}
			}	
		}
		
		return timesRepeated;
	}
	
	
	
	
	

}
