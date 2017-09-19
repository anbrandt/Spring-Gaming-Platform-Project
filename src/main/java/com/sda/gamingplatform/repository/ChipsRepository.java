package com.sda.gamingplatform.repository;

import com.sda.gamingplatform.entities.Chips;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;


public interface ChipsRepository extends CrudRepository<Chips, Long> {

	 void save(long id, BigInteger chips);
}
