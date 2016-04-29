package domain.util;

import java.util.Scanner;

public class Console {
	private static Scanner scan = new Scanner(System.in);

	public static Scanner getScanner() {
		return scan;
	}

}