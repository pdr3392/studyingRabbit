package com.ms.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


public class EmailDto {

    @Getter
    @Setter
    private UUID userId;

    @Getter
    @Setter
    private String emailTo;

    @Getter
    @Setter
    private String subject;

    @Getter
    @Setter
    private String text;
}
