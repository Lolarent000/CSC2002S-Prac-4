
public class FallingThread implements Runnable{
	
	private WordRecord wr;
	private int maxWords;
	private Score score;
	
	public FallingThread(WordRecord wr, Score score, int maxWords) {
		this.wr = wr;
		this.maxWords = maxWords;
		this.score = score;
	}
	
	public void run() {
		try {
        	while(true) {
        		if(wr.getDropped() == true) {
	        		Thread.sleep(wr.getSpeed());
	        		boolean hitBottom = wr.drop(10);
	        		
	        		if(hitBottom)
	        		{
	        			score.missedWord();
	        			if(score.getTotal() < maxWords) {
	        				wr.resetWord();
	        				wr.setDropped(true);
	        			}
	        			else {
	        				wr.resetWord();
	        				wr.setDropped(true);
	        			}
	        		}
        		}
        	}
        }
		catch (InterruptedException e) {
			System.out.println ("Thread " + Thread.currentThread().getId() + " is done running");  
		}
        catch (Exception e) {
        	//General Error catching
        	System.out.println ("Thread Exception was caught");
        	e.printStackTrace();
        }
    }
}
