
public class TaskHashPrint implements Runnable {
	
	private int charCount;
	
	public TaskHashPrint(String text) {
		this.charCount = text.length();
	}

	@Override
	public void run() {
		for (int i=0; i < charCount; i++) {
			System.out.print("#");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
