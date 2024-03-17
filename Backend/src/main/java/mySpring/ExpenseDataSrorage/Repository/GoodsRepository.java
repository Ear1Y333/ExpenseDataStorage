package mySpring.ExpenseDataSrorage.Repository;

import mySpring.ExpenseDataSrorage.Model.Good;
import mySpring.ExpenseDataSrorage.Model.GoodCreateDto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsRepository {
    private static final String QUERY_TO_FIND_ALL = "SELECT * FROM Goods";
    private static final String QUERY_TO_INSERT_VALUES = "INSERT INTO Goods (good_name, type) VALUES('%s', %d)";
    private static final String QUERY_TO_FIND_BY_ID = "SELECT * FROM Goods WHERE good_id = %d";
    private static final String QUERY_TO_UPDATE_BY_ID = "UPDATE Goods SET good_name = '%s', type = %d WHERE good_id = %d";
    private static final String QUERY_TO_DELETE_BY_ID = "DELETE FROM Goods WHERE good_id = %d";
    private static final String MESSAGE_FOR_UNSUCCESSFUL_DELETION = "No good with id = %d";
    private static final String MESSAGE_FOR_SUCCESSFUL_DELETION = "Good with id = %d was successfully deleted";
    private final Statement statement;

    public GoodsRepository(Connection connection) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Good> findAll() throws SQLException {
        ArrayList<Good> goods = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_ALL);
        while (resultSet.next()) {
            Good good = new Good
                    (resultSet.getInt("good_id"), resultSet.getString("good_name"),
                            resultSet.getInt("type"));
            goods.add(good);
        }
        return goods;
    }

    public GoodCreateDto save(GoodCreateDto goodCreateDto) throws SQLException {
        statement.execute(QUERY_TO_INSERT_VALUES.formatted(goodCreateDto.getGood_name(), goodCreateDto.getType()));
        return goodCreateDto;
    }

    public Good findById(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_BY_ID.formatted(id));
        if (resultSet.next()) {
            return new Good(resultSet.getInt("good_id"), resultSet.getString("good_name"), resultSet.getInt("type"));
        }
        return null;
    }

    public Good updateById(GoodCreateDto goodCreateDto, int id) throws SQLException {
        if (statement.executeUpdate(QUERY_TO_UPDATE_BY_ID.
                formatted(goodCreateDto.getGood_name(), goodCreateDto.getType(), id)) != 0)
            return new Good(id, goodCreateDto);
        return null;
    }

    public String deleteById(int id) throws SQLException {
        if (statement.executeUpdate(QUERY_TO_DELETE_BY_ID.formatted(id)) != 0)
            return MESSAGE_FOR_SUCCESSFUL_DELETION.formatted(id);
        return MESSAGE_FOR_UNSUCCESSFUL_DELETION.formatted(id);
    }
}