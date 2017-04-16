package polishLearningJavaSeven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Zajêcia 7 – pliki binarne
 * @author kaje11
 *
 */
public class Container {
	/**
	 * TASK ONE.
	 * Napisaæ funkcjê odwrocKolejnosc , która korzystaj¹c z klasy RandomAccessFile
	 * utworzy plik binarny z 10 liczbami ca³kowitymi wylosowanymi z przedzia³u [0, 100).
	 * W nastêpnym kroku nale¿y odwróciæ kolejnoœæ liczb w pliku, nie korzystaj¹c przy
	 * tym z pomocniczych struktur danych (np. tablicy), ale odpowiednio przesuwaj¹c
	 * pozycjê w pliku za pomoc¹ metod klasy RandomAccessFile . Œcie¿ka do pliku
	 * powinna byæ przekazana jako parametr.
	 * @param filePath - œcie¿ka do pliku
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
	 * Napisaæ funkcjê generuj¹c¹ plik z bitmap¹ w formacie PGM (Portable Gray Map).
	 * Format pliku jest nastêpuj¹cy:
	 * a) ”P5” – nag³ówek pliku;
	 * b) W kolejnym wierszu ”w h 255” – szerokoœæ i wysokoœæ obrazka w postaci
	 * tekstowej, 255 – maksymalna jasnoœæ piksela.
	 * c) W kolejnym wierszu jasnoœæ dla ka¿dego z w ×h pikseli w postaci ci¹gu w·h
	 * bajtów.
	 * Przyk³adowy plik:
	 * P5
	 * 100 100 255
	 * ... (jasnoœæ pikseli)
	 * Jasnoœæ pikseli nale¿y dobraæ, tak aby otrzymaæ „siatkê”, jak na rys. 7.1.
	 * Funkcja otrzymuje jako parametr œcie¿kê do pliku, który ma zostaæ utworzony
	 * (np. ”obrazek.pgm”). Do zapisu danych tekstowych nale¿y zastosowaæ metodê
	 * writeBytes(String str) z klasy RandomAccessFile , kolor piksela (0 – czarny,
	 * 255 – bia³y) nale¿y zapisaæ za pomoc¹ metody writeByte(int b).
	 * @param filePath - œcie¿ka do pliku
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
