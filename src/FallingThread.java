
public class FallingThread implements Runnable{
	
	private WordRecord wr;
	private boolean falling;
	private int maxWords;
	private Score score;
	
	public FallingThread(WordRecord wr, Score score, int maxWords) {
		this.wr = wr;
		this.maxWords = maxWords;
		this.falling = true;
		this.score = score;
	}
	
	public void run() {
		try {
        	while(falling) {
        		Thread.sleep(wr.getSpeed());
        		int newYPos = 20 + wr.getY();
        		boolean hitBottom = wr.setY(newYPos);
        		
        		if(hitBottom)
        		{
        			score.missedWord();
        			if(score.getTotal() < maxWords) {
        				wr.resetWord();
        			}
        			else {
        				falling = false;
        				wr.resetWord();
        			}
        		}
        	}
            
            
            // Displaying the thread that is running 
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running");  
        }
        catch (Exception e) {
        	//General Error catching
        	System.out.println ("Thread Exception was caught");
        	e.printStackTrace();
        }
    }
}
