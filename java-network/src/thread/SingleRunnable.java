package thread;

/**
 * @file_name : SingleRunnable.java
 * @author    : g9yong44@gmail.com
 * @date      : 2015. 10. 8.
 * @story     : 스레드 구현방법 2
 */
public class SingleRunnable implements Runnable{
	public static void main(String[] args) {
		Runnable sr = new SingleRunnable();
		Thread t = new Thread(sr, "첫번째");
		t.start();
	}

	private int[] temp;

	public SingleRunnable() {
		temp = new int[10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}

	public void run() {
		for (int start : temp) {
			try {
				Thread.sleep(1000); // 1/1000 초단위
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print("스레드 이름 : " + Thread.currentThread().getName());
			System.out.println(" temp value : " + start);
		}
	}
}
