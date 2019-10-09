package com.epam.news.servlet;

import com.epam.news.dao.InMemoNewsDAOImpl;
import com.epam.news.service.NewsService;
import com.epam.news.service.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewsServlet extends HttpServlet {
    private NewsService service;

    @Override
    public void init() throws ServletException {
        super.init();
        this.service = new NewsServiceImpl(new InMemoNewsDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("news", service.getAll());
        request.getRequestDispatcher("/jsp/news.jsp").forward(request, response);
    }
}
