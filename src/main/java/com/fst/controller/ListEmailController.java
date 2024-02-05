package com.fst.controller;

import com.fst.model.EmailModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListEmailController {

    private EmailModel emailModel;

    public ListEmailController(EmailModel emailModel) {
        this.emailModel = emailModel;
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> addresses = emailModel.getAddresses();
        List<String> dbEmails = emailModel.retrieveEmailsFromDatabase();
        request.setAttribute("addresses", addresses);
        request.setAttribute("dbEmails", dbEmails);
        request.getRequestDispatcher("ListEmailView.jsp").forward(request, response);
    }
}
