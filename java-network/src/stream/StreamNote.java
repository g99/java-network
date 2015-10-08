package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @file_name : StreamNote.java
 * @author    : g9yong44@gmail.com
 * @date      : 2015. 10. 8.
 * @story     : 스트림 문법 
 */
public class StreamNote {
	/**
	 * 모든 스트림(데이터의 흐름)은 2가지종류가 있다.
	 * 
	 * 1. 바이트 스트림 : 튜브의 지름이 작고, 빠르다.
	 * 		ByteStream은 InputStream/OutputStream으로 끝난다.
	 * 
	 * 2. 문자 스트림 : 튜브의 지름이 바이트의 2배 크다.(용량이 크다)
	 * 		CharacterStream은 Reader/Writer로 끝난다.
	 * 
	 * 기본형 타입 (Primitive Type) = P type
	 * 객체형 타입 (Reference Type) = R type
	 * 
	 * DataInputStream - DataOutputStream : P type
	 * ObjectInputStream - ObjectOutputSTream : R type
	 * BufferedInputStream - BufferedOutputStream : 바이트를 버퍼에 저장했다가 한꺼번에 입출력
	 * 
	 * InputStreamReader 와 OutputStreamWriter는 바이트와 문자를
	 * 알아서 적합하게 바꿔준다. 사용하면됨!!!
	 */
	public static void main(String[] args) {
		String fileName = "C:\\Users\\HB\\Desktop\\Temp\\test.txt", buffer = "";
		BufferedWriter bw;
		BufferedReader br;
		try {
			bw = new BufferedWriter(new FileWriter(new File(fileName),true));
			bw.write("안녕");
			bw.newLine(); // 개행한 효과
			bw.write("반갑다 패턴야..!");
			bw.close(); // 항상 닫아 주어야 저장이 된다
			
			br = new BufferedReader(new FileReader(new File(fileName)));
			while ((buffer = br.readLine()) != null) { // 읽어들인 값이 null이 아니라면
				System.out.println(buffer);
			}
			br.close(); // 마찬가지로 꼭 닫아야 함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
