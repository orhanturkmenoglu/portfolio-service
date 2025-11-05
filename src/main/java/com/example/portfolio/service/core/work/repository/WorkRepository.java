package com.example.portfolio.service.core.work.repository;

import com.example.portfolio.service.core.work.model.Work;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends MongoRepository<Work,String> {
}
