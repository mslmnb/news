package com.epam.news.util;

import com.epam.news.model.New;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class NewsUtil {
    public static final List<New> news = Arrays.asList(
            new New(LocalDate.of(2019, 9,15), "Имя новости1", "Содержание новости1"),
            new New(LocalDate.of(2019, 9,20), "Имя новости2", "Содержание новости2"),
            new New(LocalDate.of(2019,10, 5), "Имя новости3", "Содержание новости3")
    );
}
