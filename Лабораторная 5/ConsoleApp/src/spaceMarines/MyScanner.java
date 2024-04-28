package spaceMarines;

import java.util.Scanner;

public class MyScanner {
    /**
     * Сделал отдельный класс, чтобы у него был статический метод Scan
     * @return String
     */
    public static String Scan(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
