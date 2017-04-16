package polishLearningJavaFive;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Zajêcia 5 – ³añcuchy znaków (ci¹g dalszy) i funkcje.
 * @author kaje11
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisz funkcjê, która zwraca wartoœæ silni dla podanej liczby n. Funkcja powinna
	 * byæ napisana w dwóch wersjach: iteracyjnej i rekurencyjnej.
	 * @param n - liczba n
	 * @return fact - wartoœæ silni
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
	 * Napisz funkcjê, która zwraca wartoœæ n-tego wyrazu ci¹gu Fibonacciego. Funkcja
	 * powinna byæ napisana w dwóch wersjach: iteracyjnej i rekurencyjnej.
	 * @param n - n-ty wyraz
	 * @return wartoœæ n-tego wyrazu
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
	 * Zdefiniowaæ funkcjê int strpos(String text, char z) , która zwraca indeks
	 * na którym znajduje siê znak z (drugi parametr) w podanym ³añcuchu text .
	 * Je¿eli znak z nie wystêpuje w ³añcuchu, to wynikiem funkcji powinno byæ -1.
	 * Uwaga - pozycje znaków numerujemy pocz¹wszy od 0.
	 * @param text - ³añcuch
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
	 * Napisaæ funkcjê String flipCase(String text) , która zamieni ma³e litery na
	 * du¿e i odwrotnie w ³añcuchu podanym jako parametr. Wynikiem ma byæ ³añcuch
	 * znaków zawieraj¹cy kopiê ³añcucha po zmianie wielkoœci liter
	 * @param text - ³añcuch
	 * @return - odwrócony ³añcuch (w. znaków)
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
	 * Zdefiniowaæ funkcjê boolean startsWith(String str1, String str2) , która
	 * sprawdza, czy ³añcuch str2 jest prefiksem ³añcucha str1 .
	 * @param str1 - pierwszy ³añcuch
	 * @param str2 - drugi ³añcuch
	 * @return Czy jest prefiksem
	 */
	static boolean startsWith(String str1, String str2) {
		return str1.startsWith(str2);
	}

	/**
	 * TASK SIX.
	 * Zdefiniowaæ funkcjê int strToInt(String str) , która zamienia liczbê ca³kowit¹
	 * zapisan¹ w postaci ³añcucha na liczbê ca³kowit¹ typu int. Funkcja powinna
	 * przerywaæ konwersjê w momencie napotkania pierwszego znaku nie nale¿¹cego do
	 * zapisu liczby, zatem np. dla strToInt("-13krowa") wynikiem powinno byæ -13.
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
	 * Zdefiniowaæ funkcjê int strfind(String gdzie, String co) , która szuka ³añ-
	 * cucha co w ³añcuchu gdzie i je¿eli go znajdzie, to jej wynikiem jest pozycja,
	 * na której ten ³añcuch zaczyna siê w ³añcuchu gdzie . Je¿eli nie uda³o siê znaleŸæ
	 * ³añcucha to wtedy wynikiem ma byæ -1.
	 * @param gdzie - haystack
	 * @param co - needle
	 * @return pozycja
	 */
	static int strfind(final String gdzie, final String co) {
		return gdzie.indexOf(co);
	}

	/**
	 * TASK EIGHT.
	 * Napisaæ funkcjê int wordCount(String text) , której wynikiem jest liczba wszystkich
	 * s³ów wystêpuj¹cych w podanym jako parametr tekœcie. Do sprawdzania, czy
	 * dany znak tekstu jest „bia³ym znakiem” mo¿na zastosowaæ metodê
	 * Character.isWhitespace . Za s³owo przyjmujemy ka¿dy ci¹g znaków niezawieraj¹cy
	 * bia³ego znaku.
	 * @param text - ³añcuch znaków
	 * @return liczba s³ów
	 */
	static int wordCount(final String text) {
		return text.trim().split("\\s+").length;
	}

	/**
	 * TASK NINE.
	 * Napisaæ funkcjê String[] podzielNaSlowa(String tekst) , która dzieli podany
	 * tekst na s³owa i zapisuje je w tablicy. Wynikiem funkcji jest tablica zawieraj¹ce
	 * kolejno s³owa z tekstu. Za s³owo przyjmujemy ka¿dy ci¹g znaków niezawieraj¹cy
	 * bia³ego znaku.
	 * @param tekst - ci¹g znaków
	 * @return tablica ze s³owami
	 */
	static String[] podzielNaSlowa(final String tekst) {
		return tekst.trim().split("\\s+");
	}

	/**
	 * TASK TEN.
	 * Zdefiniowaæ funkcjê int strFindAndCount(String gdzie, String co) , która
	 * zlicza wyst¹pienia ³añcucha co w ³añcuchu gdzie . Jej wynikiem jest wyznaczona
	 * liczba wyst¹pieñ. Je¿eli nie uda³o siê znaleŸæ ³añcucha, to wtedy wynikiem
	 * jest, oczywiœcie, 0.
	 * @param gdzie - haystack
	 * @param co - needle
	 * @return liczba wyst¹pieñ
	 */
	static int strFindAndCount(final String gdzie, final String co) {
		return gdzie.split(co, -1).length - 1;
	}

	/**
	 * TASK ELEVEN.
	 * Zdefiniowaæ procedurê String strcut(String str, int start, int ile) , któ-
	 * ra wycina z podanego ³añcucha wszystko co znajduje siê w podanym zakresie. Wynikiem
	 * funkcji powinien byæ ³añcuch bez znaków znajduj¹cych siê na pozycjach
	 * od start do start+ile-1.
	 * @param str - ci¹g znaków
	 * @param start - od której pozycji
	 * @param ile - ile znaków
	 * @return wyciêty ci¹g znaków
	 */
	static String strcut(final String str, final int start, final int ile) {
		return (start != 0 ? str.substring(0, start) : "") + str.substring(start + ile);
	}

	/**
	 * TASK TWELVE.
	 * Napisaæ program, który wykorzystuj¹c czêœæ z zaimplementowanych wczeœniej
	 * funkcji wyznacza:
	 * • Sumê wszystkich liczb znajduj¹cych siê w tablicy (jako liczbê traktuje siê
	 * ³añcuch, którego pocz¹tkiem jest liczba - format jak w funkcji strToInt().
	 * • £añcuch bêd¹cy po³¹czeniem wszystkich komórek tablicy, których wartoœæ
	 * ³añcucha nie jest liczb¹ (definicja liczby analogiczna do pkt. 1).
	 * • Liczbê wyst¹pieñ okreœlonej frazy we wszystkich komórkach „nieliczbowych”
	 * tablicy.
	 * • Liczbê wyst¹pieñ okreœlonej frazy w ³añcuchu, o którym mowa w pkt. 2.
	 * • Stosunek wyst¹pieñ frazy w komórkach tablicy (pkt. 3) do liczby wyst¹pieñ
	 * w powsta³ym ³añcuchu (pkt. 4).
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
	 * Napisaæ funkcjê String poprzestawiaj(String tekst, int [] kolejnosc) ,
	 * której wynikiem jest ³añcuch z³o¿ony ze znaków w zmiennej tekst u³o¿onych wg
	 * kolejnoœci podanej w tablicy kolejnosc , tzn. i-ty znak tekstu powinien znaleŸæ
	 * siê w wynikowym ³añcuchu na pozycji kolejnosc[i].
	 * @param tekst - ci¹g znaków
	 * @param kolejnosc - tablica z kolejnoœci¹.
	 * @return ³añcuch z now¹ kolejnoœci¹
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
	 * Napisaæ funkcjê boolean czyAnagram(String t1, String t2) , która sprawdza,
	 * czy ³añcuch t2 jest anagramem tekstu t1 , czyli czy sk³ada siê z tych
	 * samych znaków, ale ustawionych niekoniecznie w tej samej kolejnoœci
	 * Uwaga, nale¿y sprawdzaæ jedynie ma³e i du¿e litery alfabetu angielskiego, jednak
	 * bez wzglêdu na ich wielkoœæ, tzn. zarówno ma³e ’a’ jak i du¿e ’A’ liczone s¹ tak
	 * samo. Pozosta³e znaki nie s¹ sprawdzane, a wiêc nie maj¹ wp³ywu na to, czy
	 * s³owo bêdzie uznane za anagram innego.
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
	 * W jêzyku HTML oraz kaskadowych arkuszach stylów (CSS) powszechne jest ustalanie
	 * kolorów elementów w postaci ³añcucha #RRGGBB, gdzie RR jest dwucyfrow¹
	 * liczb¹ (od 0x0 do 0xFF) w kodzie szesnastkowym oznaczaj¹c¹ ile czerwieni jest
	 * w wynikowym kolorze. Analogicznie GG oznacza nasycenie zieleni, a BB niebieskiego.
	 * Napisaæ funkcjê int [] HTMLColor2RGB(String color) , która jako parametr
	 * przyjmuje ³añcuch postaci ”#RRGGBB” i zwraca tablicê 3 liczb ca³kowitych w
	 * systemie 10 oznaczaj¹cych nasycenie poszczególnych sk³adowych.
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
