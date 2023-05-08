package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.MemeModel;

@Repository
public interface MemeRepository extends CrudRepository<MemeModel, Long>  {



}
