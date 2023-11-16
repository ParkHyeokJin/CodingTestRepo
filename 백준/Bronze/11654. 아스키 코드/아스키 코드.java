import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			char value = br.readLine().charAt(0);
			int Ascii = value;
			System.out.println(Ascii);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}