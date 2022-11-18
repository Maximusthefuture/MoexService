package com.maximus.moexservice.moexclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "govbonds", url = "${moex.bonds.goverment.url}", configuration = FeignConfig.class)
public interface GovBondService {

    @GetMapping
    String getBondsFromMoex();
}
