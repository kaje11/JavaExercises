package polishLearningJavaEight;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Lista {
	private int[] liczby;
	private int pojemnosc;
	private int rozmiar = 0;

	public Lista(int pojemnosc) {
		this.pojemnosc = pojemnosc;
		this.liczby = new int[ pojemnosc ];
	}

	public void dodajElement(int elem) {
		if (this.rozmiar == this.pojemnosc) {
			System.out.println("Nie mo¿na dodaæ wiêcej elementów, lista pe³na!");
			return;
		}
		this.liczby[ rozmiar ] = elem;
		this.rozmiar++;
	}

	public int znajdz(int elem) {
		for (int i = 0; i < this.rozmiar; i++) {
			if (this.liczby[ i ] == elem) {
				return i;
			}
		}
		return -1;
	}
	public void pisz() {
		System.out.printf("Lista:\n\tPojemnoœæ: %d\n\tRozmiar: %d\n\tElementy: ",
				this.pojemnosc, this.rozmiar);

		for (int i = 0; i < this.rozmiar; i++) {
			System.out.print(this.liczby[ i ] + " ");
		}
		System.out.println();
	}
	public void usunPierwszy(int elem) {
		int pos = this.znajdz(elem);
		if (pos == -1) {
			return;
		}

		this.rozmiar--;
		for (int i = pos; i < this.rozmiar; i++) {
			this.liczby[ i ] = this.liczby[i + 1];
		}
		this.liczby[ this.rozmiar ] = 0;
	}
	public void usunPowtorzenia() {
		int[] bezPowtorzen = new int[ this.pojemnosc ];
		int nowyRozmiar = 0;

		boolean znaleziono;
		for (int i = 0; i < this.rozmiar; i++) {
			znaleziono = false;
			for (int j = i + 1; j < rozmiar; j++) {
				if (this.liczby[ i ] == this.liczby[ j ]) {
					znaleziono = true;
					break;
				}
			}

			if (!znaleziono) {
				bezPowtorzen[nowyRozmiar++] = this.liczby[ i ];
			}
		}
		this.rozmiar = nowyRozmiar;
		this.liczby = bezPowtorzen;
	}

	public void odwroc() {
		int[] odwrocona = new int[ this.pojemnosc ];
		for (int i = rozmiar - 1; i >= 0; i--) {
			odwrocona[rozmiar - i] = this.liczby[ i ];
		}
		this.liczby = odwrocona;
	}

	public void zapiszDoPliku(String nazwaWy) {
		try (PrintWriter plikWy = new PrintWriter(nazwaWy)) {
			for (int i = 0; i < this.rozmiar; i++) {
				plikWy.print(this.liczby[ i ] + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
