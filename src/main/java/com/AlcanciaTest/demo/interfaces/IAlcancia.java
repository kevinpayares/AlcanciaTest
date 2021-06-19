package com.AlcanciaTest.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AlcanciaTest.demo.modelo.Alcancia;

@Repository
public interface IAlcancia extends CrudRepository<Alcancia, Integer>{

}
