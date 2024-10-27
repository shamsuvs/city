package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.SpecialityTblEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityTblEntityRepository extends JpaRepository<SpecialityTblEntity, Integer> {
    List<SpecialityTblEntity> findBySpecialityAndEstablishmentByEstabId_City(String speciality, Integer city);

}
