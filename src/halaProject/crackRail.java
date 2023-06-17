package halaProject;

import java.util.Scanner;

public class crackRail {

	public crackRail() {
		String eText = "";
		Scanner scanner = new Scanner(System.in);

		System.out.println("*******************************************************");

		System.out.println("Do you like to watch crack ?");
		int x1 = 0;
		Scanner sc1 = new Scanner(System.in);
		System.out.println("1- YES");
		System.out.println("2- NO");

		x1 = sc1.nextInt();

		if (x1 == 1) {
			System.out.println("please enter the encryptedText:");
			while (!scanner.hasNext("[A-Za-z]+")) {
				System.out.println("please enter again: ");
				scanner.nextLine();
			}
			eText = scanner.nextLine();
			eText = eText.replaceAll("\\s+", "");

			String validate = "";
			int m = 0;
			boolean equality = false;
			for (int c = 2; c <= 10; c++) {
				m = c;
				validate = crack(eText, c);
				System.out.print("the plain text in crack = " + validate + " and the key = " + m + "\n");

			}

		}

	}

	private String crack(String eText, int k) {
		String dText = "";
		int i1 = 0;
		boolean flag21 = false;
		int j1 = 0;
		int index = 0;
		int i11 = 0;

		char[][] matrixToDecreption = new char[k][eText.length()];

		while (i1 < eText.length()) {
			flag21 = ((j1 > 0 && j1 < k - 1)) ? flag21 : !flag21;

			matrixToDecreption[j1][i1] = '-';

			j1 = (flag21) ? j1 + 1 : j1 - 1;
			i1++;
		}
		while (i11 < k) {

			for (int k11 = 0; k11 < eText.length(); k11++) {

				char ch = matrixToDecreption[i11][k11];
				if (ch == '-' && index < eText.length()) {
					matrixToDecreption[i11][k11] = eText.charAt(index++);
				}
			}
			i11++;
		}

		j1 = 0;
		flag21 = false;

		for (int i111 = 0; i111 < eText.length(); i111++) {
			flag21 = ((j1 > 0 && j1 < k - 1)) ? flag21 : !flag21;

			dText += matrixToDecreption[j1][i111];

			j1 = (flag21) ? j1 + 1 : j1 - 1;

		}
		return dText;

	}

}
