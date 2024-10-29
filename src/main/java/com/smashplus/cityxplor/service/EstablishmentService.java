package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.domain.EstablishmentEntity;
import com.smashplus.cityxplor.domain.SpecialityTblEntity;
import com.smashplus.cityxplor.dto.EstablishmentDTO;
import com.smashplus.cityxplor.util.ValConditions;
import com.smashplus.cityxplor.repository.EstablishmentEntityRepository;
import com.smashplus.cityxplor.repository.SpecialityTblEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {
    final EstablishmentEntityRepository entityRepository;
    final SpecialityTblEntityRepository specialityTblEntityRepository;

    @Autowired
    CityRestService cityRestService;

    public EstablishmentService(EstablishmentEntityRepository entityRepository, SpecialityTblEntityRepository specialityTblEntityRepository) {
        this.entityRepository = entityRepository;
        this.specialityTblEntityRepository = specialityTblEntityRepository;
    }

    public List<EstablishmentEntity> findEstablishments(int cityId) {
        try {
            List<EstablishmentEntity> establishmentEntities = entityRepository.findByCityOrderByEstNameAsc(cityId);
            return establishmentEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentEntity> findEstablishmentsByFilter(int cityId,String filter,String orderBy) {
        try {
            List<EstablishmentEntity> establishmentEntities = null;
            if(ValConditions.isNotEmpty(orderBy)&&orderBy.equalsIgnoreCase("likes")){
                establishmentEntities = entityRepository.findTop4ByCityAndPublishOrderByLikesDesc(cityId,true);
            }else if(ValConditions.isNotEmpty(orderBy)&&orderBy.equalsIgnoreCase("name")){
                establishmentEntities = entityRepository.findByCityAndPublishOrderByEstNameAsc(cityId,true);
            }else{
                establishmentEntities = entityRepository.findByCityOrderByEstNameAsc(cityId);
            }
            return establishmentEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentEntity> findEstablishmentsPublished(int cityId,String category) {
        try {
            List<EstablishmentEntity> establishmentEntities =null;
            if(!category.equalsIgnoreCase("all")) {
                establishmentEntities = entityRepository.findByCityAndCategoryAndPublishOrderByEstNameAsc(cityId, category, true);
            }else{
                establishmentEntities = entityRepository.findByCityAndPublishOrderByEstNameAsc(cityId, true);
            }
            return establishmentEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentDTO> findEstablishments(String cityId,String category) {
        try {
            List<EstablishmentDTO> establishmentEntities =null;
            if(!category.equalsIgnoreCase("all")) {
                establishmentEntities = cityRestService.findEstablishments(cityId, category);
            }else{
                establishmentEntities = cityRestService.findEstablishments( cityId, "all");
            }
            return establishmentEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentDTO> findListOfEstablishments(String cityId,String category) {
        try {
            List<EstablishmentDTO> establishmentEntities =null;
            if(!category.equalsIgnoreCase("all")) {
                establishmentEntities = cityRestService.findEstablishments(cityId, category);
            }else{
                establishmentEntities = cityRestService.findEstablishments( cityId, "all");
            }
            return establishmentEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentDTO> findListOfEstablishments(String cityId,String category, String sortOrder) {
        try {
            List<EstablishmentDTO> establishmentEntities =null;
            if(ValConditions.isNotEmpty(category) && !category.equalsIgnoreCase("all")) {
                establishmentEntities = cityRestService.findEstablishments(cityId, category, sortOrder);
            }else{
                establishmentEntities = cityRestService.findEstablishments( cityId, "all");
            }
            return establishmentEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public EstablishmentDTO findEstablishmentProfile(String id) {
        try {
            return cityRestService.findEstablishmentProfile(id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentEntity> findEstablishmentsPublishedOnTags(int cityId,String tag) {
        try {
            List<EstablishmentEntity> establishmentEntities = entityRepository.findByCityAndPublishAndTagsContainsOrderByEstNameAsc(cityId,true,tag);
            return establishmentEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<SpecialityTblEntity> findDoctorsOnSpeciality(String specialty, Integer cityCode) {
        try {
            List<SpecialityTblEntity> specialityTblEntities = specialityTblEntityRepository.findBySpecialityAndEstablishmentByEstabId_City(specialty,cityCode);
            return specialityTblEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<EstablishmentEntity> findEstablishmentsPublishedOnSubCategory(int cityId,String subCategory) {
        try {
            List<EstablishmentEntity> establishmentEntities = entityRepository.findByCityAndSubCategoryAndPublishOrderByEstNameAsc(cityId,subCategory, true);
            return establishmentEntities;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public EstablishmentEntity findEstablishment(String id) {
        try {
            EstablishmentEntity establishmentEntity = entityRepository.findById(Integer.valueOf(id)).get();
            return establishmentEntity;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
