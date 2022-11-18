package com.maximus.moexservice.moexclient;


import com.maximus.moexservice.dto.BondDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "corporatebonds", url = "${moex.bonds.corporate.url}", configuration = FeignConfig.class)
public interface CorporateBondService {

    @RequestMapping(method = RequestMethod.GET)
    String getBondsFromMoex();
}
