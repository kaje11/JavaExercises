package polishLearningJavaFour;

import java.util.Scanner;

/**
 * Zajêcia 4 – ³añcuchy znaków (String).
 * @author kaje11
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisaæ program, który wczytuje od u¿ytkownika ci¹g znaków, a nastêpnie wy-
	 * œwietla informacjê o tym ile razy w tym ci¹gu powtarza siê jego ostatni znak.
	 * Przyk³ad, dla ci¹gu „Abrakadabra” program powinien wyœwietliæ 4, poniewa¿
	 * ostatnim znakiem jest literka „a”, która wystêpuje w podanym ci¹gu ³¹cznie 4
	 * razy.
	 */
	static void repetitionInStr() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ci¹g znaków:");
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
	 * Napisaæ program, który wczytuje od u¿ytkownika ci¹g znaków, a nastêpnie tworzy
	 * ³añcuch bêd¹cy odwróceniem podanego ³añcucha i wyœwietla go na ekranie.
	 * Przyk³adowo, dla ³añcucha „Kot” wynikiem powinien byæ ³añcuch „toK”.
	 */
	static void reverseStr() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ci¹g znaków:");
		String str = scanner.nextLine();
		scanner.close();

		str = new StringBuilder(str).reverse().toString();
		System.out.println(str);
	}
	/**
	 * TASK THREE.
	 * Napisaæ program, który wczytuje od u¿ytkownika ci¹g znaków, a nastêpnie sprawdza,
	 * czy podany ci¹g jest palindromem.
	 */
	static void isPalindrome() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ci¹g znaków:");
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
	 * Napisaæ program, który sumuje cyfry w tekœcie podanym przez u¿ytkownika.
	 * Przyk³ad:
	 * "Ala ma 1 psa i 2 koty. Jola ma 10 rybek i 2 papugi."
	 * Wynik:
	 * 6
	 */
	static void sumDigitsInStr() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ci¹g znaków:");
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
	 * Napisz program, który sprawdzi, czy w podanym przez u¿ytkownika wyra¿eniu
	 * arytmetycznym nawiasy s¹ poprawnie sparowane. Wyra¿enie podawane jest jako
	 * pojedynczy ³añcuch znaków. Program powinien wyœwietliæ stosowny komunikat.
	 * Przyk³ad a:
	 * "2 * (3.4 - (-7)/2)*(a-2)/(b-1)))"
	 * Wynik:
	 * B³êdne sparowanie nawiasów
	 * Przyk³ad b:
	 * "2 * (3.4 - (-7)/2)*(a-2)/(b-1))"
	 * Wynik:
	 * OK
	 * (!) B£¥D W PRZYK£ADACH - OBA S¥ Z£E!
	 */
	static void checkParentheses() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj wyra¿enie:");
		String str = scanner.nextLine();
		scanner.close();

		//2 * (3.4 - (-7)/2)*(a-2)/(b-1)))
		int oldLength = str.length();
		while (str.length() != 0) {
			str = str.replace("()", "");

			if (oldLength == str.length()) {
				System.out.println("B³êdne sparowanie nawiasów");
				return;
			}
			oldLength = str.length();
		}
		System.out.println("OK");
	}
	/**
	 * TASK SIX.
	 * Napisz program, który umo¿liwia szyfrowanie podanego ci¹gu znaków przy u¿yciu
	 * szyfru Cezara, który jest szczególnym przypadkiem szyfru podstawieniowego
	 * monoalfabetycznego.
	 * U¿ytkownik program podaje tekst do zaszyfrowania oraz liczbê n, o któr¹ przesuniêty
	 * jest alfabet za pomoc¹ którego szyfrujemy tekst. Dla uproszczenia mo¿na
	 * przyj¹æ, ¿e ³añuch wejœciowy sk³ada siê tylko z ma³ych liter alfabetu angielskiego,
	 * tj. ’a’ – ’z’ (26 znaków) oraz spacji.
	 * Przyk³ad 1.
	 * Podaj ³añcuch znaków do zaszyfrowania: abrakadabraz
	 * Podaj przesuniêcie: 2
	 * Zaszyfrowany tekst: cdtcmcfcdtcb
	 */
	static void caesarCipher() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Podaj ci¹g:");
			String str = scanner.nextLine();

			System.out.println("Podaj liczbê ca³kowit¹ dodatni¹:");
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
