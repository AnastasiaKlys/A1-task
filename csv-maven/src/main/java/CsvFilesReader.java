import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class CsvFilesReader {

    private static final String FIELD_NAME = "авторизованная поставка";
    private static final int NUMBER_OF_USER_NAME_COLUMN = 9;

    public static void readAllFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            Iterable<CSVRecord> records = CSVFormat.MYSQL.parse(br);

            for (CSVRecord record : records) {
                for (int i = 0; i < record.size(); i++) {
                    System.out.print(record.get(i));
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readColumnFromTable(String filePath, int columnNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            Iterable<CSVRecord> records = CSVFormat.MYSQL.parse(br);
            for (CSVRecord record : records) {
                System.out.println(record.get(columnNumber));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leftJoinTwoFiles(String leftFilePath, String rightFilePath) {
        HashSet<String> activeUsers = new HashSet<>();
        try (BufferedReader rightBr = new BufferedReader(new FileReader(rightFilePath))) {
            Iterable<CSVRecord> records = CSVFormat.MYSQL.parse(rightBr);
            for (CSVRecord record : records) {
                activeUsers.add((record.get(1)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader leftBr = new BufferedReader(new FileReader(leftFilePath))) {

            Iterable<CSVRecord> records = CSVFormat.MYSQL.parse(leftBr);

            for (CSVRecord record : records) {

                for (int i = 0; i < record.size() - 1; i++) {
                    System.out.print(record.get(i) + "    ");
                }

                if (record.getRecordNumber() == 1) {
                    System.out.print(record.get(NUMBER_OF_USER_NAME_COLUMN));
                    System.out.println(",   " + FIELD_NAME);
                    continue;
                }

                if (activeUsers.contains(record.get(NUMBER_OF_USER_NAME_COLUMN))) {
                    System.out.print((record.get(NUMBER_OF_USER_NAME_COLUMN)));
                    System.out.println(",   TRUE");
                } else {
                    System.out.print((record.get(NUMBER_OF_USER_NAME_COLUMN)));
                    System.out.println(",   FALSE");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
