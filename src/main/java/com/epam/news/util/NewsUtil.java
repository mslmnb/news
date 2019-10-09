package com.epam.news.util;

import com.epam.news.model.News;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class NewsUtil {
    public static final List<News> NEWS = Arrays.asList(
            new News(LocalDate.of(2019, 9,15), "Имя новости1", "Содержание новости1"),
            new News(LocalDate.of(2019, 9,20), "Имя новости2", "Содержание новости2"),
            new News(LocalDate.of(2019,10, 5), "Имя новости3", "Содержание новости3")
    );
}
