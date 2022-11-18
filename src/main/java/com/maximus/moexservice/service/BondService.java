package com.maximus.moexservice.service;

import com.maximus.moexservice.dto.BondDto;
import com.maximus.moexservice.dto.StockDto;
import com.maximus.moexservice.dto.TickersDto;
import com.maximus.moexservice.exception.LimitRequestException;
import com.maximus.moexservice.model.Currency;
import com.maximus.moexservice.model.Stock;
import com.maximus.moexservice.moexclient.CorporateBondService;
import com.maximus.moexservice.moexclient.GovBondService;
import com.maximus.moexservice.parser.Parser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BondService {
    private final CorporateBondService corporateBondService;
    private final GovBondService govBondService;
    private final Parser parser;


    public StockDto getBondsFromMoex(TickersDto tickersDto) {

        List<BondDto> allBond = new ArrayList<>();
        allBond.addAll(getCorporateBonds());
        allBond.addAll(getGovermentBonds());

        List<BondDto> resultBonds =  allBond.stream()
                .filter(b -> tickersDto.getTickers().contains(b.getTicker()))
                .collect(Collectors.toList());

        List<Stock> stockList = resultBonds.stream()
                .map(bondDto -> {
                  return Stock.builder()
                          .ticker(bondDto.getTicker())
                          .name(bondDto.getName())
                          .figi(bondDto.getTicker())
                          .type("Bond")
                          .currency(Currency.RUB)
                          .source("Moex")
                          .build();
                })
                .collect(Collectors.toList());
        return new StockDto(stockList);
    }


    private List<BondDto> getCorporateBonds() {
        log.info("Getting corporate bonds from Moex");
        String xmlFromMoex = corporateBondService.getBondsFromMoex();
        List<BondDto> bondDtos = parser.parse(xmlFromMoex);
        if (bondDtos.isEmpty()) {
            throw new LimitRequestException("Moex doesnt answer");
        }
        return bondDtos;
    }

    private List<BondDto> getGovermentBonds() {
        log.info("Getting goverment bonds from Moex");
        String xmlFromMoex = govBondService.getBondsFromMoex();
        List<BondDto> bondDtos = parser.parse(xmlFromMoex);
        if (bondDtos.isEmpty()) {
            throw new LimitRequestException("Moex doesnt answer");
        }
        return bondDtos;
    }
}
