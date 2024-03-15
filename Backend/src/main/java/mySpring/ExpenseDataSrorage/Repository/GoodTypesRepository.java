package mySpring.ExpenseDataSrorage.Repository;

import mySpring.ExpenseDataSrorage.Connection.SQLConnection;
import mySpring.ExpenseDataSrorage.Model.GoodType;
import mySpring.ExpenseDataSrorage.Model.GoodTypeCreateDto;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodTypesRepository {
    private static final String QUERY_TO_FIND_ALL = "SELECT * FROM GoodTypes";
    private static final String QUERY_TO_INSERT_VALUES = "INSERT INTO GoodTypes (good_type_name) VALUES('%s')";
    private static final String QUERY_TO_FIND_BY_ID = "SELECT * FROM GoodTypes WHERE good_type_id = %d";
    private static final String QUERY_TO_UPDATE_BY_ID = "UPDATE GoodTypes SET good_type_name = '%s' WHERE good_type_id = %d";
    private static final String QUERY_TO_DELETE_BY_ID = "DELETE FROM GoodTypes WHERE good_type_id = %d";
    private static final String MESSAGE_FOR_UNSUCCESSFUL_DELETION = "No good type with id = %d";
    private static final String MESSAGE_FOR_SUCCESSFUL_DELETION = "Good type with id = %d was successfully deleted";
    private final Statement statement;

    public GoodTypesRepository(Connection connection) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<GoodType> findAll() {
        try {
            ArrayList<GoodType> goodTypes = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_ALL);
            while (resultSet.next()) {
                GoodType goodType = new GoodType
                        (resultSet.getInt("good_type_id"), resultSet.getString("good_type_name"));
                goodTypes.add(goodType);
            }
            return goodTypes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public GoodTypeCreateDto save(GoodTypeCreateDto goodTypeCreateDto){
        try {
            statement.execute(QUERY_TO_INSERT_VALUES.formatted(goodTypeCreateDto.getGood_type_name()));
            return goodTypeCreateDto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public GoodType findById(int id){
        try {
            ResultSet resultSet = statement.executeQuery(QUERY_TO_FIND_BY_ID.formatted(id));
            if(resultSet.next()){
                return new GoodType(resultSet.getInt("good_type_id"), resultSet.getString("good_type_name"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public GoodType updateById(GoodTypeCreateDto goodTypeCreateDto, int id){
        try {
            if (statement.executeUpdate(QUERY_TO_UPDATE_BY_ID.
                    formatted(goodTypeCreateDto.getGood_type_name(), id))!=0)
                return new GoodType(id, goodTypeCreateDto);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public String deleteById(int id){
        try {
            if (statement.executeUpdate(QUERY_TO_DELETE_BY_ID.formatted(id)) == 0) return MESSAGE_FOR_UNSUCCESSFUL_DELETION.formatted(id);

        } catch (SQLException e) {
            e.getErrorCode();
        }
        return MESSAGE_FOR_SUCCESSFUL_DELETION.formatted(id);
    }
}
