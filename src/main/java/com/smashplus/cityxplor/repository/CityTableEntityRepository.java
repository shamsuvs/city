package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.CityTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityTableEntityRepository extends JpaRepository<CityTableEntity, Integer> {
    CityTableEntity findByCityCode(String cityCode);

}
