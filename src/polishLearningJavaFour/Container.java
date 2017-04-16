package polishLearningJavaFour;

import java.util.Scanner;

/**
 * Zaj�cia 4 � �a�cuchy znak�w (String).
 * @author kaje11
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisa� program, kt�ry wczytuje od u�ytkownika ci�g znak�w, a nast�pnie wy-
	 * �wietla informacj� o tym ile razy w tym ci�gu powtarza si� jego ostatni znak.
	 * Przyk�ad, dla ci�gu �Abrakadabra� program powinien wy�wietli� 4, poniewa�
	 * ostatnim znakiem jest literka �a�, kt�ra wyst�puje w podanym ci�gu ��cznie 4
	 * razy.
	 */
	static void repetitionInStr() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ci�g znak�w:");
		String str = scanner.nextLine();
		scanner.close();

		if (str == "") {
			System.out.println(0);
		} else {
			System.out.println(str.length() - str.replace("" + str.charAt(str.length() - 1), "").length());
		}
	}

	/**
	 * TASK TWO.
	 * Napisa� program, kt�ry wczytuje od u�ytkownika ci�g znak�w, a nast�pnie tworzy
	 * �a�cuch b�d�cy odwr�ceniem podanego �a�cucha i wy�wietla go na ekranie.
	 * Przyk�adowo, dla �a�cucha �Kot� wynikiem powinien by� �a�cuch �toK�.
	 */
	static void reverseStr() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ci�g znak�w:");
		String str = scanner.nextLine();
		scanner.close();

		str = new StringBuilder(str).reverse().toString();
		System.out.println(str);
	}
	/**
	 * TASK THREE.
	 * Napisa� program, kt�ry wczytuje od u�ytkownika ci�g znak�w, a nast�pnie sprawdza,
	 * czy podany ci�g jest palindromem.
	 */
	static void isPalindrome() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ci�g znak�w:");
		String str = scanner.nextLine();
		scanner.close();

		if (str == "") {
			System.out.println("Nie jest palindromem");
			return;
		}

		int x = 0;
		int y = str.length() - 1;

		while (y > x) {
			if (str.charAt(x) != str.charAt(y)) {
				System.out.println("Nie jest palindromem");
				return;
			}
			x++;
			y--;
		}

		System.out.println("Jest palindromem");
	}
	/**
	 * TASK FOUR.
	 * Napisa� program, kt�ry sumuje cyfry w tek�cie podanym przez u�ytkownika.
	 * Przyk�ad:
	 * "Ala ma 1 psa i 2 koty. Jola ma 10 rybek i 2 papugi."
	 * Wynik:
	 * 6
	 */
	static void sumDigitsInStr() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ci�g znak�w:");
		String str = scanner.nextLine();
		scanner.close();

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				sum += Character.getNumericValue(str.charAt(i));
			}
		}
		System.out.println("Suma: " + sum);
	}
	/**
	 * TASK FIVE.
	 * Napisz program, kt�ry sprawdzi, czy w podanym przez u�ytkownika wyra�eniu
	 * arytmetycznym nawiasy s� poprawnie sparowane. Wyra�enie podawane jest jako
	 * pojedynczy �a�cuch znak�w. Program powinien wy�wietli� stosowny komunikat.
	 * Przyk�ad a:
	 * "2 * (3.4 - (-7)/2)*(a-2)/(b-1)))"
	 * Wynik:
	 * B��dne sparowanie nawias�w
	 * Przyk�ad b:
	 * "2 * (3.4 - (-7)/2)*(a-2)/(b-1))"
	 * Wynik:
	 * OK
	 * (!) B��D W PRZYK�ADACH - OBA S� Z�E!
	 */
	static void checkParentheses() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj wyra�enie:");
		String str = scanner.nextLine();
		scanner.close();

		//2 * (3.4 - (-7)/2)*(a-2)/(b-1)))
		int oldLength = str.length();
		while (str.length() != 0) {
			str = str.replace("()", "");

			if (oldLength == str.length()) {
				System.out.println("B��dne sparowanie nawias�w");
				return;
			}
			oldLength = str.length();
		}
		System.out.println("OK");
	}
	/**
	 * TASK SIX.
	 * Napisz program, kt�ry umo�liwia szyfrowanie podanego ci�gu znak�w przy u�yciu
	 * szyfru Cezara, kt�ry jest szczeg�lnym przypadkiem szyfru podstawieniowego
	 * monoalfabetycznego.
	 * U�ytkownik program podaje tekst do zaszyfrowania oraz liczb� n, o kt�r� przesuni�ty
	 * jest alfabet za pomoc� kt�rego szyfrujemy tekst. Dla uproszczenia mo�na
	 * przyj��, �e �a�uch wej�ciowy sk�ada si� tylko z ma�ych liter alfabetu angielskiego,
	 * tj. �a� � �z� (26 znak�w) oraz spacji.
	 * Przyk�ad 1.
	 * Podaj �a�cuch znak�w do zaszyfrowania: abrakadabraz
	 * Podaj przesuni�cie: 2
	 * Zaszyfrowany tekst: cdtcmcfcdtcb
	 */
	static void caesarCipher() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Podaj ci�g:");
			String str = scanner.nextLine();

			System.out.println("Podaj liczb� ca�kowit� dodatni�:");
			int shift = scanner.nextInt();
			if (shift < 0) {
				throw new Exception();
			}

			if (shift > 26) {
				shift %= 26;
			}

			String encrypted = "";
			for (int i = 0; i < str.length(); i++) {
		        if (str.charAt(i) != ' ') {
		        	encrypted += (char) ((str.charAt(i) + shift) % 26 + 'a');
		        } else {
					encrypted += ' ';
				}
		    }
			System.out.println("Zaszyfrowany tekst: " + encrypted);
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}

	/**
	 * TASK SEVEN.
	 */
}
