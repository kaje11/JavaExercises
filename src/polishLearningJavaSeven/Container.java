package polishLearningJavaSeven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Zaj�cia 7 � pliki binarne
 * @author kaje11
 *
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisa� funkcj� odwrocKolejnosc , kt�ra korzystaj�c z klasy RandomAccessFile
	 * utworzy plik binarny z 10 liczbami ca�kowitymi wylosowanymi z przedzia�u [0, 100).
	 * W nast�pnym kroku nale�y odwr�ci� kolejno�� liczb w pliku, nie korzystaj�c przy
	 * tym z pomocniczych struktur danych (np. tablicy), ale odpowiednio przesuwaj�c
	 * pozycj� w pliku za pomoc� metod klasy RandomAccessFile . �cie�ka do pliku
	 * powinna by� przekazana jako parametr.
	 * @param filePath - �cie�ka do pliku
	 */
	static void odwrocKolejnosc(final String filePath) {
		try(RandomAccessFile randomFile = new RandomAccessFile(filePath, "rw")) {
			Random rand = new Random();
			System.out.println("Opening the random access file.");
			for (int i = 0; i < 10; i++) {
				int myn = rand.nextInt(100);
				System.out.print(myn + " ");
				randomFile.writeInt(myn);
			}
			System.out.println();

			int num, temp;
			for (int i = 0; i < 5; i++) {
				randomFile.seek(i * Integer.BYTES);
				num = randomFile.readInt();
				randomFile.seek((10 - i - 1) * Integer.BYTES);
				temp = randomFile.readInt();
				randomFile.writeInt(num);
				randomFile.seek(i * Integer.BYTES);
				randomFile.writeInt(temp);
			}

			for (int i = 0; i < 10; i++) {
				randomFile.seek(i * Integer.BYTES);
				System.out.print(randomFile.readInt() + " ");
			}
			//randomFile.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * TASK TWO.
	 * Napisa� funkcj� generuj�c� plik z bitmap� w formacie PGM (Portable Gray Map).
	 * Format pliku jest nast�puj�cy:
	 * a) �P5� � nag��wek pliku;
	 * b) W kolejnym wierszu �w h 255� � szeroko�� i wysoko�� obrazka w postaci
	 * tekstowej, 255 � maksymalna jasno�� piksela.
	 * c) W kolejnym wierszu jasno�� dla ka�dego z w �h pikseli w postaci ci�gu w�h
	 * bajt�w.
	 * Przyk�adowy plik:
	 * P5
	 * 100 100 255
	 * ... (jasno�� pikseli)
	 * Jasno�� pikseli nale�y dobra�, tak aby otrzyma� �siatk�, jak na rys. 7.1.
	 * Funkcja otrzymuje jako parametr �cie�k� do pliku, kt�ry ma zosta� utworzony
	 * (np. �obrazek.pgm�). Do zapisu danych tekstowych nale�y zastosowa� metod�
	 * writeBytes(String str) z klasy RandomAccessFile , kolor piksela (0 � czarny,
	 * 255 � bia�y) nale�y zapisa� za pomoc� metody writeByte(int b).
	 * @param filePath - �cie�ka do pliku
	 */
	static void generatePGM(final String filePath) {
        try (RandomAccessFile randomFile = new RandomAccessFile(filePath, "rw")) {
            final int w = 100;
            final int h = 100;
            randomFile.writeBytes("P5\n");
            randomFile.writeBytes(w + " " + h + " 255\n");
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    randomFile.writeByte(i % 2 != 0 && j % 2 != 0 ? 255 : 0);
                }
            }
        } catch (IOException e) {
			e.printStackTrace();
        }
    }
}
