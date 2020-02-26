package com.java.productManagement.service.serviceImpl;

import com.java.productManagement.dao.MerchantDao;
import com.java.productManagement.dto.MerchantDTO;
import com.java.productManagement.entities.Merchant;
import com.java.productManagement.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantDao merchantDao;


    @Override
    public void save(Merchant merchant) throws Exception {
        merchantDao.save(merchant);
    }

    @Override
    public void saveAll(List<MerchantDTO> merchantDTOList) throws Exception {
        List<Merchant> merchantList = new ArrayList<>();
        for (MerchantDTO merchantDTO : merchantDTOList){
            Merchant merchant = new Merchant();

            merchant.setId(merchantDTO.getId());
            merchant.setLabel(merchantDTO.getLabel());
            merchantList.add(merchant);
            merchantDao.saveAll(merchantList);
        }
    }
}
