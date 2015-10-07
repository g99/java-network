package lotto;

import java.util.Arrays;

public class Lotto {
	// 횟수별 6개의 로또 번호 저장을위한 2차원 배열 선언
	private int[][] lottos; // 5천원 5줄
	private int money; // 로또샵에 주는 돈
	private int count;

	public void inputMoney(int money) {
		this.money = money;
		lottos = new int[money / 1000][6];
		count = lottos.length;
	}

	public void extractNum() {
		int i = 0; // 로또 횟수별 로또 번호 저장 위치
		int num = 0;
		for (int count = 0; count < this.count; count++) {
			while (true) {
				num = vote(); // 번호 뽑아서
				if (isDuple(count, num)) { // 같은줄에 겹치는지 확인해서
					lottos[count][i] = num; // 그 숫자를 담는다
					i++;
					System.out.println("i는"+ i);
					if (i == lottos[0].length) { // 입력된 돈의 값만큼 추출되었다면
						i = 0;
						break; // 종료한다.
					}
				}
			}
		}
	}

	public void printLotto() {
		System.out.println("*************** 부자되세요 ***************");
		for (int i = 0; i < count; i++) {
			sort(lottos[i]);
			for (int j = 0; j < lottos[0].length; j++) {
				System.out.print(lottos[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private int vote() {
		return (int) (Math.random() * 45 + 1);
	}

	/**
	 * 앞에서 추출된숫자가 뒤에서 다시 추출되는 것을 막기 위해서 숫자 중복 여부를 체크해야함 count => money/1000 개념으로
	 * 돈에 따른 로또 횟수
	 */
	private boolean isDuple(int count, int randomNum) {
		for (int i = 0; i < lottos[0].length; i++) {
			if (lottos[count][i] == randomNum) { // lottos[1][i] == randomNum 과
													// 일치하면
				return false;
			}
		}
		return true;
	}

	/**
	 * count별로 로또번호 오름차순 정렬
	 */
	private void sort(int[] arr) {
		for (int i = 0; i < count; i++) {
			Arrays.sort(lottos[i]);
		}
	}
}
