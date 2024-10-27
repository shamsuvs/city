package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.dto.ListingTblEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingTblEntityRepository extends JpaRepository<ListingTblEntity, String> {
    @Cacheable(value="list",key="#category")
    List<ListingTblEntity> findAllByCategory(String category);
    List<ListingTblEntity> findAllByListSection(String section);

}
