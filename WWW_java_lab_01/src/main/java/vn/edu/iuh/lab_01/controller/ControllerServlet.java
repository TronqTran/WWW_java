package vn.edu.iuh.lab_01.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.lab_01.services.AccountService;

import java.io.IOException;

@WebServlet(name = "controllerServlet", urlPatterns = {"/controllerServlet"})
public class ControllerServlet extends HttpServlet {
    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        try {
            this.accountService = new AccountService();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "showAddAccount": {
                this.accountService.showAddAccount(req, resp);
                break;
            }
            case "showLoginForm":{
                this.accountService.showLoginForm(req, resp);
                break;
            }
            case "showUpdateAccount":{
                this.accountService.showUpdateAccount(req, resp);
                break;
            }
            case "showAddRole":{
                this.accountService.showAddRole(req, resp);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "login":{
                this.accountService.login(req, resp);
                break;
            }
            case "logout": {
                this.accountService.logout(req, resp);
                break;
            }
            case "addAcount": {
                this.accountService.addAccount(req, resp);
                break;
            }
            case "addRole":{
                this.accountService.addRole(req, resp);
                break;
            }
            case "deleteUser":{
                this.accountService.deleteUser(req, resp);
                break;
            }
            case "updateAccount":{
                this.accountService.updateAccount(req, resp);
                break;
            }
            default:{
                break;
            }
        }
    }
}
