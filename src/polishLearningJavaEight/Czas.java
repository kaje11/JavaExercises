package polishLearningJavaEight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Czas {
	static final int MIN_IN_HOUR = 60;
	private int godz;
	private int minuty;


	public Czas(int godz, int minuty) {
		this.godz = godz + minuty / MIN_IN_HOUR;
		this.minuty = minuty % MIN_IN_HOUR;
	}
	public Czas(String czas) {
		Matcher matcher = Pattern.compile("([0-9]{1,2}) h ([0-9]{1,2}) min").matcher(czas);
		if (!matcher.find()) {
			this.godz = 0;
			this.minuty = 0;
		} else {
			this.godz = Integer.parseInt(matcher.group(1));
			this.minuty = Integer.parseInt(matcher.group(2));
		}
	}

	public String toString() {
		return String.format("%d h %d min", this.godz, this.minuty);
	}

	public Czas dodaj(Czas t) {
		int czas = (this.godz * MIN_IN_HOUR + this.minuty) + (t.godz * MIN_IN_HOUR + t.minuty);
		return new Czas(czas / MIN_IN_HOUR, czas % MIN_IN_HOUR); //(czas / 60) % 24
	}
	public Czas odejmij(Czas t) {
		return this.dodaj(new Czas(-t.godz, -t.minuty));
	}

	public Czas pomnoz(int ile)  {
		int czas = (this.godz * MIN_IN_HOUR + this.minuty) * ile;
		return new Czas(czas / MIN_IN_HOUR, czas % MIN_IN_HOUR);
	}

	public static Czas sumuj(Czas[] tab, int n) {
		Czas suma = tab[ 0 ];
		for (int i = 1; i < n; i++) {
			suma = suma.dodaj(tab[ i ]);
		}
		return suma;
	}
}
