package com.example.hostelmanagemant.services.jpaservicesimpl;

import com.example.hostelmanagemant.models.Warden;
import com.example.hostelmanagemant.repositories.WardenRepository;
import com.example.hostelmanagemant.services.WardenService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WardenServiceImpl implements WardenService {

    private final WardenRepository wardenRepository;

    public WardenServiceImpl(WardenRepository wardenRepository) {
        this.wardenRepository = wardenRepository;
    }

    @Override
    public Warden findById(Long aLong) {
        return wardenRepository.findById(aLong).orElse(null);
    }

    @Override
    public Warden save(Warden object) {
        return wardenRepository.save(object);
    }

    @Override
    public Set<Warden> findAll() {
        Set<Warden> wardens = new HashSet<>();
        wardenRepository.findAll().forEach(wardens::add);
        return wardens;
    }

    @Override
    public void deleteById(Long aLong) {
        wardenRepository.deleteById(aLong);
    }

    @Override
    public void delete(Warden obj) {
        wardenRepository.delete(obj);
    }
}
