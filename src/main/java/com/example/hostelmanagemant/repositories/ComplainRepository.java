package com.example.hostelmanagemant.repositories;

import com.example.hostelmanagemant.models.Complain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ComplainRepository extends CrudRepository<Complain, Long> {

    @Query( value = "select count(c) from Complain c where c.complainStatus ='APPROVED' or c.complainStatus ='REJECTED' ")
    Long findAllResolvedComplains();
}
