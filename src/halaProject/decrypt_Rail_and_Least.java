package halaProject;

import java.util.Scanner;

public class decrypt_Rail_and_Least {
	String dText = "";
	int x = 0;
	int i1 = 0;
	boolean flag21 = false;
	int j1 = 0;
	int k111 = 0;
	int index = 0;
	int i11 = 0;
	int k = 0;

	decrypt_Rail_and_Least() {
		System.out.println("*******************************************************");

		System.out.println("Do you like to watch decription ?");

		Scanner sc = new Scanner(System.in);
		System.out.println("1- YES");
		System.out.println("2- NO");
		String eText = "";

		x = sc.nextInt();
		if (x == 1) {

			Scanner scanner = new Scanner(System.in);
			System.out.println("please enter the encryptedText ");

			while (!scanner.hasNext("[A-Za-z]+")) {
				System.out.println("please enter again: ");
				scanner.nextLine();
			}
			eText = scanner.nextLine();
			eText = eText.replaceAll("\\s+", "");

			System.out.println("please enter key: ");

			while (true) {
				Scanner key = new Scanner(System.in);
				k = key.nextInt();
				if (k > 1) {
					break;
				} else {
					System.out.println("please Enter valid key :");

				}
			}

			char[][] matrixToDecreption = new char[k][eText.length()];
//j1 is row
			while (i1 < eText.length()) {
				flag21 = ((j1 > 0 && j1 < k - 1)) ? flag21 : !flag21;

				matrixToDecreption[j1][i1] = '-';

				j1 = (flag21) ? j1 + 1 : j1 - 1;
				i1++;
			}
			//store char in array
			//i11 is row 
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
			System.out.print("the Plain text is : " + dText + "\n");

			crackRail crack = new crackRail();
		} else {
			crackRail crack = new crackRail();

		}
	}
}

class decrypt_Least {

	public decrypt_Least(char[] array2) {
		System.out.println("*******************************************************");
		char array[] = new char[26];

		System.out.println("Do you like to watch decription With Random Table ?");

		Scanner sc = new Scanner(System.in);
		System.out.println("1- YES");
		System.out.println("2- NO");
		String pText = "", eText;
		int index = 0;
		int x = sc.nextInt();
		if (x == 1) {
			Scanner text = new Scanner(System.in);

			System.out.println("please enter the encrypted Text: ");

			while (!text.hasNext("[A-Za-z]+")) {
				System.out.println("please enter again: ");
				text.nextLine();
			}
			eText = text.nextLine();
			eText = eText.replaceAll("\\s+", "");
			eText = eText.toUpperCase();
			System.out.println("Would you like enter the key :\n1- yourself\n2- randomly");
			Scanner s = new Scanner(System.in);
			int v = s.nextInt();

			if (v == 1) {

				System.out.println("please enter the 26char key: ");

				Scanner key = new Scanner(System.in);
				String k = key.nextLine();
				k = k.replaceAll("\\s+", "");

				for (int i = 0; i < k.length(); i++) {
					array[i] = k.charAt(i);
				}

			} else {
				for (int m = 0; m < 26; m++) {
					array[m] = array2[m];
				}
			}

			for (int i = 0; i < eText.length(); i++) {
				char ch = eText.charAt(i);

				for (int m = 0; m < array.length; m++) {
					if (array[m] == ch) {
						index = m;
						break;
					}
				}
				pText += (char) (index + 65);

			}
			System.out.print("\n" + "The pText with Random Table = " + pText + "\n");

			cryptoanalysisTwo ct = new cryptoanalysisTwo();

		} else {
			cryptoanalysisTwo ct = new cryptoanalysisTwo();

		}

	}

}
