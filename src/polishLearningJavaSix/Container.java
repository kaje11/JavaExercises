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
 * Zaj�cia 6 � pliki tekstowe.
 * @author kaje11
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisa� funkcj� liczZnakiSlowa, kt�ra zlicza:
	 * � liczb� znak�w w pliku,
	 * � liczb� bia�ych znak�w w pliku (bia�e znaki to spacja, tabulator, znacznik
	 * ko�ca wiersza),
	 * � liczb� s��w w pliku.
	 * Wynikiem funkcji jest tablica z�o�ona z 3 liczb ca�kowitych po jednej dla wymienionych
	 * podpunkt�w.
	 * @param plik - �cie�ka do pliku
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
	 * Napisa� funkcj�:
	 * public static void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo)
	 * kt�rej zadaniem jest znalezienie wszystkich wierszy w pliku, kt�re zawieraj� szukane
	 * s�owo. Wszystkie wiersze, kt�re zawieraj� s�owo powinny zosta� zapisane w
	 * pliku wynikowym wraz z nr wiersza (z pierwszego pliku). Nazwa pierwszego pliku
	 * zapami�tana jest w parametrze nazwaPlikWe, nazwa pliku wynikowego podana
	 * jest w parametrze nazwaPlikWy, natomiast szukane s�owo w parametrze slowo.
	 * @param nazwaPlikWe - �cie�ka do pliku wej�ciowego
	 * @param nazwaPlikWy - �cie�ka do pliku wyj�ciowego
	 * @param slowo - szukane s�owo
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
	 * Napisa� funkcj� public static void sumujIZapisz(String nazwaPliku) , kt�-
	 * ra odczytuje plik o podanej nazwie zawieraj�cy liczby ca�kowite (po jednej w
	 * wierszu). Funkcja ma za zadanie odczyta� i zsumowa� wszystkie liczby z pliku,
	 * a nast�pnie dopisa� na ko�cu pliku wyznaczon� sum� powi�kszon� o 1. Ponowne
	 * uruchomienia funkcji b�d� skutkowa�y dopisywaniem kolejnych wierszy. Je�eli
	 * plik nie istnieje to ma zosta� utworzony � suma dla pustego pliku wyniesie 0, a
	 * wi�c nale�y dopisa� wiersz zawieraj�cy 1
	 * @param nazwaPliku - �cie�ka do pliku wej�ciowego
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
	 * Stworzy� dwie funkcje:
	 * void szyfruj(String nazwaWe, int przesun)
	 * void deszyfruj(String nazwaWe, int przesun)
	 * Funkcja szyfruj dokonuje szyfrowania pliku, kt�rego nazwa podana zosta�a jako
	 * pierwszy parametr. Szyfrowanie polega na zamianie ka�dej litery na znak przesuni�ty
	 * o warto�� podan� drugim parametrem np. dla przesuni�cia r�wnego 2 literka
	 * �a� powinna zosta� zast�piona literk� �c�, literka �z� literk� �b� itp.
	 * Wynikiem dzia�ania funkcji ma by� plik o nazwie utworzonej na podstawie nazwy
	 * pliku wej�ciowego poprzez do��czenie znaku � � np. dla pliku dane.txt zaszyfrowana
	 * posta� powinna mie� nazw� dane.txt. Funkcja deszyfruj powinna deszyfrowa� plik
	 * (niekoniecznie ten sam) zaszyfrowany przez funkcj� szyfruj
	 * @param nazwaWe - �cie�ka do pliku wej�ciowego
	 * @param przesun - przesuni�cie
	 */
	static void szyfruj(final String nazwaWe, int przesun) {
		if (przesun > 26 || przesun < 0) {
			przesun %= 26;
		}

        try (FileReader plikWe = new FileReader(nazwaWe);
        	FileWriter plikWy = new FileWriter("_" + nazwaWe);) {
            int c;
            while ((c = plikWe.read()) != -1) {
            	//przypuszczam, �e chodzi�o o alfabet �aci�ski
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
	 * Napisa� funkcj� emerytura(String nazwaPliku), kt�ra wczyta z pliku o podanej
	 * nazwie dane pracownik�w zapisane w kolejnych wierszach w nast�puj�cy spos�b:
	 * Imi� Nazwisko P�e� Wiek
	 * Przyk�ad:
	 * Tomasz Nowak M 45
	 * Marta Ziobro K 42
	 * Jan Kowalski M 27
	 * Ewelina Tusk K 59
	 * Nast�pnie funkcja dla ka�dego pracownika powinna wyznaczy� ile lat pozosta�o
	 * do jego emerytury. Wyniki nale�y zapisa� w nast�puj�cy spos�b:
	 * Nazwisko Imi� �Lata do emerytury�
	 * Przyk�ad:
	 * Nowak Tomasz 20
	 * Kowalski Jan 38
	 * Wyniki dla kobiet nale�y zapisa� w pliku o nazwie �kobiety.txt�, natomiast wyniki
	 * dla m�czyzn nale�y zapisa� w pliku �mezczyzni.txt�.
	 * @param nazwaPliku - �cie�ka do pliku wej�ciowego
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
	 * Napisa� funkcj�, kt�rej zadaniem jest odczytanie danych tabelarycznych z pliku
	 * tekstowego, a nast�pnie zapisanie ich do nowego pliku w postaci kodu HTML.
	 * Przyk�ad:
	 * Wej�cie:
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
	 * @param filename - nazwa pliku wej�ciowego
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
	 * Napisa� program, kt�ry dla pliku tekstowego o podanej nazwie wyznaczy �wykres�
	 * cz�sto�ci wyst�pie� ma�ych liter alfabetu angielskiego. S�upki wykresu maj�
	 * zosta� utworzone ze znak�w gwiazdki �*�, przy czym d�ugo�� s�upka dla najcz�ciej
	 * wyst�puj�cej litery powinna wynosi� 50. Dodatkowo dla ka�dego znaku nale�y dodatkowo
	 * wy�wietli� liczb� jego wyst�pie�.
	 * @param filename - nazwa pliku wej�ciowego
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
