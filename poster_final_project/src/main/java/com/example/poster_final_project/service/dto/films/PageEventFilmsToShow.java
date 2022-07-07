package com.example.poster_final_project.service.dto.films;

import com.example.poster_final_project.service.dto.api.IPage;

import java.util.List;

public class PageEventFilmsToShow implements IPage<EventFilmsToRead> {

    private int number;

    private int size;

    private int totalPages;

    private long totalElements;

    private boolean isFirst;

    private int numberOfElements;

    private boolean isLast;

    private List<EventFilmsToRead> content;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public void setContent(List<EventFilmsToRead> content) {
        this.content = content;
    }

    @Override
    public List<EventFilmsToRead> getContent() {
        return content;
    }
}
