package com.epam.news.controller;

import com.epam.news.model.News;
import com.epam.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class RootController {
    private static final String JSON_MIMETYPE = "application/json;charset=UTF-8";
    private final NewsService service;

    @Autowired
    public RootController(NewsService service) {
        this.service = service;
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public void root(HttpServletResponse response) throws IOException {
        response.setContentType(JSON_MIMETYPE);
        PrintWriter writer = response.getWriter();
        writer.print(service.getAll());
    }

    @RequestMapping(value="/list/{id}", method = RequestMethod.GET)
    public void get(HttpServletResponse response, @PathVariable ("id") int id) throws IOException {
        response.setContentType(JSON_MIMETYPE);
        PrintWriter writer = response.getWriter();
        writer.print(service.getById(id));
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable ("id") int id) throws IOException {
        service.remove(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody News news) throws IOException {
        service.save(news);
    }


}
