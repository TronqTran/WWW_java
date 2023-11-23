package vn.edu.iuh.lab_01.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.lab_01.models.Account;
import vn.edu.iuh.lab_01.models.GrantAccess;
import vn.edu.iuh.lab_01.models.Log;
import vn.edu.iuh.lab_01.models.Role;
import vn.edu.iuh.lab_01.repositories.AccountRepository;
import vn.edu.iuh.lab_01.repositories.GrantAccessRepository;
import vn.edu.iuh.lab_01.repositories.LogRepository;
import vn.edu.iuh.lab_01.repositories.RoleRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AccountService {
    private AccountRepository accountRepository;
    private GrantAccessRepository grantAccessRepository;
    private LogRepository logRepository;
    private RoleRepository roleRepository;

    public AccountService() throws SQLException, ClassNotFoundException  {
        this.accountRepository = new AccountRepository();
        this.grantAccessRepository = new GrantAccessRepository();
        this.logRepository = new LogRepository();
        this.roleRepository = new RoleRepository();
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Optional<Account> account = this.accountRepository.findByEmailAndPassword(email, password);
        if (!account.isPresent()) {
            request.setAttribute("error", "Email or password is incorrect");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
        else {
            Account currentAccount = account.get();
            Log log = new Log((long) new Date().getTime(), currentAccount.getAccountId(), "");
            List<GrantAccess> grantAccesses = this.grantAccessRepository.getGrantAccessByAccountId(currentAccount.getAccountId());
            this.logRepository.insertLog(log);
            boolean isAdmin = false;
            for (GrantAccess grantAccess : grantAccesses){
                Optional<Role> role = this.roleRepository.findRoleById(grantAccess.getRoleId());
                currentAccount.addRole(role.get());
                if (grantAccess.getRoleId().equals("admin") && grantAccess.getIsGrant() ==1){
                    isAdmin = true;
                }
            }
            if (isAdmin){
                List<Account>accounts = this.accountRepository.getAll();
                request.getSession().setAttribute("account", currentAccount);
                request.getSession().setAttribute("log", log);

                request.setAttribute("accounts", accounts);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }
            else {
                request.getSession().setAttribute("account", currentAccount);
                request.getSession().setAttribute("log", log);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            }
        }
    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Log log = (Log) request.getSession().getAttribute("log");
           this.logRepository.updateLogoutTime(log.getId());
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    public void addAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String[] selectedRoles = request.getParameterValues("roles");

        Account account = new Account();
        account.setAccountId(accountId);
        account.setFullName(fullName);
        account.setPassword(password);
        account.setEmail(email);
        account.setPhone(phone);

        if (this.accountRepository.addAccount(account)){
            for (int i = 0; i < selectedRoles.length; i++){
                GrantAccess grantAccess = new GrantAccess();
                grantAccess.setAccountId(accountId);
                grantAccess.setRoleId(selectedRoles[i]);
                grantAccess.setIsGrant(1);
                grantAccess.setNote("");
                this.grantAccessRepository.addGrantAccess(grantAccess);
            }
            List<Account> accounts = this.accountRepository.getAll();
            Account currentAccount = (Account) request.getSession().getAttribute("account");
            request.setAttribute("account", currentAccount);
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }
    }
    public void showAddAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Role> roles = this.roleRepository.getAll();
       request.setAttribute("roles", roles);
         request.getRequestDispatcher("account_form.jsp").forward(request, response);
    }
    public void deleteUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");
        Account currentAccount = (Account) request.getSession().getAttribute("account");
        if (accountId.equalsIgnoreCase(currentAccount.getAccountId())){
            request.setAttribute("error", "You can not delete your account");
            List<Account> accounts = this.accountRepository.getAll();
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }
        else {
            this.accountRepository.deleteAccount(accountId);
            List<Account> accounts = this.accountRepository.getAll();
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }
    }
    public void showLoginForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    public void showUpdateAccount (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountId = request.getParameter("accountId");
        Optional<Account> existingAccount = this.accountRepository.findById(accountId);
        if (!existingAccount.isPresent()){
            System.out.println("RUNNING");
            List<Account> accounts = this.accountRepository.getAll();
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }
        else {
            request.setAttribute("account", existingAccount.get());
            request.getRequestDispatcher("update_form.jsp").forward(request, response);
        }
    }
    public void updateAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account updatingAccount = new Account();
        updatingAccount.setAccountId(request.getParameter("accountId"));
        updatingAccount.setFullName(request.getParameter("fullName"));
        updatingAccount.setPassword(request.getParameter("password"));
        updatingAccount.setEmail(request.getParameter("email"));
        updatingAccount.setPhone(request.getParameter("phone"));

        this.accountRepository.updateAccount(updatingAccount);

        List<Account> accounts = this.accountRepository.getAll();
        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
    public void showAddRole (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("role_form.jsp").forward(request, response);
    }
    public void addRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Role role = new Role();
        role.setRoleId(request.getParameter("roleId"));
        role.setRoleName(request.getParameter("roleName"));
        role.setDescription(request.getParameter("description"));
        role.setStatus(1);

        this.roleRepository.addRole(role);

        List<Account> accounts = this.accountRepository.getAll();
        Account currentAccount = (Account) request.getSession().getAttribute("account");
        request.setAttribute("account", currentAccount);
        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
