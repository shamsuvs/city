package com.smashplus.cityxplor.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IntListingQtnMappingEntityRepository extends JpaRepository<IntListingQtnMappingEntity, Integer>{
    IntListingQtnMappingEntity findByIntListIdAndQtnId(String intListId, Integer qtnId);

}
