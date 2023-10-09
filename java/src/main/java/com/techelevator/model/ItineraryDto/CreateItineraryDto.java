package com.techelevator.model.ItineraryDto;

import javax.validation.constraints.NotEmpty;

public class CreateItineraryDto {
    @NotEmpty
    private String date;
    @NotEmpty
    private String name;

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
