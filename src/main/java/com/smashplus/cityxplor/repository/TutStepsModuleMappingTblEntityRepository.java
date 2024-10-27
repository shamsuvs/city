package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.TutStepsModuleMappingTblEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutStepsModuleMappingTblEntityRepository extends JpaRepository<TutStepsModuleMappingTblEntity, Integer> {
    TutStepsModuleMappingTblEntity findByModuleIdAndStepId(String moduleId, int stid);

    List<TutStepsModuleMappingTblEntity> findAllByModuleId(String moduleId);
}
