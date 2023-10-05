package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Options {
    @JsonProperty("language")
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
