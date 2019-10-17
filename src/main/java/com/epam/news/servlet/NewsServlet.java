package com.epam.news.servlet;

import com.epam.news.service.NewsService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
        WebApplicationContext springContext = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
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
