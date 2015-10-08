package thread;

import java.util.Random;

public class SnailRaceRunnable {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("경주 시작");
		Thread t1 = new Thread(new SnailRun(), "빨강");
		Thread t2 = new Thread(new SnailRun(), "파랑");
		Thread t3 = new Thread(new SnailRun(), "주황");
		Thread t4 = new Thread(new SnailRun(), "보라");
		// 달팽이들이 경기를 마치기 전까지는 main() 스레드를
		// 종료시키면 안되기 때문에 블락(걸어잠근다)시켜야 한다.
		// join()을 호출한다.
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	}
}

class SnailRun implements Runnable {
	public SnailRun() {
	}

	@Override
	public void run() {
		Random r = new Random();
		for (int i = 0; i < 100; i+=5) {
			int randomNum = r.nextInt(500)+1; // 1부터 500까지 랜덤 숫자 발생
			try {
				Thread.sleep(randomNum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "달팽이" + i + " 미터 전진");
		}
		System.out.println(Thread.currentThread().getName() + "달팽이가 결승점을 통과합니다.!!");
	}
}
