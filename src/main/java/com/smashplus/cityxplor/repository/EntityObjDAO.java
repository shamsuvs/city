package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.dto.EntityDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntityObjDAO extends CrudRepository<EntityDTO, Long> {


    List<EntityDTO> findAllByEntId(int id);
    List<EntityDTO> findAllByNameContainingIgnoreCase(String search);
    EntityDTO findByEntId(int id);
    EntityDTO findByName(String name);

    List<EntityDTO> findAllByCategory(String category);

    List<EntityDTO> findByCityOrderByNameAsc(String city);



}
