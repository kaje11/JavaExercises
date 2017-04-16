package polishLearningJavaSix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Zajêcia 6 – pliki tekstowe.
 * @author kaje11
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisaæ funkcjê liczZnakiSlowa, która zlicza:
	 * • liczbê znaków w pliku,
	 * • liczbê bia³ych znaków w pliku (bia³e znaki to spacja, tabulator, znacznik
	 * koñca wiersza),
	 * • liczbê s³ów w pliku.
	 * Wynikiem funkcji jest tablica z³o¿ona z 3 liczb ca³kowitych po jednej dla wymienionych
	 * podpunktów.
	 * @param plik - œcie¿ka do pliku
	 * @return tablica z informacjami.
	 */
	static int[] liczZnakiSlowa(final String plik) {
		int[] result = {0, 0, 0};
		try (BufferedReader buffer = new BufferedReader(new FileReader(plik))) {
			String line;

			while ((line = buffer.readLine()) != null) {
				result[ 0 ] += line.length();
				result[ 1 ] += line.length() - line.replaceAll("\\s", "").length();
				result[ 2 ] += line.length() > 0 ? line.trim().split(" ").length : 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * TASK TWO.
	 * Napisaæ funkcjê:
	 * public static void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo)
	 * której zadaniem jest znalezienie wszystkich wierszy w pliku, które zawieraj¹ szukane
	 * s³owo. Wszystkie wiersze, które zawieraj¹ s³owo powinny zostaæ zapisane w
	 * pliku wynikowym wraz z nr wiersza (z pierwszego pliku). Nazwa pierwszego pliku
	 * zapamiêtana jest w parametrze nazwaPlikWe, nazwa pliku wynikowego podana
	 * jest w parametrze nazwaPlikWy, natomiast szukane s³owo w parametrze slowo.
	 * @param nazwaPlikWe - œcie¿ka do pliku wejœciowego
	 * @param nazwaPlikWy - œcie¿ka do pliku wyjœciowego
	 * @param slowo - szukane s³owo
	 */
	public static void szukaj(final String nazwaPlikWe,
			final String nazwaPlikWy, final String slowo) {
		try (BufferedReader buffer = new BufferedReader(new FileReader(nazwaPlikWe))) {
			int lineCount = 1;

			try (PrintWriter plikWy = new PrintWriter(nazwaPlikWy)) {
				String line;
				while ((line = buffer.readLine()) != null) {
					if (line.contains(slowo)) {
						plikWy.println(lineCount + ":" + line);
					}
					lineCount++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TASK THREE.
	 * Napisaæ funkcjê public static void sumujIZapisz(String nazwaPliku) , któ-
	 * ra odczytuje plik o podanej nazwie zawieraj¹cy liczby ca³kowite (po jednej w
	 * wierszu). Funkcja ma za zadanie odczytaæ i zsumowaæ wszystkie liczby z pliku,
	 * a nastêpnie dopisaæ na koñcu pliku wyznaczon¹ sumê powiêkszon¹ o 1. Ponowne
	 * uruchomienia funkcji bêd¹ skutkowa³y dopisywaniem kolejnych wierszy. Je¿eli
	 * plik nie istnieje to ma zostaæ utworzony – suma dla pustego pliku wyniesie 0, a
	 * wiêc nale¿y dopisaæ wiersz zawieraj¹cy 1
	 * @param nazwaPliku - œcie¿ka do pliku wejœciowego
	 */
	public static void sumujIZapisz(final String nazwaPliku) {
		int sum = 1;
		boolean fileExists = new File(nazwaPliku).exists();
		try (FileWriter fw = new FileWriter(nazwaPliku, fileExists)) {
			if (fileExists) {
				try (BufferedReader buffer = new BufferedReader(new FileReader(nazwaPliku))) {
					String line;

					while ((line = buffer.readLine()) != null) {
						sum += Integer.parseInt(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		    fw.write(sum + "\n");
		    fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * TASK FOUR.
	 * Stworzyæ dwie funkcje:
	 * void szyfruj(String nazwaWe, int przesun)
	 * void deszyfruj(String nazwaWe, int przesun)
	 * Funkcja szyfruj dokonuje szyfrowania pliku, którego nazwa podana zosta³a jako
	 * pierwszy parametr. Szyfrowanie polega na zamianie ka¿dej litery na znak przesuniêty
	 * o wartoœæ podan¹ drugim parametrem np. dla przesuniêcia równego 2 literka
	 * ’a’ powinna zostaæ zast¹piona literk¹ ’c’, literka ’z’ literk¹ ’b’ itp.
	 * Wynikiem dzia³ania funkcji ma byæ plik o nazwie utworzonej na podstawie nazwy
	 * pliku wejœciowego poprzez do³¹czenie znaku ’ ’ np. dla pliku dane.txt zaszyfrowana
	 * postaæ powinna mieæ nazwê dane.txt. Funkcja deszyfruj powinna deszyfrowaæ plik
	 * (niekoniecznie ten sam) zaszyfrowany przez funkcjê szyfruj
	 * @param nazwaWe - œcie¿ka do pliku wejœciowego
	 * @param przesun - przesuniêcie
	 */
	static void szyfruj(final String nazwaWe, int przesun) {
		if (przesun > 26 || przesun < 0) {
			przesun %= 26;
		}

        try (FileReader plikWe = new FileReader(nazwaWe);
        	FileWriter plikWy = new FileWriter("_" + nazwaWe);) {
            int c;
            while ((c = plikWe.read()) != -1) {
            	//przypuszczam, ¿e chodzi³o o alfabet ³aciñski
            	if (c > 'A' && c <= 'Z') {
            		plikWy.write((c + przesun) % 26 + 'A');
            	} else if (c > 'a' && c <= 'z') {
            		plikWy.write((c + przesun) % 26 + 'a');
            	} else {
            		plikWy.write(c);
            	}
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	static void deszyfruj(final String nazwaWe, final int przesun) {
		szyfruj(nazwaWe, 26 - przesun);
	}

	/**
	 * TASK FIVE.
	 * Napisaæ funkcjê emerytura(String nazwaPliku), która wczyta z pliku o podanej
	 * nazwie dane pracowników zapisane w kolejnych wierszach w nastêpuj¹cy sposób:
	 * Imiê Nazwisko P³eæ Wiek
	 * Przyk³ad:
	 * Tomasz Nowak M 45
	 * Marta Ziobro K 42
	 * Jan Kowalski M 27
	 * Ewelina Tusk K 59
	 * Nastêpnie funkcja dla ka¿dego pracownika powinna wyznaczyæ ile lat pozosta³o
	 * do jego emerytury. Wyniki nale¿y zapisaæ w nastêpuj¹cy sposób:
	 * Nazwisko Imiê ”Lata do emerytury”
	 * Przyk³ad:
	 * Nowak Tomasz 20
	 * Kowalski Jan 38
	 * Wyniki dla kobiet nale¿y zapisaæ w pliku o nazwie ”kobiety.txt”, natomiast wyniki
	 * dla mê¿czyzn nale¿y zapisaæ w pliku ”mezczyzni.txt”.
	 * @param nazwaPliku - œcie¿ka do pliku wejœciowego
	 */
	static void emerytura(final String nazwaPliku) {
		try (BufferedReader buffer = new BufferedReader(new FileReader(nazwaPliku));
			PrintWriter male = new PrintWriter("mezczyzni.txt");
			PrintWriter female = new PrintWriter("kobiety.txt");) {

			String line;
			String[] data = null;
			String person = "";
			while ((line = buffer.readLine()) != null) {
				data = line.split(" ");
				person = data[ 1 ] + " " + data[ 0 ] + " ";

				if (data[ 2 ].equals("K")) {
					female.println(person + (62 - Integer.parseInt(data[ 3 ])));
				} else {
					male.println(person + (65 - Integer.parseInt(data[ 3 ])));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TASK SIX.
	 * Napisaæ funkcjê, której zadaniem jest odczytanie danych tabelarycznych z pliku
	 * tekstowego, a nastêpnie zapisanie ich do nowego pliku w postaci kodu HTML.
	 * Przyk³ad:
	 * Wejœcie:
	 * "Waga" "Wzrost" "BMI" "Nadwaga"
	 * 70 1,8 21,6 "NIE"
	 * 67 1,77 21,39 "NIE"
	 * 85 1,7 29,41 "TAK"
	 * 100 1,92 27,13 "TAK"
	 * Wynik:
	 * <html><body>
	 * <table>
	 * <tr><td>"Waga"</td><td>"Wzrost"</td><td>"BMI"</td><td>"Nadwaga"
	 * </td></tr>
	 * <tr><td>70</td><td>1,8</td><td>21,6</td><td>"NIE"
	 * </td></tr>
	 * <tr><td>67</td><td>1,77</td><td>21,39</td><td>"NIE"
	 * </td></tr>
	 * <tr><td>85</td><td>1,7</td><td>29,41</td><td>"TAK"
	 * </td></tr>
	 * <tr><td>100</td><td>1,92</td><td>27,13</td><td>"TAK"</td></tr>
	 * </table>
	 * </body></html>
	 * @param filename - nazwa pliku wejœciowego
	 */
	static void generateHTMLTable(final String filename) {
		try (BufferedReader buffer = new BufferedReader(new FileReader(filename));
			PrintWriter html = new PrintWriter(filename + ".html");) {

			html.println("<html><body>");
			html.println("<table>");

			String regex = "[^\\s\"']+|\"([^\"]*)\"|'([^']*)'";
			Pattern pattern = Pattern.compile(regex);

			String line;
			while ((line = buffer.readLine()) != null) {
				html.print("<tr>");
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
				    String cell = matcher.group(1) == null ? matcher.group(0) : matcher.group(1);
					html.print("<td>" + cell + "</td>");
				}
				html.println("</tr>");
			}
			html.println("</table>");
			html.println("</body></html>");
			html.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TASK SEVEN.
	 * Napisaæ program, który dla pliku tekstowego o podanej nazwie wyznaczy „wykres”
	 * czêstoœci wyst¹pieñ ma³ych liter alfabetu angielskiego. S³upki wykresu maj¹
	 * zostaæ utworzone ze znaków gwiazdki ’*’, przy czym d³ugoœæ s³upka dla najczêœciej
	 * wystêpuj¹cej litery powinna wynosiæ 50. Dodatkowo dla ka¿dego znaku nale¿y dodatkowo
	 * wyœwietliæ liczbê jego wyst¹pieñ.
	 * @param filename - nazwa pliku wejœciowego
	 */
	static void letterFrequency(String filename) {
        try (FileReader fileIn = new FileReader(filename);
        	PrintWriter fileOut = new PrintWriter("freq_" + filename);) {
    		int[] freq = new int[26];
            int c;

            while ((c = fileIn.read()) != -1) {
            	if (c >= 'a' && c <= 'z') {
            		freq[ c - 'a' ]++;
            	}
            }
            fileIn.close();

            int maxVal = freq[ 0 ];
            for (int i = 1; i < 26; i++) {
            	if (freq[ i ] > maxVal) {
            		maxVal = freq[ i ];
            	}
            }
            String stars, spaces;
            int starsCount, spacesCount;
            for (int i = 0; i < 26; i++) {
            	starsCount = Math.round((freq[ i ] * 100 / maxVal) / 2);
            	spacesCount = 50 - starsCount;
            	stars = new String(new char[starsCount]).replace("\0", "*");
            	spaces = spacesCount > 0 ? new String(new char[50 - starsCount]).replace("\0", " ") : "";

            	fileOut.println((char) ('a' + i) + " " + stars + spaces + " " + freq[ i ]);
            }
            fileOut.close();

    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}
}
