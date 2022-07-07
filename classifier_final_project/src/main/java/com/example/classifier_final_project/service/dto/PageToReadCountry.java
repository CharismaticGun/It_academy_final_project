package com.example.classifier_final_project.service.dto;

import com.example.classifier_final_project.service.dto.api.IPage;
import com.example.classifier_final_project.service.dto.countries.CountryToRead;

import java.util.List;

public class PageToReadCountry implements IPage<CountryToRead> {

    private int number;

    private int size;

    private int totalPages;

    private long totalElements;

    private boolean first;

    private int numberOfElements;

    private boolean last;

    private List<CountryToRead> content;

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public boolean isLast() {
        return last;
    }

    @Override
    public List<CountryToRead> getContent() {
        return content;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setContent(List<CountryToRead> content) {
        this.content = content;
    }
}
