package com.example.poster_final_project.dao.entity;




import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "events_concerts",schema = "final_project")
public class EventConcert extends Event {

    private static final long serialVersionUID = 90123987826991238L;

    private String title;

    private String description;

    private Integer dtEvent;

    private Integer dtEndOfSale;

    private UUID category;

    protected EventConcert(){}

    public EventConcert( String title,String description, Integer dtEvent,
                         Integer dtEndOfSale, UUID category) {

        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.category = category;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDtEvent() {
        return dtEvent;
    }

    public void setDtEvent(Integer dtEvent) {
        this.dtEvent = dtEvent;
    }

    public Integer getDtEndOfSale() {
        return dtEndOfSale;
    }

    public void setDtEndOfSale(Integer dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
    }

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }

    public static class Builder {

        private String title;

        private String description;

        private Integer dtEvent;

        private Integer dtEndOfSale;

        private UUID category;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDtEvent(Integer dtEvent) {
            this.dtEvent = dtEvent;
            return this;
        }

        public Builder setDtEndOfSale(Integer dtEndOfSale) {
            this.dtEndOfSale = dtEndOfSale;
            return this;
        }

        public Builder setCategory(UUID category) {
            this.category = category;
            return this;
        }
        public static Builder create() {
            return new Builder();
        }

        public EventConcert build() {
            return new EventConcert(title,description,dtEvent,dtEndOfSale,category);
        }
    }
}
