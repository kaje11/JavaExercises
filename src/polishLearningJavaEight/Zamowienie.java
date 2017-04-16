package polishLearningJavaEight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Zamowienie implements Serializable {
	private int maksRozmiar;
	private ArrayList<Pozycja> pozycje = new ArrayList<Pozycja>();
	private int ileDodanych = 0;

	public Zamowienie() {
		this(10);
	}
	public Zamowienie(final int maksRozmiar) {
		this.maksRozmiar = maksRozmiar;
	}
	public final void dodajPozycje(final Pozycja p) {
		if (!this.pozycje.contains(p)) {
			this.pozycje.add(p);
		}
		this.ileDodanych++;
	}
	public final double obliczWartosc() {
		double wartosc = 0;
		for (Pozycja poz: pozycje) {
			wartosc += poz.obliczWartosc();
		}

		return wartosc;
	}

	public final String toString() {
		String myString = "\n\nZamówienie:\n";
		for (Pozycja poz: pozycje) {
			myString += poz.toString() + "\n";
		}
		myString += String.format("\nRazem: %.2f z³", this.obliczWartosc());
		return myString;
	}

	public final void usunPozycje(final int indeks) {
		if (indeks < pozycje.size()) {
			this.pozycje.remove(indeks);
			//this.ileDodanych--; nie ma tego w poleceniu
		} else {
			System.out.println("B³¹d!");
		}
	}

	public final void edytujPozycje(final int indeks) {
		if (indeks >= pozycje.size()) {
			System.out.println("Pozycja nie istnieje");
			return;
		}

		try (Scanner scanner = new Scanner(System.in)) {
			Pozycja edytowanaPozycja = this.pozycje.get(indeks);
			System.out.printf("Zmieñ nazwê %s na: ",
					edytowanaPozycja.getNazwaTowaru());
			String newName = scanner.nextLine();
			if (newName == "") {
				throw new Exception();
			}

			System.out.printf("Zmieñ cenê %f na: ",
					edytowanaPozycja.getCena());

			double cena = scanner.nextDouble();
			if (cena <= 0) {
				throw new Exception();
			}

			System.out.printf("Zmieñ iloœæ sztuk %f na: ",
					edytowanaPozycja.getIleSztuk());

			int ileSztuk = scanner.nextInt();
			if (cena < 0) {
				throw new Exception();
			}
			edytowanaPozycja.setNazwaTowaru(newName);
			edytowanaPozycja.setCena(cena);
			edytowanaPozycja.setIleSztuk(ileSztuk);
		} catch (Exception e) {
			System.out.println("Niepoprawne dane");
		}
	}
	public static void zapiszZamowienie(Zamowienie z, String nazwaPliku) {
		try (FileOutputStream fout = new FileOutputStream(nazwaPliku);
			ObjectOutputStream oos = new ObjectOutputStream(fout)) {
			oos.writeObject(z);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Zamowienie wczytajZamowienie(String nazwaPliku) {
		Zamowienie loadedClass = null;
		try (FileInputStream fileIn = new FileInputStream(nazwaPliku);
			ObjectInputStream in = new ObjectInputStream(fileIn)) {
			loadedClass = (Zamowienie) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return loadedClass;
	}
}
