package com.eduguide.eduguide.dto;

import java.util.List;

public class StreamDTO {

    private Long id;
    private String name;
    private String description;
    private List<FieldDTO> fields;

    public StreamDTO() {
    }

    public StreamDTO(Long id, String name, String description, List<FieldDTO> fields) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fields = fields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FieldDTO> getFields() {
        return fields;
    }

    public void setFields(List<FieldDTO> fields) {
        this.fields = fields;
    }
}
