package com.java.productManagement.service;


import com.java.productManagement.dto.MerchantDTO;
import com.java.productManagement.entities.Merchant;

import java.util.List;

public interface MerchantService {

    void save(Merchant merchant) throws Exception;
    void saveAll(List<MerchantDTO>merchantDTOList) throws Exception;
}
