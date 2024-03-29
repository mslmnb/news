package com.epam.news.model;

import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "news")
public class News extends BaseEntity {
    private static final String ID_KEY = "id";
    private static final String DATE_KEY = "date";
    private static final String TITLE_KEY = "title";
    private static final String BRIEF_KEY = "brief";
    private static final String CHECKED_KEY = "checked";

    @Column(name = "DATETIME", nullable = false, columnDefinition = "default SYSDATE")
    private LocalDate date;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "BRIEF", nullable = false)
    private String brief;
    @Column(name = "CHECKED")
    private boolean checked;

    public News() {
    }

    public News(LocalDate date, String title, String brief) {
        this.date = date;
        this.title = title;
        this.brief = brief;
        this.checked = false;
    }

    public News(Integer id, LocalDate date, String title, String brief, String checked) {
        setId(id);
        this.date = date;
        this.title = title;
        this.brief = brief;
        if (checked.equalsIgnoreCase("T")) {
            this.checked = true;
        } else {
            this.checked = false;
        }
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

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getJsonString() {
        JSONObject newsJSONobj = new JSONObject();
        newsJSONobj.put(ID_KEY, this.getId());
        newsJSONobj.put(DATE_KEY, this.getDate());
        newsJSONobj.put(TITLE_KEY, this.getTitle());
        newsJSONobj.put(BRIEF_KEY, this.getBrief());
        newsJSONobj.put(CHECKED_KEY, this.isChecked());
        return newsJSONobj.toString();
    }
}
