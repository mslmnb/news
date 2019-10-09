package com.epam.news.model;

import java.time.LocalDate;

public class News extends BaseEntity {
    private LocalDate date;
    private String title;
    private String brief;
    private boolean checked;

    public News() {
    }

    public News(LocalDate date, String title, String brief) {
        this.date = date;
        this.title = title;
        this.brief = brief;
        this.checked = false;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getBrief() {
        return brief;
    }

    public boolean isChecked() {
        return checked;
    }
}
