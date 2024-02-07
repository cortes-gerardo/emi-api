package com.gerardocortes.emiapi.repository;

import com.gerardocortes.emiapi.repository.entity.Emi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmiRepository extends CrudRepository<Emi, Long> {
}
