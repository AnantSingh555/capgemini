package com.example.orders.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;

@Getter
@Setter
public class ErrorDTO {
    @JsonFormat(pattern="dd-MMM-yyyy")
    private LocalDate timeStamp;
    private String message;
    private HttpStatusCode status;

    public ErrorDTO(LocalDate timeStamp, String message, HttpStatusCode status) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.status = status;
    }
}
