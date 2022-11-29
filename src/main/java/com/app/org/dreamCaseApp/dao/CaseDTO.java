package com.app.org.dreamCaseApp.dao;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CaseDTO {

    private Long caseId;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private String title;
    private String description;
}
