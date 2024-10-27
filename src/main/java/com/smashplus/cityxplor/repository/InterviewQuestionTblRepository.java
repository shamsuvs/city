package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.InterviewQuestionTblEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewQuestionTblRepository extends JpaRepository<InterviewQuestionTblEntity, Integer>, JpaSpecificationExecutor<InterviewQuestionTblEntity> {
    List<InterviewQuestionTblEntity> findAllByCategoryAndSubcategory(String category, String subcategory);

    @Query("select i from InterviewQuestionTblEntity i inner join i.intListingQtnMappingsById intListingQtnMappingsById " +
            "where intListingQtnMappingsById.intListId = ?1")
    List<InterviewQuestionTblEntity> findByIntListingQtnMappingsById_IntListId(String intListId);




}
