package vn.edu.iuh.lab_01.repositories;

import vn.edu.iuh.lab_01.database.DatabaseConnection;
import vn.edu.iuh.lab_01.models.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Optional;

public class LogRepository {
    private Connection connection;

    public LogRepository() throws Exception{
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void insertLog(Log log){
        String sql = "INSERT INTO log (id, account_id, notes) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, log.getId());
            preparedStatement.setString(2, log.getAccountId());
            preparedStatement.setString(3, log.getNotes());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void updateLogoutTime(long logId){
        String sql = "UPDATE log SET logout_time = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setLong(2, logId);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Optional<Log> getLogById(long logId){
        String sql = "SELECT * FROM log WHERE id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setLong(1, logId);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Log log = new Log();
                log.setId(resultSet.getLong("id"));
                log.setAccountId(resultSet.getString("account_id"));
                log.setLoginTime(resultSet.getTimestamp("login_time"));
                log.setLogoutTime(resultSet.getTimestamp("logout_time"));
                log.setNotes(resultSet.getString("notes"));
                return Optional.of(log);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
