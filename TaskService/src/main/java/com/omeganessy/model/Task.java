package com.omeganessy.model;

import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;

@Data
public class Task {
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    private boolean isActive;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
