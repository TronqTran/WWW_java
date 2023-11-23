package vn.edu.iuh.lab_01.repositories;

import vn.edu.iuh.lab_01.database.DatabaseConnection;
import vn.edu.iuh.lab_01.models.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleRepository {
    private Connection connection;

    public RoleRepository() throws SQLException, ClassNotFoundException{
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    public Optional<Role> findRoleById(String id){
        String sql = "SELECT * FROM role WHERE role_id = ?";
        try {
            var preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Role role = new Role();
                role.setRoleId(resultSet.getString("role_id"));
                role.setRoleName(resultSet.getString("role_name"));
                role.setDescription(resultSet.getString("description"));
                role.setStatus(resultSet.getInt("status"));
                return Optional.of(role);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public List<Role> getAll(){
        List<Role>roles = new ArrayList<>();
        String sql = "SELECT * FROM role";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Role role = new Role();
                role.setRoleId(resultSet.getString("role_id"));
                role.setStatus(resultSet.getInt("status"));
                role.setRoleName(resultSet.getString("role_name"));
                role.setDescription(resultSet.getString("description"));

                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    public void addRole(Role role){
        String sql = "INSERT INTO role(role_id, role_name, description, status) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, role.getRoleId());
            preparedStatement.setString(2, role.getRoleName());
            preparedStatement.setString(3, role.getDescription());
            preparedStatement.setInt(4, role.getStatus());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
