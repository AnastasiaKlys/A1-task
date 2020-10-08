
//Задание 3 "Неавторизованные поставки"
//        Реализуйте любым из доступных способов следующие шаги:
//        1. Прочитать файл logins.csv с локальной файловой системы
//        2. Прочитать файл postings.csv с локальной файловой системы (строки со значениями в поле Mat. Doc.)
//        3. Добавить булевое поле "авторизованная поставка" в данные из postings.csv,
//        которое будет указывать, что User Name (postings.csv) находится в списке AppAccountName (logins.csv) и IsActive
//        4. Cохранить в SQL СУБД данные файла logins.csv
//        5. Сохранить в SQL СУБД данные файла postings.csv (с дополнительным полем)
//        6. Отдавать по GET (REST API) за период (день, месяц, квартал, год) данные из базы,
//        загруженные из postings.csv (с возможностью запроса с фильтром по полю "авторизованная поставка")

import model.Employee;
import model.Posting;
import parser.ParserCSV;
import service.EmployeeService;
import service.PostingService;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    private static final String PATH_TO_LOGINS_FILE = "res/logins.csv";
    private static final String PATH_TO_POSTINGS_FILE = "res/postings.csv";

    public static void main(String[] args) throws FileNotFoundException {

        CsvFilesReader.readAllFile(PATH_TO_LOGINS_FILE);
        CsvFilesReader.readColumnFromTable(PATH_TO_POSTINGS_FILE, 0);
        CsvFilesReader.leftJoinTwoFiles(PATH_TO_POSTINGS_FILE, PATH_TO_LOGINS_FILE);

        List<Employee> dataFromCsvEmployees = ParserCSV.loadEmployees(PATH_TO_LOGINS_FILE);
        EmployeeService employeeService = EmployeeService.getInstance();
        employeeService.createAll(dataFromCsvEmployees);

        List<Posting> dataFromCsvPostings = ParserCSV.loadPostings(PATH_TO_POSTINGS_FILE,PATH_TO_LOGINS_FILE);
        PostingService postingService = PostingService.getInstance();
        postingService.createAll(dataFromCsvPostings);

    }
}

