
public class TaskNamePrint implements Runnable{
	
	private String text;
	
	public TaskNamePrint(String text) {
		this.text = text;
	}
	
	@Override
	public void run() {
		for (char c : text.toCharArray()) {
			System.out.print(c);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
