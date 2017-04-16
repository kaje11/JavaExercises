package polishLearningJavaFive;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Zaj�cia 5 � �a�cuchy znak�w (ci�g dalszy) i funkcje.
 * @author kaje11
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisz funkcj�, kt�ra zwraca warto�� silni dla podanej liczby n. Funkcja powinna
	 * by� napisana w dw�ch wersjach: iteracyjnej i rekurencyjnej.
	 * @param n - liczba n
	 * @return fact - warto�� silni
	 */
	static int factorialI(final int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	// Wersja rekurencyjna
	static int factorialR(final int n) {
		if (n == 1) {
			return 1;
		}
		return n * (factorialR(n - 1));
	}
	/**
	 * TASK TWO.
	 * Napisz funkcj�, kt�ra zwraca warto�� n-tego wyrazu ci�gu Fibonacciego. Funkcja
	 * powinna by� napisana w dw�ch wersjach: iteracyjnej i rekurencyjnej.
	 * @param n - n-ty wyraz
	 * @return warto�� n-tego wyrazu
	 */
	static int fibonacciI(final int n) {
		int x = 0, y = 1, z = 1;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = x + y;
		}
		return x;
	}
	// Wersja rekurencyjna
	static int fibonacciR(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacciR(n - 1) + fibonacciR(n - 2);
	}

	/**
	 * TASK THREE.
	 * Zdefiniowa� funkcj� int strpos(String text, char z) , kt�ra zwraca indeks
	 * na kt�rym znajduje si� znak z (drugi parametr) w podanym �a�cuchu text .
	 * Je�eli znak z nie wyst�puje w �a�cuchu, to wynikiem funkcji powinno by� -1.
	 * Uwaga - pozycje znak�w numerujemy pocz�wszy od 0.
	 * @param text - �a�cuch
	 * @param z - znak
	 * @return pozycja znaku
	 */
	static int strpos(final String text, final char z) {
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == z) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * TASK FOUR.
	 * Napisa� funkcj� String flipCase(String text) , kt�ra zamieni ma�e litery na
	 * du�e i odwrotnie w �a�cuchu podanym jako parametr. Wynikiem ma by� �a�cuch
	 * znak�w zawieraj�cy kopi� �a�cucha po zmianie wielko�ci liter
	 * @param text - �a�cuch
	 * @return - odwr�cony �a�cuch (w. znak�w)
	 */
	static String flipCase(final String text) {
		String flip = "";
		for (int i = 0; i < text.length(); i++) {
			if (Character.isUpperCase(text.charAt(i))) {
				flip += Character.toLowerCase(text.charAt(i));
			} else if (Character.isLowerCase(text.charAt(i))) {
				flip += Character.toUpperCase(text.charAt(i));
			}
		}
		return flip;
	}

	/**
	 * TASK FIVE.
	 * Zdefiniowa� funkcj� boolean startsWith(String str1, String str2) , kt�ra
	 * sprawdza, czy �a�cuch str2 jest prefiksem �a�cucha str1 .
	 * @param str1 - pierwszy �a�cuch
	 * @param str2 - drugi �a�cuch
	 * @return Czy jest prefiksem
	 */
	static boolean startsWith(String str1, String str2) {
		return str1.startsWith(str2);
	}

	/**
	 * TASK SIX.
	 * Zdefiniowa� funkcj� int strToInt(String str) , kt�ra zamienia liczb� ca�kowit�
	 * zapisan� w postaci �a�cucha na liczb� ca�kowit� typu int. Funkcja powinna
	 * przerywa� konwersj� w momencie napotkania pierwszego znaku nie nale��cego do
	 * zapisu liczby, zatem np. dla strToInt("-13krowa") wynikiem powinno by� -13.
	 */
	//SHORT VERSION
	static int strToIntShort(final String str) {
		Matcher matcher =  Pattern.compile("^((^|[\\+\\-])[0-9]([0-9]+|()))(([e])([0-9]+)|())").matcher(str);
		return matcher.find() ? Integer.parseInt(matcher.group(1) + (matcher.group(7) != null ? new String(new char[Integer.parseInt(matcher.group(7))]).replace('\0', '0') : "")) : 0;
	}
	//LONGER VERSION
	static int strToIntLong(final String str) {
		if (str.length() == 0 || !str.matches("^[\\+\\-][0-9].*|^[0-9].*")) {
			return 0;
		}

		char cur = '\0';
		int i = 0;
		String power = "", num = "" + str.charAt(0);

		while (++i < str.length() && Character.isDigit(cur = str.charAt(i)) || (power == "" && cur == 'e')) {
			if (power == "") {
				if (cur == 'e') {
					power += '+';
				} else {
					num += cur;
				}
			} else {
				power += cur;
			}
		}

		if (power.length() > 1) {
			num += new String(new char[Integer.parseInt(power)]).replace('\0', '0');
		}
		return Integer.parseInt(num);
	}

	/**
	 * TASK SEVEN.
	 * Zdefiniowa� funkcj� int strfind(String gdzie, String co) , kt�ra szuka �a�-
	 * cucha co w �a�cuchu gdzie i je�eli go znajdzie, to jej wynikiem jest pozycja,
	 * na kt�rej ten �a�cuch zaczyna si� w �a�cuchu gdzie . Je�eli nie uda�o si� znale��
	 * �a�cucha to wtedy wynikiem ma by� -1.
	 * @param gdzie - haystack
	 * @param co - needle
	 * @return pozycja
	 */
	static int strfind(final String gdzie, final String co) {
		return gdzie.indexOf(co);
	}

	/**
	 * TASK EIGHT.
	 * Napisa� funkcj� int wordCount(String text) , kt�rej wynikiem jest liczba wszystkich
	 * s��w wyst�puj�cych w podanym jako parametr tek�cie. Do sprawdzania, czy
	 * dany znak tekstu jest �bia�ym znakiem� mo�na zastosowa� metod�
	 * Character.isWhitespace . Za s�owo przyjmujemy ka�dy ci�g znak�w niezawieraj�cy
	 * bia�ego znaku.
	 * @param text - �a�cuch znak�w
	 * @return liczba s��w
	 */
	static int wordCount(final String text) {
		return text.trim().split("\\s+").length;
	}

	/**
	 * TASK NINE.
	 * Napisa� funkcj� String[] podzielNaSlowa(String tekst) , kt�ra dzieli podany
	 * tekst na s�owa i zapisuje je w tablicy. Wynikiem funkcji jest tablica zawieraj�ce
	 * kolejno s�owa z tekstu. Za s�owo przyjmujemy ka�dy ci�g znak�w niezawieraj�cy
	 * bia�ego znaku.
	 * @param tekst - ci�g znak�w
	 * @return tablica ze s�owami
	 */
	static String[] podzielNaSlowa(final String tekst) {
		return tekst.trim().split("\\s+");
	}

	/**
	 * TASK TEN.
	 * Zdefiniowa� funkcj� int strFindAndCount(String gdzie, String co) , kt�ra
	 * zlicza wyst�pienia �a�cucha co w �a�cuchu gdzie . Jej wynikiem jest wyznaczona
	 * liczba wyst�pie�. Je�eli nie uda�o si� znale�� �a�cucha, to wtedy wynikiem
	 * jest, oczywi�cie, 0.
	 * @param gdzie - haystack
	 * @param co - needle
	 * @return liczba wyst�pie�
	 */
	static int strFindAndCount(final String gdzie, final String co) {
		return gdzie.split(co, -1).length - 1;
	}

	/**
	 * TASK ELEVEN.
	 * Zdefiniowa� procedur� String strcut(String str, int start, int ile) , kt�-
	 * ra wycina z podanego �a�cucha wszystko co znajduje si� w podanym zakresie. Wynikiem
	 * funkcji powinien by� �a�cuch bez znak�w znajduj�cych si� na pozycjach
	 * od start do start+ile-1.
	 * @param str - ci�g znak�w
	 * @param start - od kt�rej pozycji
	 * @param ile - ile znak�w
	 * @return wyci�ty ci�g znak�w
	 */
	static String strcut(final String str, final int start, final int ile) {
		return (start != 0 ? str.substring(0, start) : "") + str.substring(start + ile);
	}

	/**
	 * TASK TWELVE.
	 * Napisa� program, kt�ry wykorzystuj�c cz�� z zaimplementowanych wcze�niej
	 * funkcji wyznacza:
	 * � Sum� wszystkich liczb znajduj�cych si� w tablicy (jako liczb� traktuje si�
	 * �a�cuch, kt�rego pocz�tkiem jest liczba - format jak w funkcji strToInt().
	 * � �a�cuch b�d�cy po��czeniem wszystkich kom�rek tablicy, kt�rych warto��
	 * �a�cucha nie jest liczb� (definicja liczby analogiczna do pkt. 1).
	 * � Liczb� wyst�pie� okre�lonej frazy we wszystkich kom�rkach �nieliczbowych�
	 * tablicy.
	 * � Liczb� wyst�pie� okre�lonej frazy w �a�cuchu, o kt�rym mowa w pkt. 2.
	 * � Stosunek wyst�pie� frazy w kom�rkach tablicy (pkt. 3) do liczby wyst�pie�
	 * w powsta�ym �a�cuchu (pkt. 4).
	 * zadania[N][M]={"mamla", " mama ", "+12", "0001", "991-234-3",
	 * "-12e5", "-12e-5", "+zonmakm", "ax2", "amakotma"};
	 * // gdzie N=M=10;
	 * f[N]="ma";
	 */
	static void solveTwelfth() {
		String[] zadania = {"mamla", " mama ", "+12", "0001", "991-234-3",
				"-12e5", "-12e-5", "+zonmakm", "ax2", "amakotma"};
		String f = "ma";

		int sum = 0, numInStr = 0, occurences = 0, occWithoutNum;
		String withoutNum = "";

		for (int i = 0; i < zadania.length; i++) {
			numInStr = strToIntShort(zadania[ i ]);
			if (numInStr == 0) {
				occurences += strFindAndCount(zadania[ i ], f);
				withoutNum += zadania[ i ];
			} else {
				sum += numInStr;
			}
		}
		occWithoutNum = strFindAndCount(withoutNum, f);
		System.out.println("Pkt. 1: " + sum);
		System.out.println("Pkt. 2: " + withoutNum);
		System.out.println("Pkt. 3: " + occurences);
		System.out.println("Pkt. 4: " + occWithoutNum);
		System.out.println("Pkt. 5: " + (float) occurences / (float) occWithoutNum);
	}

	/**
	 * TASK THIRTEEN.
	 * Napisa� funkcj� String poprzestawiaj(String tekst, int [] kolejnosc) ,
	 * kt�rej wynikiem jest �a�cuch z�o�ony ze znak�w w zmiennej tekst u�o�onych wg
	 * kolejno�ci podanej w tablicy kolejnosc , tzn. i-ty znak tekstu powinien znale��
	 * si� w wynikowym �a�cuchu na pozycji kolejnosc[i].
	 * @param tekst - ci�g znak�w
	 * @param kolejnosc - tablica z kolejno�ci�.
	 * @return �a�cuch z now� kolejno�ci�
	 */
	static String poprzestawiaj(final String tekst, final int[] kolejnosc) {
		String newStr = "";
		for (int kol: kolejnosc) {
			newStr += tekst.charAt(kol);
		}
		return newStr;
	}

	/**
	 * TASK FOURTEEN.
	 * Napisa� funkcj� boolean czyAnagram(String t1, String t2) , kt�ra sprawdza,
	 * czy �a�cuch t2 jest anagramem tekstu t1 , czyli czy sk�ada si� z tych
	 * samych znak�w, ale ustawionych niekoniecznie w tej samej kolejno�ci
	 * Uwaga, nale�y sprawdza� jedynie ma�e i du�e litery alfabetu angielskiego, jednak
	 * bez wzgl�du na ich wielko��, tzn. zar�wno ma�e �a� jak i du�e �A� liczone s� tak
	 * samo. Pozosta�e znaki nie s� sprawdzane, a wi�c nie maj� wp�ywu na to, czy
	 * s�owo b�dzie uznane za anagram innego.
	 * @param t1
	 * @param t2
	 * @return Czy anagram
	 */
	static boolean czyAnagram(final String t1, final String t2) {
		char[] cleanT1 = t1.toLowerCase().replaceAll("[^a-z]+", "").toCharArray();
		char[] cleanT2 = t2.toLowerCase().replaceAll("[^a-z]+", "").toCharArray();
		Arrays.sort(cleanT1);
		Arrays.sort(cleanT2);
		return Arrays.equals(cleanT1, cleanT2);
	}

	/**
	 * TASK FIFTEEN.
	 * W j�zyku HTML oraz kaskadowych arkuszach styl�w (CSS) powszechne jest ustalanie
	 * kolor�w element�w w postaci �a�cucha #RRGGBB, gdzie RR jest dwucyfrow�
	 * liczb� (od 0x0 do 0xFF) w kodzie szesnastkowym oznaczaj�c� ile czerwieni jest
	 * w wynikowym kolorze. Analogicznie GG oznacza nasycenie zieleni, a BB niebieskiego.
	 * Napisa� funkcj� int [] HTMLColor2RGB(String color) , kt�ra jako parametr
	 * przyjmuje �a�cuch postaci �#RRGGBB� i zwraca tablic� 3 liczb ca�kowitych w
	 * systemie 10 oznaczaj�cych nasycenie poszczeg�lnych sk�adowych.
	 * @param color - kolor
	 * @return RGB array
	 */
	static int[] HTMLColor2RGB(final String color) {
		int[] res = new int[ 3 ];
		res[ 0 ] = Integer.valueOf(color.substring(1, 3), 16);
		res[ 1 ] = Integer.valueOf(color.substring(3, 5), 16);
		res[ 2 ] = Integer.valueOf(color.substring(5, 7), 16);
		return res;
	}
}
