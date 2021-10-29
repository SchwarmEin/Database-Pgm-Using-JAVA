
public class MainThread {

	public static void main(String[] args) {
		String fname = "Christine";
		//String fname = "Ravinder";
		
		TaskNamePrint name = new TaskNamePrint(fname);
		TaskHashPrint hash = new TaskHashPrint(fname);
		
		for (int i=0; i<5; i++) {
			Thread t1 = new Thread(name);
			Thread t2 = new Thread(hash);
			
			t1.start();
			t2.start();
			
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// wait until both threads are done before running again
			while (t1.isAlive() || t2.isAlive()) {
				
			}
			
			System.out.println();
			
		}
	}

}
