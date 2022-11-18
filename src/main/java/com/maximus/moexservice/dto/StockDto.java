package com.maximus.moexservice.dto;

import com.maximus.moexservice.model.Stock;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;



@Value //TODO что это??
public class StockDto {
    List<Stock> stockList;
}
