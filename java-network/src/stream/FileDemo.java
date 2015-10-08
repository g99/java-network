package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @file_name : FileDemo.java
 * @author    : g9yong44@gmail.com
 * @date      : 2015. 10. 8.
 * @story     : File 클래스
 */
public class FileDemo {
	public static void main(String[] args) {
		System.out.println("검색할 파일이름을 넣으세요(단, 절대경로)");
		String name = "";
		// 스캐너 대용으로 아래 표현을 배워 봅시다.
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(name);
		if (file.exists()) {
			System.out.println("파일 이름 : " +  file.getName());
			System.out.println("상대 경로 : " +  file.getPath());
			System.out.println("절대 경로 : " +  file.getAbsolutePath());
			System.out.println("쓰기 가능 : " +  file.canWrite());
			System.out.println("읽기 가능 : " +  file.canRead());
			System.out.println("파일 길이 : " +  file.length() + " 바이트");
		} else {
			System.out.println("파일이 존재하지 않음");
		}
	}
}
