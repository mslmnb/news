package com.epam.news.servlet;

import com.epam.news.dao.InMemoNewsDAOImpl;
import com.epam.news.service.NewsService;
import com.epam.news.service.NewsServiceImpl;

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
    private static final String GET_CUSTOMERS = "/app/customers";
    private static final String CUSTOMERS = "[ " +
            "{ \"key\" : 1, \"Name\" : \"Alfreds Futterkiste\", \"City\" : \"Berlin\", \"Country\" : \"Germany\" }, " +
            "{ \"key\" : 2, \"Name\" : \"Berglunds snabbköp\", \"City\" : \"Luleå\", \"Country\" : \"Sweden\" }, " +
            "{ \"key\" : 3, \"Name\" : \"Centro comercial Moctezuma\", \"City\" : \"México D.F.\", \"Country\" : \"Mexico\" }, " +
            "{ \"key\" : 4, \"Name\" : \"Ernst Handel\", \"City\" : \"Graz\", \"Country\" : \"Austria\" }, " +
            "{ \"key\" : 5, \"Name\" : \"FISSA Fabrica Inter. Salchichas S.A.\", \"City\" : \"Madrid\", \"Country\" : \"Spain\" }, " +
            "{ \"key\" : 6, \"Name\" : \"Galería del gastrónomo\", \"City\" : \"Barcelona\", \"Country\" : \"Spain\" }, " +
            "{ \"key\" : 7, \"Name\" : \"Island Trading\", \"City\" : \"Cowes\", \"Country\" : \"UK\" }, " +
            "{ \"key\" : 8, \"Name\" : \"Königlich Essen\", \"City\" : \"Brandenburg\", \"Country\" : \"Germany\" }, " +
            "{ \"key\" : 9, \"Name\" : \"Laughing Bacchus Wine Cellars\", \"City\" : \"Vancouver\", \"Country\" : \"Canada\" }, " +
            "{ \"key\" : 10, \"Name\" : \"Magazzini Alimentari Riuniti\", \"City\" : \"Bergamo\", \"Country\" : \"Italy\" }, " +
            "{ \"key\" : 11, \"Name\" : \"North/South\", \"City\" : \"London\", \"Country\" : \"UK\" }, " +
            "{ \"key\" : 12, \"Name\" : \"Paris spécialités\", \"City\" : \"Paris\", \"Country\" : \"France\" }, " +
            "{ \"key\" : 13, \"Name\" : \"Rattlesnake Canyon Grocery\", \"City\" : \"Albuquerque\", \"Country\" : \"USA\" }, " +
            "{ \"key\" : 14, \"Name\" : \"Simons bistro\", \"City\" : \"København\", \"Country\" : \"Denmark\" }, " +
            "{ \"key\" : 15, \"Name\" : \"The Big Cheese\", \"City\" : \"Portland\", \"Country\" : \"USA\" }, " +
            "{ \"key\" : 16, \"Name\" : \"Vaffeljernet\", \"City\" : \"Århus\", \"Country\" : \"Denmark\" }, " +
            "{ \"key\" : 17, \"Name\" : \"Wolski Zajazd\", \"City\" : \"Warszawa\", \"Country\" : \"Poland\" } ]";
    private NewsService service;

    @Override
    public void init() throws ServletException {
        super.init();
        this.service = new NewsServiceImpl(new InMemoNewsDAOImpl());
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
            case GET_CUSTOMERS:
                response.setContentType(JSON_MIMETYPE);
                writer = response.getWriter();
                writer.print(CUSTOMERS);
                writer.flush();
                break ;
            default:
                break ;
        }
    }
}
