package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @file_name : MemberRegister.java
 * @author : g9yong44@gmail.com
 * @date : 2015. 10. 8.
 * @story : 회원등록 프로그램
 */
public class MemberRegister {
	/**
	 * 신규회원 가입 프로그램입니다. 저장은 외부에 바탕화면에 member라는 폴더에 아이디.txt로 저장해 주시고 만약, 아이디.txt가
	 * 존재한다면, 이미 등록된 회원입니다 라고 띄워주세요 존재하지 앟다면 해당아이디 .txt 파일을 생성합니다. hong.txt 홍길동
	 * 인적정보파일 lee.txt 이순신 인적정보파일 해당 회원이 회원가입한 날짜시간 2015-10-08 4:18 오후 까지 저장해 주세요
	 */
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd h:mm a");
		Scanner scanner = new Scanner(System.in);
		String id, pass, name;

		System.out.println("===회원가입===");
		System.out.print("아 이 디 : ");
		id = scanner.next();
		String filePath = "C:\\Users\\HB\\Desktop\\member\\" + id + ".txt", buffer = "";
		File file = new File(filePath);
		BufferedWriter bw;
		BufferedReader br;
		if (file.exists()) {
			try {
				br = new BufferedReader(new FileReader(file));
				while ((buffer = br.readLine()) != null) {
					System.out.println(buffer);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();	
			}
		} else {
			try {
				System.out.print("비밀번호 : ");
				pass = scanner.next();
				System.out.print("이    름 : ");
				name = scanner.next();
				bw = new BufferedWriter(new FileWriter(file)); // 경로
				bw.write("아 이 디 : " + id);
				bw.newLine();
				bw.write("비밀번호 : " + pass);
				bw.newLine();
				bw.write("이    름 : " + name);
				bw.newLine();
				bw.write(format.format(date));
				bw.newLine();
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 파일이 존재하는지 여부를 체크해서 없으면 만들고
		// 있으면 스캐너가 입력 받은 정보를 txt 파일에 기재한다.
	}
}
