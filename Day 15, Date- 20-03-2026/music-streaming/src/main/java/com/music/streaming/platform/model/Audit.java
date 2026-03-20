package com.music.streaming.platform.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Audit {

    private String crated_by;
    private LocalDateTime created_at;
    private String updated_by;
    private LocalDateTime updated_at;
    private String deleted_by;
    private LocalDateTime deleted_at;
}
