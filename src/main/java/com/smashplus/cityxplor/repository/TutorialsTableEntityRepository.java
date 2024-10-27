package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.TutorialsTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialsTableEntityRepository extends JpaRepository<TutorialsTableEntity, String> {
    List<TutorialsTableEntity> findAllByPublishEquals(boolean isPublish);
}
