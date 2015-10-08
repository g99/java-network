package thread;

import java.util.Random;

public class SnailRace {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("경주 시작");
		Snail s1 = new Snail("빨강");
		Snail s2 = new Snail("파랑");
		Snail s3 = new Snail("보라");
		Snail s4 = new Snail("분홍");
		s1.setPriority(10);
		s2.setPriority(1);
		s3.setPriority(1);
		s4.setPriority(1);
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		// 달팽이들이 경기를 마치기 전까지는 main() 스레드를
		// 종료시키면 안되기 때문에 블락(걸어잠근다)시켜야 한다.
		// join()을 호출한다.
		
		s1.join(); // 해당 스레드가 죽을때까지 기다림
		s2.join();
		s3.join();
		s4.join();
	}
}

class Snail extends Thread {
	public Snail(String name) {
		super(name);
	}

	@Override
	public void run() {
		Random r = new Random();
		for (int i = 0; i < 100; i+=5) {
			int randomNum = r.nextInt(500)+1; // 1부터 500까지 랜덤 숫자 발생
			try {
				sleep(randomNum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName() + "달팽이" + i + " 미터 전진");
		}
		System.out.println(getName() + "달팽이가 결승점을 통과합니다.!!");
	}
}