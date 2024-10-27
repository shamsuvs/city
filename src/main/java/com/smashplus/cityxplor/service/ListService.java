package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.domain.CityTableEntity;
import com.smashplus.cityxplor.dto.EntityDTO;
import com.smashplus.cityxplor.dto.ListCuratorDTO;
import com.smashplus.cityxplor.repository.CityTableEntityRepository;
import com.smashplus.cityxplor.repository.EntityObjDAO;
import com.smashplus.cityxplor.repository.EstablishmentEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
   @Autowired
   EntityObjService entityObjService;
   @Autowired
   EntityObjDAO entityObjDAO;

    @Autowired
    CityRestService cityRestService;

   final EstablishmentEntityRepository entityRepository;
   final CityTableEntityRepository cityTableEntityRepository;

    public ListService(EstablishmentEntityRepository entityRepository, CityTableEntityRepository cityTableEntityRepository) {
        this.entityRepository = entityRepository;
        this.cityTableEntityRepository = cityTableEntityRepository;
    }

    public List<EntityDTO> findAllEntities(String targetCat) {
        List<EntityDTO> entityDTO = entityObjService.filterAllEntities(targetCat);
        return entityDTO;
    }

    public EntityDTO findEntity(String id) {
        try {
            EntityDTO entityDTO = entityObjService.findObj(Long.valueOf(id));
            return entityDTO;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<EntityDTO> findEntities(String city) {
        try {
            List<EntityDTO> entityDTO = entityObjDAO.findByCityOrderByNameAsc(city);
            return entityDTO;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ListCuratorDTO getListDetails(String key) {
        try {
            String restUrl = "list_curator";
            String queryParam = "{\"key\":\""+key+"\"}";
            List<ListCuratorDTO> items = cityRestService.getResponseObj(restUrl, queryParam).items;
            if(!items.isEmpty())
            return items.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public CityTableEntity findCity(String city) {
        return cityTableEntityRepository.findByCityCode(city);
    }
}
