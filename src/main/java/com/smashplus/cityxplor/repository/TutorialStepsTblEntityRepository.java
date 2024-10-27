package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.TutorialStepsTblEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialStepsTblEntityRepository extends JpaRepository<TutorialStepsTblEntity, Integer> {
    List<TutorialStepsTblEntity> findByTitle(String title);

    List<TutorialStepsTblEntity> findByTitleAndContentType(String title, String type);
}
