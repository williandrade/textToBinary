package me.williandrade;

import java.util.Arrays;
import java.util.Scanner;

public class ConverterMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";

		while (true) {
			System.out.println("----------------------------");
			System.out.println("0 - Para binario");
			System.out.println("1 - Para Texto");
			System.out.println("----------------------------");

			Integer response = sc.nextInt();

			if (response == 0) {
				System.out.println("Informe o seu texto:");
				String text = sc.next();
				result = toBinary(text);
				System.out.println(result);
				break;
			} else if (response == 1) {
				System.out.println("Informe o seu binário:");
				String text = sc.next();
				result = toText(text);
				System.out.println(result);
				break;
			}
		}

	}

	public static String toBinary(String s) {
		byte[] bytes = s.getBytes();
		
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
		}
		
		return binary.toString();
	}

	public static String toText(String input) {
		StringBuilder sb = new StringBuilder(); // Some place to store the chars

		Arrays.stream( // Create a Stream
				input.split("(?<=\\G.{8})") // Splits the input string into 8-char-sections (Since a char has 8 bits = 1
											// byte)
		).forEach(s -> // Go through each 8-char-section...
		sb.append((char) Integer.parseInt(s, 2)) // ...and turn it into an int and then to a char
		);

		return sb.toString(); // Output text (t)
	}
}
