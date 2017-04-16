package polishLearningJavaOne;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Container {
	/**
	 * TASK ONE.
	 * Napisaæ program s³u¿¹cy do konwersji wartoœci temperatury podanej w stopniach
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
	 * Wczytaæ od u¿ytkownika 3 liczby ca³kowite i wypisaæ na ekran najwiêksz¹ oraz
	 * najmniejsz¹ z nich.
	 */
	static void showEdgyNumbers() {
		final int MAX_NUMBERS = 3;
		int[] checkNumbers = new int[ MAX_NUMBERS ];

		try (Scanner scanner = new Scanner(System.in)) {
			for (int i = 0; i < MAX_NUMBERS; i++) {
				System.out.println("WprowadŸ " + (i + 1) + " liczbê");
				checkNumbers[ i ] = scanner.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("Nie wprowadzono liczby ca³kowitej");
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
		System.out.println("Najwiêksz¹ liczb¹ jest: " + highest);
		System.out.println("Najmniejsz¹ liczb¹ jest: " + lowest);
	}

	/**
	 * TASK THREE.
	 * Napisaæ program, który oblicza wartoœæ wspó³czynnika BMI
	 * (ang. body mass index) wg. wzoru: waga / wzrost^2.
	 * Je¿eli wynik jest w przedziale (18,5 - 24,9) to wypisuje
	 * ”waga prawid³owa”, je¿eli poni¿ej to ”niedowaga”, je¿eli powy¿ej ”nadwaga”.
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
			System.out.println("waga prawid³owa");
		}
	}

	/**
	 * TASK FOUR.
	 * Napisaæ program obliczaj¹cy nale¿ny podatek dochodowy od osób fizycznych. Program
	 * ma pobieraæ od u¿ytkownika dochód i po obliczeniu wypisywaæ na ekranie
	 * nale¿ny podatek. Podatek obliczany jest wg. nastêpuj¹cych regu³:
	 * • do 85.528 podatek wynosi 18% podstawy minus 556,02 PLN,
	 * • od 85.528 podatek wynosi 14.839,02 z³ + 32% nadwy¿ki ponad 85.528,00
	 * @param income - przychód
	 */
	static void showTax(final double income) {
		final double baseStep = 85528;
		final float
				taxBelowBase = 0.82f,
				reductionBelowBase = 556.02f,
				taxAboveBase = 14839.02f,
				increaseAboveBase = 0.68f;

		System.out.print("Nale¿ny podatek: ");
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
	 * W sklepie ze sprzêtem AGD oferowana jest sprzeda¿ ratalna. Napisz program
	 * umo¿liwiaj¹cy wyliczenie wysokoœci miesiêcznej raty za zakupiony sprzêt. Danymi
	 * wejœciowymi dla programu s¹:
	 * • cena towaru (od 100 z³ do 10 tyœ. z³),
	 * • liczba rat (od 6 do 48).
	 * Kredyt jest oprocentowany w zale¿noœci od liczby rat:
	 * • od 6–12 wynosi 2.5% ,
	 * • od 13–24 wynosi 5%,
	 * • od 25–48 wynosi 10%.
	 * Obliczona miesiêczna rata powinna zawieraæ równie¿ odsetki. Program powinien
	 * sprawdzaæ, czy podane dane mieszcz¹ siê w okreœlonych powy¿ej zakresach, a w
	 * przypadku b³êdu pytaæ prosiæ u¿ytkownika ponownie o podanie danych.
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
			System.out.println("Podaj cenê");
			try {
				price = scanner.nextDouble();

				if (price < minPrice || price > maxPrice) {
					System.out.printf("Cena z zakresu %dz³ < cena < %dz³!\n",
							minPrice, maxPrice);
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Niepoprawna cena");
			}
			break;
		}

		while (true) {
			System.out.println("Podaj ratê");
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
		System.out.println("Miesiêczna rata: " + monthlyPayment);
	}

	/**
	 * TASK SIX.
	 * 6. Napisaæ program realizuj¹cy funkcje prostego kalkulatora, pozwalaj¹cego na wykonywanie
	 * operacji dodawania, odejmowania, mno¿enia i dzielenia na dwóch liczbach
	 * rzeczywistych. Program ma identyfikowaæ sytuacjê wprowadzenia b³êdnego
	 * symbolu dzia³ania oraz próbê dzielenia przez zero. Zastosowaæ instrukcjê switch
	 * do wykonania odpowiedniego dzia³ania w zale¿noœci od wprowadzonego symbolu
	 * operacji. Scenariusz dzia³ania programu:
	 * a) Program wyœwietla informacjê o swoim przeznaczeniu.
	 * b) Wczytuje pierwsz¹ liczbê.
	 * c) Wczytuje symbol operacji arytmetycznej: +, -, *, /.
	 * d) Wczytuje drug¹ liczbê.
	 * e) Wyœwietla wynik lub - w razie koniecznoœci - informacjê o niemo¿noœci wykonania
	 * dzia³ania.
	 * f) Program koñczy swoje dzia³anie po naciœniêciu przez u¿ytkownika klawisza
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
					System.out.println("Nie dzieli siê przez zero!");
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
			System.out.println("Podaj " + which + " liczbê: ");
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
