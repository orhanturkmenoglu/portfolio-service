package com.example.portfolio.service.core.about.repository;

import com.example.portfolio.service.core.about.model.About;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends MongoRepository<About, String> {
}
