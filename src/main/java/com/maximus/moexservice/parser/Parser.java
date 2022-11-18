package com.maximus.moexservice.parser;

import com.maximus.moexservice.dto.BondDto;

import java.util.List;

public interface Parser {
    List<BondDto> parse(String ratesAsString);
}
