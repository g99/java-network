package thread;

/**
 * @file_name : SingleThread.java
 * @author : g9yong44@gmail.com
 * @date : 2015. 10. 8.
 * @story : 스레드 구현방법 1
 */
public class SingleThread extends Thread {
	public static void main(String[] args) {
		SingleThread st = new SingleThread("첫번째");
		st.start(); // 쓰레드를 runnable 상태로 호출
		
		/**
		 * 주의할 점. 개발자가 코딩한 아래 run()메소드를 호출하는 것이 아니라 상속받은 start()메소드를 호출하고, 이
		 * 메소드가 아래 구현한 run() 메소드를 호출하는 모습
		 */
	}

	private int[] temp;

	public SingleThread(String threadName) {
		super(threadName);
		temp = new int[10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}

	public void run() {
		for (int start : temp) {
			try {
				sleep(1000); // 1/1000 초단위
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print("스레드 이름 : " + currentThread().getName());
			System.out.println(" temp value : " + start);
		}
	}
}
