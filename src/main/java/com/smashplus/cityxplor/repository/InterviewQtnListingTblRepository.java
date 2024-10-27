package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.InterviewQtnListingTblEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 
 */
public interface InterviewQtnListingTblRepository extends JpaRepository<InterviewQtnListingTblEntity, String> {

    List<InterviewQtnListingTblEntity> findByPublishTrue();

    InterviewQtnListingTblEntity findByIdAndPublishTrue(String id);


    InterviewQtnListingTblEntity findByTechnologyLikeAndTargetExperienceLikeAndPublishTrue(String technology, String targetExp);

    InterviewQtnListingTblEntity findBySubcategoryAndTargetExperienceLikeAndPublishTrue(String subCat, String targetExp);
}
