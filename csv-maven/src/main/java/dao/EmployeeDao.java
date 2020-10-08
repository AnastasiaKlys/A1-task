package dao;

import connection.ConnectionManager;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao implements GenericDao<Employee> {

    private static volatile EmployeeDao INSTANCE;

    private EmployeeDao() {
    }

    public static EmployeeDao getInstance() {
        if (INSTANCE == null) {
            synchronized (EmployeeDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EmployeeDao();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Employee create(Employee entity) {
        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO logins (application, app_account_name, is_active, job_title, department)  VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, entity.getApplication());
            preparedStatement.setString(2, entity.getAppAccountName());
            preparedStatement.setBoolean(3, entity.getIsActive());
            preparedStatement.setString(4, entity.getJobTitle());
            preparedStatement.setString(5, entity.getDepartment());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

}
