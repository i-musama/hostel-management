package com.example.hostelmanagemant.services.jpaservicesimpl;

import com.example.hostelmanagemant.models.Complain;
import com.example.hostelmanagemant.repositories.ComplainRepository;
import com.example.hostelmanagemant.services.ComplainService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ComplainServiceImpl implements ComplainService {

    private final ComplainRepository complainRepository;

    public ComplainServiceImpl(ComplainRepository complainRepository) {
        this.complainRepository = complainRepository;
    }

    @Override
    public Complain findById(Long aLong) {
        return complainRepository.findById(aLong).orElse(null);
    }

    @Override
    public Complain save(Complain object) {
        return complainRepository.save(object);
    }

    @Override
    public Set<Complain> findAll() {
        Set<Complain> complains = new HashSet<>();
        complainRepository.findAll().forEach(complains::add);
        return complains;
    }

    @Override
    public void deleteById(Long aLong) {
        complainRepository.deleteById(aLong);

    }

    @Override
    public void delete(Complain obj) {
        complainRepository.delete(obj);
    }

    @Override
    public Long findAllResolvedComplains() {
        return complainRepository.findAllResolvedComplains();
    }
}
