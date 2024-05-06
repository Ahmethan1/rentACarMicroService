package com.turkcell.rentacar.inventoryService.core.utilities.exception.problemDetails;

public class BusinessProblemDetails  extends ProblemDetails{
    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("400");
    }
}
