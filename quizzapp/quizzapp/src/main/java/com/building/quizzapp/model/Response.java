package com.building.quizzapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private Integer questionId;
    private String response;

    //TODO: why lombok not working
    // public String getResponse() {
        // return response;
    // }
}
