
public class FallingThread extends Thread{
	
	WordRecord wr;
	private boolean falling;
	private int maxWords;
	
	public FallingThread(WordRecord wr, int maxWords) {
		this.wr = wr;
		this.maxWords = maxWords;
		this.falling = true;
	}
	
	public void run() { 
        try { 
        	while(wr.dropped() == false) {
        		continue;
        	}
        	while(falling) {
        		//animate falling by editing wr
        		
        	}
        	long sleepTime = Math.round((Math.random()* 3000) + 2000);
            
            Thread.sleep(sleepTime);
            
            // Displaying the thread that is running 
            System.out.println ("Thread " + 
                  Thread.currentThread().getId() + 
                  " is running for " + sleepTime/1000 + " seconds");
            
  
        } 
        catch (InterruptedException e) { 
            // System.out.println ("Thread forcibly Quit");
        } 
        catch (Exception e) {
        	//General Error catching
        	System.out.println ("Thread Exception was caught");
        	e.printStackTrace();
        }
    }
}
