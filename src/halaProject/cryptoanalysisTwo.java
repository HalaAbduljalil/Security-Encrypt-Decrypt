package halaProject;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class cryptoanalysisTwo {
	static int countchar[] = new int[26];
	static char array[] = new char[26];
	static int countchar2[] = new int[26];
	static boolean flags[] = new boolean[26];

	public cryptoanalysisTwo() {
		System.out.println("*******************************************************");

		System.out.println("Do you like to watch decription with cryptoanalysis two ?");

		Scanner sc2 = new Scanner(System.in);
		System.out.println("1- YES");
		System.out.println("2- NO");

		int x = sc2.nextInt();
		if (x == 1) {
			System.out.println("please enter the encrypted text:");
			int temp;
			Scanner sc = new Scanner(System.in);
			String eText = sc.nextLine();
			String pText = "", pText2 = "", pText3 = "", pText4 = "", pText5 = "", pText6 = "", pText7 = "",
					pText8 = "", pText9 = "", pText10 = "";

			String Freq = "ETAOINSRHDLUCMFYWGPBVKXQJZ";
			String Freq2 = "ETAOINSRHDLUCMFYWGPBVKXQZJ";
			String Freq3 = "ETAOINSRHDLUCMFYWGPBVKXJQZ";
			String Freq4 = "ETAOINSRHDLUCMFYWGPBVKXZJQ";
			String Freq5 = "ETAOINSRHDLUCMFYGWPBVKXQJZ";
			String Freq6 = "ETAOINSRHDLUCMFWYGPBVKXQJZ";
			String Freq7 = "ETAOINSRHDLUCMFGWYPBVKXQJZ";
			String Freq8 = "ETAOINSRHDLUMCFYWGPBVKXQJZ";
			String Freq9 = "ETAOINSHRDLUCMFYWGPBVKXQJZ";
			String Freq10 = "ETAOINSRHDLUCMFYWGPBVKXQJZ";

			for (int i = 0; i < 26; i++) {
				countchar[i] = 0;
			}
			for (int i = 0; i < 26; i++) {
				flags[i] = false;
			}
			for (int i = 0; i < eText.length(); i++) {

				char v = eText.charAt(i);
				count(eText, v);

			}

			for (int i = 0; i < 26; i++) {
				System.out.print("Count of ["+(char)(i+65)+"] is : "+countchar[i]+"\n");
			}

			for (int i = 0; i < 26; i++) {
				countchar2[i] = countchar[i];
			}

			int m1 = 0;
			for (int i = 0; i < countchar.length; i++) {
				for (int j = i + 1; j < countchar.length; j++) {
					if (countchar[i] < countchar[j]) {
						temp = (countchar[i]);
						countchar[i] = countchar[j];
						countchar[j] = temp;

					}
				}
				m1++;
			}

			System.out.println("//////////////////////after//////////////////////");

//			for (int i = 0; i < 26; i++) {
//				System.out.println(countchar[i]);
//			}

			String s = "a", check = "";
			char cha;
			int p = 0;
			for (int i = 0; i < 26; i++) {
				int ch = countchar[i];
				for (int j = 0; j < 26; j++) {
					if (countchar2[j] == ch) {
						if (flags[j] == false) {
							array[i] = (char) (j + 65);
							check += array[i];
							flags[j] = true;
							break;
						}

					}

				}

			}

			System.out.println("*********************************************************************");

			for (int i = 0; i < 26; i++) {
				System.out.println(array[i]);

			}

			for (int i = 0; i < eText.length(); i++) {
				int ch = eText.charAt(i);
				for (int m11 = 0; m11 < array.length; m11++) {
					if (array[m11] == ch) {
						pText += Freq.charAt(m11);
						pText2 += Freq.charAt(m11);
						pText3 += Freq.charAt(m11);
						pText4 += Freq.charAt(m11);
						pText5 += Freq.charAt(m11);
						pText6 += Freq.charAt(m11);
						pText7 += Freq.charAt(m11);
						pText8 += Freq.charAt(m11);
						pText9 += Freq.charAt(m11);
						pText10 += Freq.charAt(m11);

					}

				}

			}

			System.out.print("the plainText1 is :" + pText + "\n");
			System.out.print("the plainText2 is :" + pText2 + "\n");
			System.out.print("the plainText3 is :" + pText3 + "\n");
			System.out.print("the plainText4 is :" + pText4 + "\n");
			System.out.print("the plainText5 is :" + pText5 + "\n");
			System.out.print("the plainText6 is :" + pText6 + "\n");
			System.out.print("the plainText7 is :" + pText7 + "\n");
			System.out.print("the plainText8 is :" + pText8 + "\n");
			System.out.print("the plainText9 is :" + pText9 + "\n");
			System.out.print("the plainText10is :" + pText10 + "\n");

		} else {

		}

	}

	private static void count(String x, char v) {
		int count = 0;

		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == v) {
				count++;
			}

		}

		countchar[(int) v - 65] = count;

	}
}
