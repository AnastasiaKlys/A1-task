package dao;

import connection.ConnectionManager;
import model.Posting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostingDao implements GenericDao<Posting> {

    private static volatile PostingDao INSTANCE;

    private PostingDao() {
    }

    public static PostingDao getInstance() {
        if (INSTANCE == null) {
            synchronized (EmployeeDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PostingDao();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Posting create(Posting entity) {
        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO postings (mat_doc, item, doc_date, pstng_date, material_description, quantity, bun, amount_lc, crcy, user_name, authorized_delivery)  VALUES (?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, entity.getMatDoc());
            preparedStatement.setString(2, entity.getItem());
            preparedStatement.setString(3, entity.getDocDate());
            preparedStatement.setString(4, entity.getPstngDate());
            preparedStatement.setString(5, entity.getMaterialDescription());
            preparedStatement.setString(6, entity.getQuantity());
            preparedStatement.setString(7, entity.getBun());
            preparedStatement.setString(8, entity.getAmountLc());
            preparedStatement.setString(9, entity.getCrcy());
            preparedStatement.setString(10, entity.getUserName());
            preparedStatement.setBoolean(11, entity.getAuthorizedDelivery());

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
