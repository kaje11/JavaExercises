package polishLearningJavaTwo;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Zajêcia 2 – instrukcje warunkowe, pêtle.
 * @author kaje11
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisaæ program, który pobiera od u¿ytkownika liczbê ca³kowit¹ dodatni¹, a nastêpnie
	 * wyœwietla na ekranie kolejno wszystkie liczby niepatrzyste nie wiêksze od
	 * podanej liczby.
	 * Przyk³ad, dla 15 program powinien wyœwietliæ 1, 3, 5, 7, 9, 11, 13, 15.
	 */

	static void showUneven() {
		System.out.println("Podaj ca³kowit¹ liczbê dodatni¹:");
		try (Scanner scanner = new Scanner(System.in)) {
			int showTo = scanner.nextInt();
			if (showTo < 0) {
				throw new Exception();
			}

			for (int i = 1; i < showTo; i += 2) {
				System.out.println(i);
			}
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}

	/**
	 * TASK TWO.
	 * Napisaæ program pobieraj¹cy od u¿ytkownika dwie liczby ca³kowite A oraz B,
	 * A < B, a nastêpnie wyznaczaj¹cy sumê ci¹gu liczb od A do B, czyli sumê ci¹gu
	 * (A, A + 1, . . . , B). Obliczenia nale¿y wykonaæ trzykrotnie stosuj¹c kolejno pêtle:
	 * while, do-while, for.
	 * Przyk³ad:
	 * Dla A = 4 i B = 11 program powinien wyœwietliæ:
	 * 60
	 * 60
	 * 60
	 */
	static void sumBetween() {
		int a = 0, b = 0;

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Podaj pierwsz¹ liczbê ca³kowit¹:");
			a = scanner.nextInt();

			System.out.println("Podaj drug¹ liczbê ca³kowit¹:");
			b = scanner.nextInt();

			if (!(a < b)) {
				throw new Exception();
			}
		} catch (InputMismatchException e) {
			System.out.println("B³êdna wartoœæ");
			return;
		} catch (Exception e) {
			System.out.println("B³¹d. A nie jest mniejsze od B");
			return;
		}

		int increment = a, sum = 0;

		while (increment <= b) {
			sum += increment;
			increment++;
		}
		System.out.println("Wynik [while]: " + sum);

		increment = a;
		sum = 0;

		do {
			sum += increment;
			increment++;
		} while (increment <= b);

		System.out.println("Wynik [do...while]: " + sum);

		for (increment = a, sum = 0; increment <= b; increment++) {
			sum += increment;
		}

		System.out.println("Wynik [for]: " + sum);
	}
	/**
	 * TASK THREE.
	 * Napisaæ program, który wczytuje od u¿ytkownika liczbê ca³kowit¹ dodatni¹ n, a
	 * nastêpnie wyœwietla na ekranie wszystkie potêgi liczby 2 nie wiêksze, ni¿ podana
	 * liczba. Przyk³adowo, dla liczby 71 program powinien wyœwietliæ:
	 * 1
	 * 2
	 * 4
	 * 8
	 * 16
	 * 32
	 * 64
	 */
	static void showPowers() {
		System.out.println("Podaj ca³kowit¹ liczbê dodatni¹:");
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			if (n < 0) {
				throw new Exception();
			}

			for (int power = 1; power < n; power = power * 2) {
				System.out.println(power);
			}
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}

	/**
	 * TASK FOUR.
	 *  Napisaæ program, który wczytuje liczby podawane przez u¿ytkownika dot¹d, dopóki
	 *  nie podana zostanie liczba 0. Nastêpnie wyœwietliæ sumê wszystkich podanych
	 *  liczb.
	 */
	static void sumTillZero() {
		double chosenNum, sum = 0;

		System.out.println("Podaj liczby (0 koñczy algorytm):");
		try (Scanner scanner = new Scanner(System.in)) {
			while ((chosenNum = scanner.nextDouble()) != 0) {
				sum += chosenNum;
			}
			System.out.println("Suma: " + sum);
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}

	/**
	 * TASK FIVE.
	 * Napisaæ program, który pobiera od u¿ytkownika ci¹g liczb ca³kowitych. Pobieranie
	 * danych koñczone jest podaniem wartoœci 0 (nie wliczana do danych). W nastêpnej
	 * kolejnoœci program powinien wyœwietliæ sumê najwiêkszej oraz najmniejszej z
	 * podanych liczb oraz ich œredni¹ arytmetyczn¹.
	 * Przyk³ad:
	 * U¿ytkownik poda³ ci¹g: 1, -4, 2, 17, 0.
	 * Wynik programu:
	 * 13 // suma min. i maks.
	 * 6.5 // œrednia
	 */
	static void showMinMaxAvg() {
		System.out.println("Podaj liczby (0 koñczy algorytm):");
		try (Scanner scanner = new Scanner(System.in)) {
			int min = 0, max = 0, chosenNum;

			while ((chosenNum = scanner.nextInt()) != 0) {
				if (chosenNum < min) {
					min = chosenNum;
				} else if (chosenNum > max) {
					max = chosenNum;
				}
			}

			int sum = min + max;
			double avg = sum / 2;
			System.out.println("Suma: " + sum
					+ "\nŒrednia: " + avg);
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}
	/**
	 * TASK SIX.
	 * Gra w ”Za du¿o, za ma³o”. Komputer losuje liczbê z zakresu 1 . . . 100, a gracz
	 * (u¿ytkownik) ma za zadanie odgadn¹æ, co to za liczba poprzez podawanie kolejnych
	 * wartoœci. Je¿eli podana wartoœæ jest:
	 * • wiêksza – wyœwietlany jest komunikat „Poda³eœ za du¿¹ wartoœæ”,
	 * • mniejsza – wyœwietlany jest komunikat „Poda³eœ za ma³¹ wartoœæ”,
	 * • identyczna z wylosowan¹ – wyœwietlany jest komunikat „Gratulacje” i gra
	 * siê koñczy
	 * (!) B³¹d w poleceniu - nie zaznaczono, ¿e ma to byæ liczba ca³kowita!
	 */
	static void guessNum() {
		Random generator = new Random();
		int goal = generator.nextInt(100) + 1;
		int chosenNum = 0;

		System.out.println("Zgadnij liczbê ca³kowit¹ (1-100):");
		try (Scanner scanner = new Scanner(System.in)) {
			while ((chosenNum = scanner.nextInt()) != goal) {
				if (chosenNum < goal) {
					System.out.println("Poda³eœ za ma³¹ wartoœæ");
				} else if (chosenNum > goal) {
					System.out.println("Poda³eœ za du¿¹ wartoœæ");
				}
			}
			System.out.println("Gratulacje");
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}
	/**
	 * TASK SEVEN.
	 *  Napisaæ program dzia³aj¹cy w trybie konsolowym (tekstowym) i rysuj¹cy na ekranie
	 *  prostok¹t. U¿ytkownik podaje znak wype³nienia prostok¹ta, pozycjê lewego
	 *  górnego rogu prostok¹ta (x, y) oraz d³ugoœci boków prostok¹ta (ab). Przyjmujemy,
	 *  ¿e lewy górny naro¿nik konsoli ma wspó³rzêdne (x, y) = (1, 1).
	 *  Przyk³ad: x=6, y=3, a=4, b=6, zn=’x’
	 *  >
	 *  >
	 *  > _____xxxxxx
	 *  > _____xxxxxx
	 *  > _____xxxxxx
	 *  > _____xxxxxx
	 *  ozn.
	 *  > - nowa linia,
	 *  _ - znak spacji.
	 */
	static void drawRectangle() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Podaj pozycjê górnego rogu (x):");
			int x = scanner.nextInt();

			System.out.println("Podaj pozycjê górnego rogu (y):");
			int y = scanner.nextInt();

			System.out.println("Podaj wysokoœæ:");
			int a = scanner.nextInt();

			System.out.println("Podaj d³ugoœæ:");
			int b = scanner.nextInt();

			System.out.println("Podaj znak wype³nienia:");
			char zn = scanner.nextLine().charAt(0);

			scanner.close();
			if (x < 0 || y < 0 || a < 1 || b < 1) {
				throw new Exception();
			}

			for (int i = 1; i < y; i++) {
				System.out.println(">");
			}

			for (int height = 0; height < a; height++) {
				System.out.print(">");
				for (int append = 1; append < x; append++) {
					System.out.print("_");
				}

				for (int fill = 0; fill < b; fill++) {
					System.out.print(zn);
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("B³¹d! Poda³eœ b³êdn¹ liczbê");
		}
	}

	/**
	 * TASK EIGHT.
	 * Napisaæ program rysuj¹cy w konsoli „choinkê” z³o¿on¹ ze znaków gwiazdki (*).
	 * U¿ytkownik programu powinien podaæ liczbê ca³kowit¹ n, n > 0, okreœlaj¹c¹
	 * wysokoœæ choinki (liczbê wierszy).
	 * Przyk³ad: dla n = 5 wynik powinien wygl¹daæ nastêpuj¹co:
	 *     *
	 *    ***
	 *   *****
	 *  *******
	 * *********
	 */
	static void drawSpruce() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Podaj wysokoœæ choinki:");
			int n = scanner.nextInt();
			if (n < 0) {
				throw new Exception();
			}

			for (int i = 0, add = 1; i < n; i++, add += 2) {
				System.out.println(
					new String(new char[n - i - 1]).replace("\0", " ")
					+ new String(new char[add]).replace("\0", "*")
				);
			}
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}

	/**
	 * TASK NINE.
	 * Napisaæ program, który pobiera od u¿ytkownika liczbê ca³kowit¹, a nastêpnie:
	 * • oblicza sumê cyfr tej liczby,
	 * • stosunek œredniej arytmetycznej cyfr parzystych do œredniej arytmetycznej
	 * cyfr nieparzystych.
	 */

	static void sumOfDigits() {
		try (Scanner scanner = new Scanner(System.in)) {
			int even = 0,
					evenDigits = 0,
					uneven = 0,
					unevenDigits = 0,
					digit;

			System.out.println("Podaj liczbê ca³kowit¹ dodatni¹:");
			int mynum = scanner.nextInt();

			if (mynum < 0) {
				throw new Exception();
			}

			while (mynum > 0) {
			    digit = mynum % 10;
			    mynum /= 10;

				if (digit % 2 == 0) {
					even += digit;
					evenDigits++;
				} else {
					uneven += digit;
					unevenDigits++;
				}
			}
			int sum = even + uneven;
			int avg = (even / evenDigits) / (uneven / unevenDigits);

			System.out.println("Suma cyfr: " + sum
					+ "\nStosunek: " + avg);
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}

	/**
	 * TASK TEN.
	 * Napisaæ program, dla podanej liczby ca³kowitej wyœwietla jej dzielniki. Przyk³adowo,
	 * dla liczby 21 dzielniki to: 1, 3, 7, 21.
	 * @param num - liczba ca³kowita
	 */
	static void showDivisors(final int num) {
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.println(i);
			}
		}
	}
	/**
	 * TASK ELEVEN.
	 *  Napisaæ program, który sprawdza, czy podana liczba ca³kowita n, n > 1, jest
	 *  liczb¹ pierwsz¹.
	 *  @param num - liczba ca³kowita
	 *  @return boolean - czy jest liczb¹ ca³kowit¹, czy nie
	 */
	static boolean isPrime(final int num) {
		if (num % 2 == 0) {
			return false;
		}

		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
