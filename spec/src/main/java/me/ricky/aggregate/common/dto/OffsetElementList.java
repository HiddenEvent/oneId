package me.ricky.aggregate.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OffsetElementList<T> implements Iterable<T>, Serializable {
    private List<T> results;
    private int totalCount;

    protected OffsetElementList() {
        this.results = new ArrayList();
    }

    public OffsetElementList(int totalCount) {
        this();
        this.totalCount = totalCount;
    }

    public OffsetElementList(List<T> results, int totalCount) {
        this.results = results;
        this.totalCount = totalCount;
    }

    public Iterator<T> iterator() {
        return this.results.iterator();
    }

    public int size() {
        return this.results != null ? this.results.size() : 0;
    }

    public T get(int index) {
        return this.results != null ? this.results.get(index) : null;
    }

    public void add(T result) {
        this.results.add(result);
    }

    public boolean isEmpty() {
        return this.results == null || this.results.isEmpty();
    }

    public List<T> getResults() {
        return this.results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}