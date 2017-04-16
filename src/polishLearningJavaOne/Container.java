package polishLearningJavaOne;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Container {
	/**
	 * TASK ONE.
	 * Napisa� program s�u��cy do konwersji warto�ci temperatury podanej w stopniach
	 * Celsjusza na stopnie w skali Fahrenheita (stopnie Fahrenheita = 1.8 * stopnie
	 * Celsjusza + 32.0)
	 * @param celsius - stopnie Celsjusza
	 * @return double - stopnie Fahrenheita
	 */
	static double toFahrenheit(double celsius) {
		return 1.8 * celsius + 32.0;
	}

	/**
	 * TASK TWO.
	 * Wczyta� od u�ytkownika 3 liczby ca�kowite i wypisa� na ekran najwi�ksz� oraz
	 * najmniejsz� z nich.
	 */
	static void showEdgyNumbers() {
		final int MAX_NUMBERS = 3;
		int[] checkNumbers = new int[ MAX_NUMBERS ];

		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 0; i < MAX_NUMBERS; i++) {
				System.out.println("Wprowad� " + (i + 1) + " liczb�");
				checkNumbers[ i ] = scanner.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("Nie wprowadzono liczby ca�kowitej");
		}

		int highest = checkNumbers[ 0 ];
		int lowest = checkNumbers[ 0 ];

		for (int i = 1; i < MAX_NUMBERS; i++) {
			if (checkNumbers[ i ] > highest) {
				highest = checkNumbers[ i ];
			} else if (checkNumbers[ i ] < lowest) {
				lowest = checkNumbers[ i ];
			}
		}
		System.out.println("Najwi�ksz� liczb� jest: " + highest);
		System.out.println("Najmniejsz� liczb� jest: " + lowest);
	}

	/**
	 * TASK THREE.
	 * Napisa� program, kt�ry oblicza warto�� wsp�czynnika BMI
	 * (ang. body mass index) wg. wzoru: waga / wzrost^2.
	 * Je�eli wynik jest w przedziale (18,5 - 24,9) to wypisuje
	 * �waga prawid�owa�, je�eli poni�ej to �niedowaga�, je�eli powy�ej �nadwaga�.
	 * @param weight - waga
	 * @param height - wzrost
	 */
	static void rateBodyMass(double weight, double height) {
		double bmi = weight / Math.pow(height, 2);
		if (bmi < 18.5) {
			System.out.println("niedowaga");
		} else if (bmi > 24.9) {
			System.out.println("nadwaga");
		} else {
			System.out.println("waga prawid�owa");
		}
	}

	/**
	 * TASK FOUR.
	 * Napisa� program obliczaj�cy nale�ny podatek dochodowy od os�b fizycznych. Program
	 * ma pobiera� od u�ytkownika doch�d i po obliczeniu wypisywa� na ekranie
	 * nale�ny podatek. Podatek obliczany jest wg. nast�puj�cych regu�:
	 * � do 85.528 podatek wynosi 18% podstawy minus 556,02 PLN,
	 * � od 85.528 podatek wynosi 14.839,02 z� + 32% nadwy�ki ponad 85.528,00
	 * @param income - przych�d
	 */
	static void showTax(final double income) {
		final double baseStep = 85528;
		final float
				taxBelowBase = 0.82f,
				reductionBelowBase = 556.02f,
				taxAboveBase = 14839.02f,
				increaseAboveBase = 0.68f;

		System.out.print("Nale�ny podatek: ");
		if (income < baseStep) {
			System.out.printf("%2.f",
				income * taxBelowBase + reductionBelowBase);
		} else {
			System.out.printf("%2.f",
				taxAboveBase + increaseAboveBase * (income - baseStep));
		}
	}

	/**
	 * TASK FIVE.
	 * W sklepie ze sprz�tem AGD oferowana jest sprzeda� ratalna. Napisz program
	 * umo�liwiaj�cy wyliczenie wysoko�ci miesi�cznej raty za zakupiony sprz�t. Danymi
	 * wej�ciowymi dla programu s�:
	 * � cena towaru (od 100 z� do 10 ty�. z�),
	 * � liczba rat (od 6 do 48).
	 * Kredyt jest oprocentowany w zale�no�ci od liczby rat:
	 * � od 6�12 wynosi 2.5% ,
	 * � od 13�24 wynosi 5%,
	 * � od 25�48 wynosi 10%.
	 * Obliczona miesi�czna rata powinna zawiera� r�wnie� odsetki. Program powinien
	 * sprawdza�, czy podane dane mieszcz� si� w okre�lonych powy�ej zakresach, a w
	 * przypadku b��du pyta� prosi� u�ytkownika ponownie o podanie danych.
	 */

	static void countInstalment() {
		final int
			minPrice = 100,
			maxPrice = 10000,
			minInstalments = 6,
			maxInstalments = 48;

		double price = 0;
		int instalments = 0;

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Podaj cen�");
			try {
				price = scanner.nextDouble();

				if (price < minPrice || price > maxPrice) {
					System.out.printf("Cena z zakresu %dz� < cena < %dz�!\n",
							minPrice, maxPrice);
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Niepoprawna cena");
			}
			break;
		}

		while (true) {
			System.out.println("Podaj rat�");
			try {
				instalments = scanner.nextInt();

				if (instalments < minInstalments
						|| instalments > maxInstalments) {
					System.out.printf("Raty z zakresu %d < rata < %d\n",
							minInstalments, maxInstalments);
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Niepoprawna rata");
			}
			break;
		}
		scanner.close();

		double monthlyPayment = instalments * price;

		if (instalments <= 12) {
			monthlyPayment *= 0.025;
		} else if (instalments <= 24) {
			monthlyPayment *= 0.05;
		} else {
			monthlyPayment *= 0.1;
		}
		System.out.println("Miesi�czna rata: " + monthlyPayment);
	}

	/**
	 * TASK SIX.
	 * 6. Napisa� program realizuj�cy funkcje prostego kalkulatora, pozwalaj�cego na wykonywanie
	 * operacji dodawania, odejmowania, mno�enia i dzielenia na dw�ch liczbach
	 * rzeczywistych. Program ma identyfikowa� sytuacj� wprowadzenia b��dnego
	 * symbolu dzia�ania oraz pr�b� dzielenia przez zero. Zastosowa� instrukcj� switch
	 * do wykonania odpowiedniego dzia�ania w zale�no�ci od wprowadzonego symbolu
	 * operacji. Scenariusz dzia�ania programu:
	 * a) Program wy�wietla informacj� o swoim przeznaczeniu.
	 * b) Wczytuje pierwsz� liczb�.
	 * c) Wczytuje symbol operacji arytmetycznej: +, -, *, /.
	 * d) Wczytuje drug� liczb�.
	 * e) Wy�wietla wynik lub - w razie konieczno�ci - informacj� o niemo�no�ci wykonania
	 * dzia�ania.
	 * f) Program ko�czy swoje dzia�anie po naci�ni�ciu przez u�ytkownika klawisza
	 * Enter.
	 */

	static void calculator() {
		System.out.println("To jest prosty kalkulator");
		Scanner scanner = new Scanner(System.in);

		double a = getUserNumber(1, scanner);
		System.out.println("Podaj operator:");
		String operator = scanner.nextLine();
		double b = getUserNumber(2, scanner);

		scanner.close();

		double result = 0;

		switch (operator) {
			case "+": result = a + b; break;
			case "-": result = a - b; break;
			case "*": result = a * b; break;
			case "/":
				if (b == 0) {
					System.out.println("Nie dzieli si� przez zero!");
					return;
				}
				result = a / b;
			break;
			default:
				System.out.println("Nieznana operacja!");
				return;
		}
		System.out.println("Wynik: " + result);

	}
	static double getUserNumber(final int which, final Scanner handler) {
		double num = 0;
		boolean isProper;
		do {
			System.out.println("Podaj " + which + " liczb�: ");
			isProper = true;
			try {
				num = handler.nextDouble();
			} catch (InputMismatchException e) {
				isProper = false;
				System.out.println("Niepoprawna liczba");
			}
		} while (!isProper);
		return num;
	}
}
