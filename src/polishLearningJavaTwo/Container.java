package polishLearningJavaTwo;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Zaj�cia 2 � instrukcje warunkowe, p�tle.
 * @author kaje11
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisa� program, kt�ry pobiera od u�ytkownika liczb� ca�kowit� dodatni�, a nast�pnie
	 * wy�wietla na ekranie kolejno wszystkie liczby niepatrzyste nie wi�ksze od
	 * podanej liczby.
	 * Przyk�ad, dla 15 program powinien wy�wietli� 1, 3, 5, 7, 9, 11, 13, 15.
	 */

	static void showUneven() {
		System.out.println("Podaj ca�kowit� liczb� dodatni�:");
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
	 * Napisa� program pobieraj�cy od u�ytkownika dwie liczby ca�kowite A oraz B,
	 * A < B, a nast�pnie wyznaczaj�cy sum� ci�gu liczb od A do B, czyli sum� ci�gu
	 * (A, A + 1, . . . , B). Obliczenia nale�y wykona� trzykrotnie stosuj�c kolejno p�tle:
	 * while, do-while, for.
	 * Przyk�ad:
	 * Dla A = 4 i B = 11 program powinien wy�wietli�:
	 * 60
	 * 60
	 * 60
	 */
	static void sumBetween() {
		int a = 0, b = 0;

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Podaj pierwsz� liczb� ca�kowit�:");
			a = scanner.nextInt();

			System.out.println("Podaj drug� liczb� ca�kowit�:");
			b = scanner.nextInt();

			if (!(a < b)) {
				throw new Exception();
			}
		} catch (InputMismatchException e) {
			System.out.println("B��dna warto��");
			return;
		} catch (Exception e) {
			System.out.println("B��d. A nie jest mniejsze od B");
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
	 * Napisa� program, kt�ry wczytuje od u�ytkownika liczb� ca�kowit� dodatni� n, a
	 * nast�pnie wy�wietla na ekranie wszystkie pot�gi liczby 2 nie wi�ksze, ni� podana
	 * liczba. Przyk�adowo, dla liczby 71 program powinien wy�wietli�:
	 * 1
	 * 2
	 * 4
	 * 8
	 * 16
	 * 32
	 * 64
	 */
	static void showPowers() {
		System.out.println("Podaj ca�kowit� liczb� dodatni�:");
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
	 *  Napisa� program, kt�ry wczytuje liczby podawane przez u�ytkownika dot�d, dop�ki
	 *  nie podana zostanie liczba 0. Nast�pnie wy�wietli� sum� wszystkich podanych
	 *  liczb.
	 */
	static void sumTillZero() {
		double chosenNum, sum = 0;

		System.out.println("Podaj liczby (0 ko�czy algorytm):");
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
	 * Napisa� program, kt�ry pobiera od u�ytkownika ci�g liczb ca�kowitych. Pobieranie
	 * danych ko�czone jest podaniem warto�ci 0 (nie wliczana do danych). W nast�pnej
	 * kolejno�ci program powinien wy�wietli� sum� najwi�kszej oraz najmniejszej z
	 * podanych liczb oraz ich �redni� arytmetyczn�.
	 * Przyk�ad:
	 * U�ytkownik poda� ci�g: 1, -4, 2, 17, 0.
	 * Wynik programu:
	 * 13 // suma min. i maks.
	 * 6.5 // �rednia
	 */
	static void showMinMaxAvg() {
		System.out.println("Podaj liczby (0 ko�czy algorytm):");
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
					+ "\n�rednia: " + avg);
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}
	/**
	 * TASK SIX.
	 * Gra w �Za du�o, za ma�o�. Komputer losuje liczb� z zakresu 1 . . . 100, a gracz
	 * (u�ytkownik) ma za zadanie odgadn��, co to za liczba poprzez podawanie kolejnych
	 * warto�ci. Je�eli podana warto�� jest:
	 * � wi�ksza � wy�wietlany jest komunikat �Poda�e� za du�� warto��,
	 * � mniejsza � wy�wietlany jest komunikat �Poda�e� za ma�� warto��,
	 * � identyczna z wylosowan� � wy�wietlany jest komunikat �Gratulacje� i gra
	 * si� ko�czy
	 * (!) B��d w poleceniu - nie zaznaczono, �e ma to by� liczba ca�kowita!
	 */
	static void guessNum() {
		Random generator = new Random();
		int goal = generator.nextInt(100) + 1;
		int chosenNum = 0;

		System.out.println("Zgadnij liczb� ca�kowit� (1-100):");
		try (Scanner scanner = new Scanner(System.in)) {
			while ((chosenNum = scanner.nextInt()) != goal) {
				if (chosenNum < goal) {
					System.out.println("Poda�e� za ma�� warto��");
				} else if (chosenNum > goal) {
					System.out.println("Poda�e� za du�� warto��");
				}
			}
			System.out.println("Gratulacje");
		} catch (Exception e) {
			System.out.println("Niepoprawna liczba");
		}
	}
	/**
	 * TASK SEVEN.
	 *  Napisa� program dzia�aj�cy w trybie konsolowym (tekstowym) i rysuj�cy na ekranie
	 *  prostok�t. U�ytkownik podaje znak wype�nienia prostok�ta, pozycj� lewego
	 *  g�rnego rogu prostok�ta (x, y) oraz d�ugo�ci bok�w prostok�ta (ab). Przyjmujemy,
	 *  �e lewy g�rny naro�nik konsoli ma wsp�rz�dne (x, y) = (1, 1).
	 *  Przyk�ad: x=6, y=3, a=4, b=6, zn=�x�
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
			System.out.println("Podaj pozycj� g�rnego rogu (x):");
			int x = scanner.nextInt();

			System.out.println("Podaj pozycj� g�rnego rogu (y):");
			int y = scanner.nextInt();

			System.out.println("Podaj wysoko��:");
			int a = scanner.nextInt();

			System.out.println("Podaj d�ugo��:");
			int b = scanner.nextInt();

			System.out.println("Podaj znak wype�nienia:");
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
			System.out.println("B��d! Poda�e� b��dn� liczb�");
		}
	}

	/**
	 * TASK EIGHT.
	 * Napisa� program rysuj�cy w konsoli �choink� z�o�on� ze znak�w gwiazdki (*).
	 * U�ytkownik programu powinien poda� liczb� ca�kowit� n, n > 0, okre�laj�c�
	 * wysoko�� choinki (liczb� wierszy).
	 * Przyk�ad: dla n = 5 wynik powinien wygl�da� nast�puj�co:
	 *     *
	 *    ***
	 *   *****
	 *  *******
	 * *********
	 */
	static void drawSpruce() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Podaj wysoko�� choinki:");
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
	 * Napisa� program, kt�ry pobiera od u�ytkownika liczb� ca�kowit�, a nast�pnie:
	 * � oblicza sum� cyfr tej liczby,
	 * � stosunek �redniej arytmetycznej cyfr parzystych do �redniej arytmetycznej
	 * cyfr nieparzystych.
	 */

	static void sumOfDigits() {
		try (Scanner scanner = new Scanner(System.in)) {
			int even = 0,
					evenDigits = 0,
					uneven = 0,
					unevenDigits = 0,
					digit;

			System.out.println("Podaj liczb� ca�kowit� dodatni�:");
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
	 * Napisa� program, dla podanej liczby ca�kowitej wy�wietla jej dzielniki. Przyk�adowo,
	 * dla liczby 21 dzielniki to: 1, 3, 7, 21.
	 * @param num - liczba ca�kowita
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
	 *  Napisa� program, kt�ry sprawdza, czy podana liczba ca�kowita n, n > 1, jest
	 *  liczb� pierwsz�.
	 *  @param num - liczba ca�kowita
	 *  @return boolean - czy jest liczb� ca�kowit�, czy nie
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
