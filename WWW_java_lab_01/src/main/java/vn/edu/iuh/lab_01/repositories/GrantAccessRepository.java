package vn.edu.iuh.lab_01.repositories;

import vn.edu.iuh.lab_01.database.DatabaseConnection;
import vn.edu.iuh.lab_01.models.GrantAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrantAccessRepository {
    private Connection connection;

    public GrantAccessRepository() throws SQLException, ClassNotFoundException{
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    public void addGrantAccess(GrantAccess grantAccess){
        String sql = "INSERT INTO grant_access (account_id, role_id, is_grant, note) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, grantAccess.getAccountId());
            preparedStatement.setString(2, grantAccess.getRoleId());
            preparedStatement.setInt(3, grantAccess.getIsGrant());
            preparedStatement.setString(4, grantAccess.getNote());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<GrantAccess> getGrantAccessByAccountId(String accountId){
        List<GrantAccess> grantAccesses = new ArrayList<>();
        String sql = "SELECT * FROM grant_access WHERE account_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                GrantAccess grantAccess = new GrantAccess();
                grantAccess.setAccountId(resultSet.getString("account_id"));
                grantAccess.setRoleId(resultSet.getString("role_id"));
                grantAccess.setIsGrant(resultSet.getInt("is_grant"));
                grantAccess.setNote(resultSet.getString("note"));
                grantAccesses.add(grantAccess);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return grantAccesses;
    }
}
