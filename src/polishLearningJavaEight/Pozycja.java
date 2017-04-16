package polishLearningJavaEight;

import java.io.Serializable;

public class Pozycja implements Serializable {
	private String nazwaTowaru;
	private int ileSztuk;
	private double cena;

	public Pozycja(final String nazwaTowaru, final int ileSztuk, final double cena) {
		this.nazwaTowaru = nazwaTowaru;
		this.ileSztuk = ileSztuk;
		this.cena = cena;
	}
	public final double obliczWartosc() {
		if (this.ileSztuk >= 5) {
			System.out.print("Na³o¿ony rabat ");
			if (this.ileSztuk < 10) {
				System.out.print("5%");
			} else if (this.ileSztuk <= 20) {
				System.out.print("10%");
			} else {
				System.out.print("15%");
			}
			System.out.print(" daje cenê koñcow¹: " + this.obliczWartoscZRabatem());
		}
		return this.cena * this.ileSztuk;
	}

	public final String toString() {
		return String.format("%-20.20s%-13.13s%-8.8s%13.13s",
				this.nazwaTowaru,
				String.format("%.2f z³", this.cena),
				String.format("%d szt", this.ileSztuk),
				String.format("%.2f z³", this.obliczWartosc()));
	}

	public final double obliczWartoscZRabatem() {
		if (this.ileSztuk >= 5) {
			if (this.ileSztuk < 10) {
				return this.obliczWartosc() * 0.95;
			} else if (this.ileSztuk <= 20) {
				return this.obliczWartosc() * 0.90;
			} else {
				return this.obliczWartosc() * 0.85;
			}
		}
		return this.obliczWartosc();
	}
	public double getCena() {
		return this.cena;
	}
	public String getNazwaTowaru() {
		return this.nazwaTowaru;
	}
	public int getIleSztuk() {
		return this.ileSztuk;
	}
	public void setCena(double nowaCena) {
		this.cena = nowaCena;
	}
	public void setNazwaTowaru(String nowaNazwa) {
		this.nazwaTowaru = nowaNazwa;
	}
	public void setIleSztuk(int noweSztuki) {
		this.ileSztuk = noweSztuki;
	}
}
