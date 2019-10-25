package com.eob.reconciliation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eob.reconciliation.model.EobRec;

@Repository
public interface EobRecRepo extends JpaRepository<EobRec, Integer> {

}
