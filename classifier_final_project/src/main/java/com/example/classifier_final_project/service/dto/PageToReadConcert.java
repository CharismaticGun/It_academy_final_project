package com.example.classifier_final_project.service.dto;

import com.example.classifier_final_project.service.dto.api.IPage;
import com.example.classifier_final_project.service.dto.concerts.ConcertToRead;

import java.util.List;

public class PageToReadConcert implements IPage<ConcertToRead> {

    private int number;

    private int size;

    private int totalPages;

    private long totalElements;

    private boolean first;

    private int numberOfElements;

    private boolean last;

    private List<ConcertToRead> content;

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
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setContent(List<ConcertToRead> content) {
        this.content = content;
    }

    @Override
    public List<ConcertToRead> getContent() {
        return content;
    }
}
