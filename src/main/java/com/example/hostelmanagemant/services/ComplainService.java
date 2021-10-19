package com.example.hostelmanagemant.services;

import com.example.hostelmanagemant.models.Complain;

public interface ComplainService extends CRUDService<Complain, Long>{
    Long findAllResolvedComplains();
}
