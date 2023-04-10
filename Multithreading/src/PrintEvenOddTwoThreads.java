/*
 * Print even and odd numbers sequentially using two threads
 * 
 * */
public class PrintEvenOddTwoThreads {
	static int num = 1;
	
	public static void main(String[] args) {
		Object lock = new Object();
		Runnable runnable = () ->{
			synchronized (lock) {
				while(num <= 10) {
					try {
						Thread.sleep(1000);
						String currentThread = Thread.currentThread().getName();
						if(currentThread.equals("EVEN") && num % 2 == 0) {
							System.out.println(num + " -> "+currentThread);
							num++;
							lock.notifyAll();
							
						}
						if(currentThread.equals("ODD") && num % 2 != 0) {
							System.out.println(num + " -> "+currentThread);
							num++;
							lock.notifyAll();
							
						}
						lock.wait(2000);
						
					}catch(InterruptedException ex) {
						
					}
					
					
				}
				
			}
		};
		
		Thread t1 = new Thread(runnable);
		t1.setName("EVEN");
		t1.start();
		Thread t2 = new Thread(runnable);
		t2.setName("ODD");
		t2.start();
		
	}
}
