package com.app.org.dreamCaseApp.repository;


import com.app.org.dreamCaseApp.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CaseRepository extends CrudRepository<Case,Long> {
}
