package service;

import dao.EmployeeDao;
import model.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;
    private static volatile EmployeeService INSTANCE;
    private EmployeeService(){
        employeeDao = EmployeeDao.getInstance();
    }
    public static EmployeeService getInstance() {
        if (INSTANCE == null) {
            synchronized (EmployeeService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EmployeeService();
                }
            }
        }
        return INSTANCE;
    }
    public void createAll(List<Employee> employeeList){
        for (Employee employee : employeeList){
            employeeDao.create(employee);
        }
    }

}
