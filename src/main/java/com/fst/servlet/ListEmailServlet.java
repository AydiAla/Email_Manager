package com.fst.servlet;

import com.fst.controller.ListEmailController;
import com.fst.model.EmailModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListEmailServlet extends HttpServlet {

    private EmailModel emailModel;
    private ListEmailController listEmailController;

    public void init() throws ServletException {
        emailModel = new EmailModel();
        listEmailController = new ListEmailController(emailModel);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listEmailController.handleRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        if (request.getParameter("subscribe") != null) {
            emailModel.getAddresses().add(email);
            emailModel.insertEmailToDatabase(email);
        } else if (request.getParameter("unsubscribe") != null) {
            emailModel.getAddresses().remove(email);
            emailModel.removeEmailFromDatabase(email);
        }

        response.sendRedirect(request.getContextPath() + "/ListEmailServlet");
    }
}
