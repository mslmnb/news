package com.epam.news.servlet;

import com.epam.news.dao.InMemoNewDAOImpl;
import com.epam.news.service.NewService;
import com.epam.news.service.NewServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewServlet extends HttpServlet {
    private NewService service;

    @Override
    public void init() throws ServletException {
        super.init();
        this.service = new NewServiceImpl(new InMemoNewDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("news", service.getAll());
        request.getRequestDispatcher("/news.jsp").forward(request, response);
    }
}
