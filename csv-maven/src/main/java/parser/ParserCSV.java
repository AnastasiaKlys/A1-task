package parser;

import model.Employee;
import model.Posting;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParserCSV {
    private static final int NUMBER_OF_USER_NAME_COLUMN = 9;

    public static List<Employee> loadEmployees(String filePath) {
        List<Employee> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            Iterable<CSVRecord> records = CSVFormat.MYSQL.parse(br);
            records.iterator().next();

            for (CSVRecord record : records) {
                Employee employee = new Employee(record.get(0), record.get(1), record.get(2), record.get(3), record.get(4));
                employeeList.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static List<Posting> loadPostings(String postingsFilePath, String loginsFilePath ){
        List<Posting> postingList = new ArrayList<>();

        List<Employee> employeeList = loadEmployees(loginsFilePath);
        HashSet<String> activeUsers = loadActiveUsers(employeeList);

        try (BufferedReader leftBr = new BufferedReader(new FileReader(postingsFilePath))) {

            Iterable<CSVRecord> records = CSVFormat.MYSQL.parse(leftBr);


            records.iterator().next();

            for (CSVRecord record : records) {
                Posting posting = new Posting(record.get(0), record.get(1), record.get(2), record.get(3), record.get(4),
                        record.get(5), record.get(6), record.get(7), record.get(8), record.get(9));
                posting.setAuthorizedDelivery(activeUsers.contains(record.get(NUMBER_OF_USER_NAME_COLUMN)));
                postingList.add(posting);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postingList;
    }
    private static HashSet<String> loadActiveUsers(List<Employee> employees){
        HashSet<String> result = new HashSet<>();
        for (Employee employee : employees){
            if (employee.getIsActive()){
                result.add(employee.getAppAccountName());
            }
        }
        return result;
    }
}

