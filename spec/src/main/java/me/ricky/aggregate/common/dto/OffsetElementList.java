package me.ricky.aggregate.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Schema(description = "페이징 결과 정보")
public class OffsetElementList<T> implements Iterable<T>, Serializable {
    @Schema(description = "결과 목록")
    private List<T> results;
    @Schema(description = "전체 건수")
    private long totalCount;

    protected OffsetElementList() {
        this.results = new ArrayList();
    }

    public OffsetElementList(long totalCount) {
        this();
        this.totalCount = totalCount;
    }

    public OffsetElementList(List<T> results, long totalCount) {
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
    @Schema(description = "결과 목록이 비어있는지 여부")
    public boolean isEmpty() {
        return this.results == null || this.results.isEmpty();
    }

    public List<T> getResults() {
        return this.results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}