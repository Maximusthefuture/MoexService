package com.maximus.moexservice.exception;

import lombok.Value;

@Value
public class LimitRequestException extends RuntimeException {
    String name;
}
