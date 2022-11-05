package com.samuel.vendas.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Error {

    private int status;
    private LocalDateTime dateTime;
    private String title;

    private List<Campo> campos;

    @Getter
    @AllArgsConstructor
    public static class Campo{
        private String name;
        private String msg;
    }
}
