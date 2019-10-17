package com.epam.news.servlet;

import com.epam.news.dao.InMemoNewsDAOImpl;
import com.epam.news.service.NewsService;
import com.epam.news.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewsServlet extends HttpServlet {
    private static final String JSON_MIMETYPE = "application/json;charset=UTF-8";
    private static final String START_PAGE = "/app";
    private static final String GET_NEWSLIST = "/app/list";
    private NewsService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        service = springContext.getBean(NewsService.class);
    }

    @Override
    protected void service(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI().substring(request.getContextPath().length());
        PrintWriter writer ;

        switch (requestURI) {
            case START_PAGE:
                request.getRequestDispatcher("/jsp/news.jsp").forward(request, response);
                break ;
            case GET_NEWSLIST:
                response.setContentType(JSON_MIMETYPE);
                writer = response.getWriter();
                writer.print(service.getAllInJSONFormat());
                break ;
            default:
                break ;
        }
    }
}
