package com.surbhikalra.healinghearts.service;

import com.surbhikalra.healinghearts.model.Merchandise;
import com.surbhikalra.healinghearts.repository.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseService {

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    public List<Merchandise> getAllMerchandise() {
        return merchandiseRepository.findAll();
    }

    public Optional<Merchandise> getMerchandiseById(Long id) {
        return merchandiseRepository.findById(id);
    }


}
