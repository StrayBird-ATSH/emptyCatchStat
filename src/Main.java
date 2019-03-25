import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        File file = new File("D:\\Downloads\\src");
        fileIterator(file);
    }

    private static void fileIterator(File file) {
        if (file.isFile()) executeSearch(file);
        else {
            File[] files = file.listFiles();
            if (files != null)
                for (File file1 : files)
                    fileIterator(file1);
        }
    }

    private static void executeSearch(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.contains("catch (") && (input.contains("{}") || input.contains("{ }")))
                    System.out.println(input);
            }
        } catch (FileNotFoundException e) {
            Logger.getAnonymousLogger().info("FileNotFound");
        }
    }
}
