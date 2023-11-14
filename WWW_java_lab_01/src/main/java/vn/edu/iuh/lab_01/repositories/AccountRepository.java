package vn.edu.iuh.lab_01.repositories;

import vn.edu.iuh.lab_01.database.DatabaseConnection;
import vn.edu.iuh.lab_01.models.Account;
import vn.edu.iuh.lab_01.models.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private Connection connection;
    public AccountRepository() throws Exception {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    private List<Role> grantAccesses(String accountId) {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM role WHERE role_id IN (SELECT role_id FROM account_role WHERE account_id = ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setRoleId(resultSet.getString("role_id"));
                role.setRoleName(resultSet.getString("role_name"));
                role.setDescription(resultSet.getString("description"));
                role.setStatus(resultSet.getInt("status"));
                roles.add(role);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return roles;
    }
    public List<Account> getAll(){
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM account";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Account account = new Account();
                account.setAccountId(resultSet.getString("account_id"));
                account.setFullName(resultSet.getString("full_name"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setStatus(resultSet.getInt("status"));
                account.setRoles(this.grantAccesses(account.getAccountId()));
                accounts.add(account);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
    public boolean addAccount(Account account){
        String sql = "INSERT INTO account(account_id, full_name, password, email, phone, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getAccountId());
            preparedStatement.setString(2, account.getFullName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setInt(6, 1);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public Optional<Account> findByEmailAndPassword(String email, String password){
        String sql = "SELECT * FROM account WHERE email = ? AND password = ?";
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Account account = new Account();
                account.setAccountId(resultSet.getString("account_id"));
                account.setFullName(resultSet.getString("full_name"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setStatus(resultSet.getInt("status"));
                return Optional.of(account);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public Optional<Account> findById (String accountId){
        String sql = "SELECT * FROM account WHERE account_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Account account = new Account();
                account.setAccountId(resultSet.getString("account_id"));
                account.setFullName(resultSet.getString("full_name"));
                account.setPassword(resultSet.getString("password"));
                account.setEmail(resultSet.getString("email"));
                account.setPhone(resultSet.getString("phone"));
                account.setStatus(resultSet.getInt("status"));
                return Optional.of(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public void updateAccount(Account account){
        String sql = "UPDATE account SET full_name = ?, password = ?, email = ?, phone = ?, status = ? WHERE account_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getFullName());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPhone());
            preparedStatement.setString(5, account.getAccountId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAccount(String accountId){
        String sql = "DELETE FROM account WHERE account_id = ?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
