package polishLearningJavaThree;

import java.util.Random;
import java.util.Scanner;

/**
 * Zajęcia 3 – tablice.
 * @author kaje11
 *
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisać program, który:
	 * • utworzy tablicę 10 liczb całkowitych i wypełni ją wartościami losowymi z
	 * przedziału [−10, . . . , 10],
	 * • wypisze na ekranie zawartość tablicy,
	 * • wyznaczy najmniejszy oraz najwięszy element w tablicy,
	 * • wyznaczy średnią arytmetyczną elementów tablicy,
	 * • wyznaczy ile elementów jest mniejszych, ile większych od średniej.
	 * • wypisze na ekranie zawartość tablicy w odwrotnej kolejności, tj. od ostatniego
	 * do pierwszego.
	 * Wszystkie wyznaczone wartości powinny zostać wyświetlone na ekranie.
	 * Wylosowane liczby:
	 * -3 9 2 -10 -3 -4 -1 -5 -10 8
	 * Min: -10, max: 9
	 * Średnia: -1,00
	 * Mniejszych od śr.: 6
	 * Większych od śr.: 3
	 * Liczby w odwrotnej kolejności:
	 * 8 -10 -5 -1 -4 -3 -10 2 9 -3
	 */
	static void randomArrayInfo() {
		int[] array = new int[10];
		Random generator = new Random();

		System.out.println("Wylosowane liczby: ");
		int min = -11, max = 11, sum = 0;
		for (int i = 0; i < 10; i++) {
			array[ i ] = generator.nextInt(21) - 10;
			System.out.print(array[ i ] + " ");

			if (array[ i ] < min) {
				min = array[ i ];
			} else if (array[ i ] > max) {
				max = array[ i ];
			}
			sum += array[ i ];
		}
		System.out.println();
		double avg = sum / 10;
		int aboveAvg = 0, belowAvg = 0;

		for (int i = 0; i < 10; i++) {
			if ((double) array[ i ] > avg) {
				aboveAvg++;
			} else if ((double) array[ i ] != avg) {
				belowAvg++;
			}
		}

		System.out.println("Min: " + min + ", max: " + max);
		System.out.println("Średnia: " + avg);
		System.out.println("Mniejszych od śr.: " + belowAvg);
		System.out.println("Większych od śr.: " + aboveAvg);
		System.out.println("Liczby w odwrotnej kolejności:");
		for (int i = 9; i >= 0; i--) {
			System.out.print(array[ i ] + " ");
		}
	}
	/**
	 * TASK TWO.
	 * Napisać program, który utworzy tablicę 20 liczb całkowitych z przedziału 1 . . . 10,
	 * a następnie wypisze na ekranie ile razy każda z liczb z tego przedziału powtarza
	 * się w tablicy.
	 * Przykład:
	 * Wylosowane liczby: 6 5 4 5 10 5 8 3 10 6 6 6 4 3 2 8 1 3 4 7
	 * Wystąpienia:
	 * 1 - 1
	 * 2 - 1
	 * 3 - 3
	 * 4 - 3
	 * 5 - 3
	 * 6 - 4
	 * 7 - 1
	 * 8 - 2
	 * 9 - 0
	 * 10 - 2
	 */
	static void frequencyArray() {
		int[] array = new int[ 20 ];
		int[] freq = new int[ 20 ];
		Random generator = new Random();

		System.out.print("Wylosowane liczby: ");
		for (int i = 0; i < 20; i++) {
			array[ i ] = generator.nextInt(10) + 1;
			System.out.print(array[ i ] + " ");
		}

		for (int i = 0; i < 20; i++) {
			freq[ array[ i ] - 1 ]++;
		}

		System.out.println("\nWystąpienia:");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + " - " + freq[ i ]);
		}
	}

	/**
	 * TASK THREE.
	 * Napisz program, który:
	 * • stworzy tablicę (macierz) 5 x 5 liczb całkowitych,
	 * • wypełnij ją losowymi wartościami z zakresu {−5, −4, . . . , 5},
	 * • dla każdej kolumny wyznacz minimum,
	 * • dla każdej kolumny wyznaczy maksimum.
	 * Program ma wyświetlać tablicę wypełnioną liczbami oraz tablice z minimami oraz
	 * maksymami.
	 */
	static void randomMatrix() {
		Random generator = new Random();

		int[][] matrix = new int[ 5 ][ 5 ];
		int[] min = new int[ 5 ];
		int[] max = new int[ 5 ];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrix[ i ][ j ] = generator.nextInt(11) - 5;
				System.out.printf("%3d", matrix[ i ][ j ]);
			}
			min[ i ] = matrix[ 0 ][ i ];
			max[ i ] = matrix[ 0 ][ i ];
			System.out.println();
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (matrix[ i ][ j ] < min[ j ]) {
					min[ j ] = matrix[ i ][ j ];
				} else if (matrix[ i ][ j ] > max[ j ]) {
					max[ j ] = matrix[ i ][ j ];
				}
			}
		}
		System.out.println("Kolumny min: ");
		for (int i = 0; i < 5; i++) {
			System.out.printf("%3d", min[ i ]);
		}

		System.out.println("\nKolumny max: ");
		for (int i = 0; i < 5; i++) {
			System.out.printf("%3d", max[ i ]);
		}
	}
	/**
	 * TASK FOUR.
	 * Napisać program, który wczytuje od użytkownika liczbę całkowitą, a następnie
	 * wyświetla jej reprezentację w kodzie binarnym (ZM). Podczas konwersji liczby
	 * należy kolejne jej bity zapisywać w pomocniczej tablicy liczb całk. o rozmiarze
	 * 32. Konwersji należy dokonać korzystając z operacji dzielenia całkowitego oraz
	 * operacji modulo.
	 * Przykład:
	 * Wejście:
	 * -75 (liczba podana przez użytkownika)
	 * Wynik:
	 * Liczba -75 binarnie: 1.1001011

	 */
	static void binaryZM() {
		try (Scanner reader = new Scanner(System.in)) {
			System.out.println("Wpisz liczbę");
			int myNum = reader.nextInt();
			System.out.printf("Liczba %d binarnie\n", myNum);
			int[] binary = new int[32];

			if (myNum < 0) {
				System.out.print("1.");
				myNum = Math.abs(myNum);
			} else {
				System.out.print(0);
			}

			int inc = 0;
			while (myNum > 0) {
				binary[inc++] = myNum % 2;
				myNum /= 2;
			}
			for (int i = inc - 1; i >= 0; i--) {
				System.out.print(binary[i]);
			}
		} catch (Exception e) {
			System.out.println("Błędna liczba");
		}
	}

	/**
	 * TASK FIVE.
	 * Napisz program, który pobiera od użytkownika dodatnią liczbę naturalną n i
	 * tworzy tablicę a zmiennych typu logicznego (boolean) o rozmiarze n×n. Następnie
	 * program powinien wypełnić utworzoną tablicę, tak by a[i][j] = true jeżeli liczby
	 * (i+1) oraz (j+1) są względnie pierwsze, tzn. nie mają wspólnych dzielników poza
	 * 1. Tak utworzoną tablicę należy wypisać na ekranie, przy czym dla wartości true
	 * należy wyświetlić znak ”+”, natomiast dla wartości false znak ”.”. Przykład:
	 * Podaj liczbę (> 0): 10
	 * 1 2 3 4 5 6 7 8 9 10
	 * 1 + + + + + + + + + +
	 * 2 + . + . + . + . + .
	 * 3 + + . + + . + + . +
	 * 4 + . + . + . + . + .
	 * 5 + + + + . + + + + .
	 * 6 + . . . + . + . . .
	 * 7 + + + + + + . + + +
	 * 8 + . + . + . + . + .
	 * 9 + + . + + . + + . +
	 * 10 + . + . . . + . + .
	 */

	static void dzielniki() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Podaj liczbę > 0: ");
			int n = scanner.nextInt();

			if (n <= 0) {
				throw new Exception();
			}

			boolean[][] a = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((i == 0 || j == 0) || !majaWspolneDzielniki(i + 1, j + 1)) {
						a[ i ][ j ] = true;
					}
				}
			}
			for (int i = -1; i < n; i++) {
				if (i != -1) {
					System.out.printf("%-3d", (i + 1));
				}

				for (int j = -1; j < n; j++) {
					if (i == -1) {
						System.out.printf("%-3d", (j + 1));
					} else if (j != -1) {
						System.out.printf("%-3s", a[ i ][ j ] ? "+" : ".");
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Błędna liczba");
		}
	}
	/**
	 * Has common factors method.
	 * @param a - a
	 * @param b - b
	 * @return boolean - do they, or not.
	 */
	static boolean majaWspolneDzielniki(int a, int b) {
		if (a == b) {
			return true;
		}
		while (b != 0) {
	        if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
	    }
		return a > 1;
	}

	/**
	 * TASK SIX.
	 * Napisać funkcję, która jako parametry otrzymuje:
	 * • dwuwymiarową tablicę liczb całkowitych,
	 * • dwuwymiarową tablicę boolowską (tej samej wielkości, co pierwsza tablica),
	 * • dwie liczby całkowite.
	 * W funkcji należy pierwszą tablicę wypełnić losowymi wartościami całkowitymi z przedziału [-100,
	 * 200), ale z wyjątkiem elementów znajdujących się na przekątnych, które w ok. 25% przypadków mają
	 * otrzymać wartość 1, a w pozostałych 75% wartość -1.
	 * Po wypełnieniu całej tablicy należy policzyć, ile jej elementów posiada wartość taką samą, jak jeden z
	 * parametrów. Ponadto policzyć sumę elementów, dla których w odpowiednich komórkach drugiej
	 * tablicy (boolowskiej) zapisana jest wartość true.
	 * Funkcja zwraca stosunek liczby elementów pasujących do parametrów, do obliczonej sumy.
	 * @param intUser - macierz liczb całk.
	 * @param boolUser - macierz Boolowska
	 * @param paramOne - parametr pierwszy
	 * @param paramTwo - parametr drugi
	 * @return stosunek liczby elementów
	 */
	static float stosunek(int[][] intUser, boolean[][] boolUser, int paramOne, int paramTwo) {
		Random rnd = new Random();

		int len = intUser.length;
		int[][] intArray = new int[ len ][ len ];
		boolean[][] boolArray = new boolean[ len ][ len ];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i == j) {
					intArray[ i ][ j ] = Math.random() > 75 ? 1 : -1;
				} else {
					intArray[ i ][ j ] = rnd.nextInt(301) - 100;
				}
			}
		}

		int sum = 0, occurences = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (intArray[ i ][ j ] == paramOne
						|| intArray[ i ][ j ] == paramTwo) {
					occurences++;
				}
				if (boolArray[ i ][ j ]) {
					sum += intArray[ i ][ j ];
				}
			}
		}
		return sum != 0 ? occurences / sum : 0;
	}
}
