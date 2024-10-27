package com.smashplus.cityxplor.repository;

import com.smashplus.cityxplor.domain.EstablishmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstablishmentEntityRepository extends JpaRepository<EstablishmentEntity, Integer> {
    List<EstablishmentEntity> findByCityOrderByEstNameAsc(Integer city);
    List<EstablishmentEntity> findByCityAndPublishOrderByEstNameAsc(Integer city, boolean publish);

    List<EstablishmentEntity> findTop4ByCityAndPublishOrderByLikesDesc(Integer city, boolean publish);

    List<EstablishmentEntity> findByCityAndCategoryAndPublishOrderByEstNameAsc(Integer city, String category,boolean publish);

    List<EstablishmentEntity> findByCityAndPublishAndTagsContainsOrderByEstNameAsc(Integer city, boolean publish, String tags);

    List<EstablishmentEntity> findByCityAndSubCategoryAndPublishOrderByEstNameAsc(Integer city, String scat,boolean publish);

}
