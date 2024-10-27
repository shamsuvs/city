package com.smashplus.cityxplor.service;


import com.smashplus.cityxplor.dto.EntityDTO;
import com.smashplus.cityxplor.dto.ListingTblEntity;
import com.smashplus.cityxplor.dto.ProcessedEntityDTO;
import com.smashplus.cityxplor.repository.EntityObjDAO;
import com.smashplus.cityxplor.repository.ListingTblEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EntityObjService {


   @Autowired
   EntityObjDAO entityObjDao;

   @Autowired
   ListingTblEntityRepository listingTblEntityRepository;


    public List<EntityDTO> findAll() {
        try {
            //return commonDAO.getEntityManager().createQuery("select c from EntityDTO c", EntityDTO.class).getResultList();
           return (List<EntityDTO>) entityObjDao.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<EntityDTO> filterAllEntities(String searchText) {
        try {
            //return commonDAO.getEntityManager().createQuery("select c from EntityDTO c", EntityDTO.class).getResultList();
            return (List<EntityDTO>) entityObjDao.findAllByNameContainingIgnoreCase(searchText);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public EntityDTO save(EntityDTO entityDTO) {
       try {
           entityObjDao.save(entityDTO);
       }catch(Exception e){
           e.printStackTrace();
       }
       return null;
    }

    public EntityDTO findObj(Long id) {
        EntityDTO entityDTO =null;
        try{
             entityDTO = entityObjDao.findByEntId(id.intValue());
        }catch (Exception e){
            e.printStackTrace();
        }

        return entityDTO;
    }

    public ProcessedEntityDTO findObjProcessed(Long id) {
        ProcessedEntityDTO entityDTO =new ProcessedEntityDTO();
        try{
            BeanUtils.copyProperties(entityObjDao.findByEntId(id.intValue()),entityDTO);
            entityDTO.setFeatureList();
            entityDTO.setTagsList();
            entityDTO.setSpecialities();
        }catch (Exception e){
            e.printStackTrace();
        }

        return entityDTO;
    }

    /*public List<EntityDTO> findAllEntitiesBasedOnCategory(String cat) {
        try {
            return entityObjDao.findAllEntitiesBasedOnCategory(cat);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/


    public void delete(Long id) {
        try {
            EntityDTO entityDTO = entityObjDao.findByEntId(id.intValue());
            entityObjDao.delete(entityDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean findByName(String name) {

        return entityObjDao.findByName(name)!=null?true:false;
    }

    public List<ListingTblEntity> getAllListPostObjs() {
        List<ListingTblEntity> listingTblEntities = (List<ListingTblEntity>) listingTblEntityRepository.findAll();
        return listingTblEntities;
    }

    public List<ListingTblEntity> getAllListPosts(String category) {
        try {
            List<ListingTblEntity> listingTblEntities = listingTblEntityRepository.findAllByCategory(category);
            return listingTblEntities;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ListingTblEntity> getAllListPostObjsOnCategory(String category) {
        List<ListingTblEntity> listingTblEntities = (List<ListingTblEntity>) listingTblEntityRepository.findAllByCategory(category);
        return listingTblEntities;
    }

    public List<ListingTblEntity> getAllListPostObjsOnSection(String section) {
        List<ListingTblEntity> listingTblEntities = (List<ListingTblEntity>) listingTblEntityRepository.findAllByListSection(section);
        return listingTblEntities;
    }
    public int updateCount(String id, boolean isIncrease) {
        EntityDTO entity= entityObjDao.findByEntId(Integer.parseInt(id));
        entity.setLikes(entity.getLikes()+(isIncrease?+1:-1));
        entityObjDao.save(entity);
        return entity.getLikes();
    }


}
