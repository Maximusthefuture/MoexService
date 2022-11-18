package com.maximus.moexservice.controller;

import com.maximus.moexservice.dto.StockDto;
import com.maximus.moexservice.dto.TickersDto;
import com.maximus.moexservice.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bonds")
public class MoexBondController {
    private final BondService bondService;

    @PostMapping("/getBondsByTickers")
    public StockDto getBondsFromMoex(@RequestBody TickersDto tickersDto) {
        return bondService.getBondsFromMoex(tickersDto);
    }


}
