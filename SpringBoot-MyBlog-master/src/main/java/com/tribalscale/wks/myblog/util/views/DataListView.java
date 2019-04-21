package com.tribalscale.wks.myblog.util.views;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.Collections;

public class DataListView<T> {

    private final Collection<T> dataViews;

    private DataListView() {
        this.dataViews = Collections.emptyList();
    }

    public DataListView(@Nullable Collection<T> views) {
        this.dataViews = views == null ? Collections.emptyList() : views;
    }

    @JsonProperty(value = "data")
    public Collection<T> getDataViews() {
        return dataViews;
    }
}
