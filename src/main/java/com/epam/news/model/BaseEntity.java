package com.epam.news.model;

public class BaseEntity {
    private Integer id;

    public BaseEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return id==null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        BaseEntity that = (BaseEntity) obj;
        return (this.getId() != null && this.getId().equals(that.getId()));
    }

    @Override
    public int hashCode() {
        return this.getId() == null ? 0 : this.getId();
    }

}
