package com.example.poster_final_project.service.dto.concerts;

import com.example.poster_final_project.dao.enums.EventStatus;
import com.example.poster_final_project.dao.enums.EventType;

import java.util.UUID;

public class EventConcertToRead {

    private UUID uuid;

    private Long dtCreate;

    private Long dtUpdate;

    private String title;

    private String description;

    private Integer dtEvent;

    private Integer dtEndOfSale;

    private EventType type;

    private EventStatus status;

    private UUID category;

    protected EventConcertToRead(){}

    public EventConcertToRead(UUID uuid, Long dtCreate, Long dtUpdate, String title,
                              String description, Integer dtEvent, Integer dtEndOfSale,
                              EventType type, EventStatus status, UUID category) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.category = category;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Long dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Long getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Long dtUpdate) {
        this.dtUpdate = dtUpdate;
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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }

    public static class Builder {

        private UUID uuid;

        private Long dtCreate;

        private Long dtUpdate;

        private String title;

        private String description;

        private Integer dtEvent;

        private Integer dtEndOfSale;

        private EventType type;

        private EventStatus status;

        private UUID category;

        public Builder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setDtCreate(Long dtCreate) {
            this.dtCreate = dtCreate;
            return this;
        }

        public Builder setDtUpdate(Long dtUpdate) {
            this.dtUpdate = dtUpdate;
            return this;
        }

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

        public Builder setType(EventType type) {
            this.type = type;
            return this;
        }

        public Builder setStatus(EventStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCategory(UUID category) {
            this.category = category;
            return this;
        }

        public static Builder create() {
            return new Builder();
        }
        public EventConcertToRead build() {
            return new EventConcertToRead(uuid,dtCreate,dtUpdate,title,description,dtEvent,dtEndOfSale,type,status,category);
        }
    }
}
