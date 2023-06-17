package halaProject;

import java.util.Scanner;

public class encrypt_Rail_and_Least {

	public static void Rail() {
		String pText = "";
		int k;
		String eText = "";
		boolean flag = false;
		int checklocation = 0;
		int j = 0;
		int i = 0;
		int checkLocation = 0;
		int k1 = 0;
		Scanner text = new Scanner(System.in);

		System.out.println("please enter the plainText ");

		while (!text.hasNext("[A-Za-z]+")) {
			System.out.println("please enter again: ");
			text.nextLine();
		}
		pText = text.nextLine();
		pText = pText.replaceAll("\\s+", "");

		// System.out.println( pText );

		System.out.println("please Enter key :");

		while (true) {
			Scanner key = new Scanner(System.in);
			k = key.nextInt();
			if (k > 1) {
				break;
			} else {
				System.out.println("please Enter valid key :");

			}
		}

		char[][] allChar = new char[k][pText.length()];
//store in array and toggle the column 
		//i coulmn
		while (i < pText.length()) {

			flag = ((j > 0 && j < k - 1)) ? flag : !flag;

			allChar[j][i] = pText.charAt(i);
			j = (flag) ? j + 1 : j - 1;

			i++;

		}

//		ABCDEFGHIJKLMNOPQRSTUVWXYZ
//printing 
		for (int i1 = 0; i1 < k; i1++) {
			while (k1 < pText.length()) {
				char ch = allChar[i1][k1];

				if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57)) {
					eText += allChar[i1][k1];
					System.out.print(ch );
				}
				k1++;
			
			}
			System.out.println();
			k1 = 0;

		}
		System.out.print("\n" + "the cipher text is :" + eText + "\n" + "\n");

		decrypt_Rail_and_Least rail = new decrypt_Rail_and_Least();

	}

	public static void main(String[] args) {

		boolean flag = true;
		int x = 0;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("1-Rail Fence Cipher \n2-Least-Simple Substitution");

			x = sc.nextInt();

			if (x == 1) {
				flag = false;
				Rail();

			} else if (x == 2) {
				flag = false;
				Least();
			}
		}
	}

	private static void Least() {
		Scanner text = new Scanner(System.in);
		String pText = "";
		System.out.println("please enter the plainText: ");

		String eText = "";
		char array[] = new char[26];
		while (!text.hasNext("[A-Za-z]+")) {
			System.out.println("please enter again: ");
			text.nextLine();
		}
		pText = text.nextLine();
		pText = pText.replaceAll("\\s+", "");
		pText = pText.toUpperCase();
		System.out.println("Would you like enter the key :\n1- yourself\n2- randomly");

		Scanner number = new Scanner(System.in);
		int num = number.nextInt();
		if (num == 1) {
			System.out.println("please enter the 26 char key: ");
			Scanner text1 = new Scanner(System.in);
			String ran = text1.nextLine();
			ran = ran.replaceAll("\\s+", "");
			ran = ran.toUpperCase();
			for (int i = 0; i < 26; i++) {
				array[i] = ran.charAt(i);
			}
		}

		else {
			for (int i = 0; i < 26; i++) {
				char w = (char) (random() + 65);

				boolean m = check(w, array);
				if (m == true) {
					i = i - 1;
				}

				else {
					array[i] = w;
				}
			}
		}
		System.out.print("The random table from A-Z is:" + "\n");
		System.out.print("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z" + "\n");

		for (int i = 0; i < 26; i++) {
			System.out.print(array[i] + " ");
		}

		for (int w = 0; w < pText.length(); w++) {
			char cha = pText.charAt(w);
			int q = (int) (cha - 'A');

			eText += array[q];

		}
		System.out.print("\n" + "the cipherText is :" + eText + "\n");
		decrypt_Least dec = new decrypt_Least(array);

	}

	private static boolean check(char w, char[] array) {
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == w) {
				flag = true;
				break;
			} else {
				flag = false;
			}

		}
		return flag;

	}

	private static int random() {
		int min = 0;
		int max = 25;

		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return random_int;
	}

}
