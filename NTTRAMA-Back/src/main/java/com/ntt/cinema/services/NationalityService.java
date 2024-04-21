package com.ntt.cinema.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ntt.cinema.models.Nationality;
import com.ntt.cinema.repositories.NationalityRepository;

import java.util.List;

@Service
@Transactional
public class NationalityService {

    private final NationalityRepository nationalityRepository;

    public NationalityService(NationalityRepository nationalityRepository) {
        this.nationalityRepository = nationalityRepository;
    }

    public List<Nationality> getAllNationalities() {
        return nationalityRepository.findAll();
    }
}
