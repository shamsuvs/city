package com.smashplus.cityxplor.admin.service;

import com.smashplus.cityxplor.domain.IntListingQtnMappingEntity;
import com.smashplus.cityxplor.domain.IntListingQtnMappingEntityRepository;
import com.smashplus.cityxplor.domain.InterviewQtnListingTblEntity;
import com.smashplus.cityxplor.domain.InterviewQuestionTblEntity;
import com.smashplus.cityxplor.repository.InterviewQtnListingTblRepository;
import com.smashplus.cityxplor.repository.InterviewQuestionTblRepository;
import com.smashplus.cityxplor.util.ValConditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class IQMService {
    private final InterviewQuestionTblRepository interviewQuestionTblRepository;
    private final InterviewQtnListingTblRepository listingTblRepository;
    private final IntListingQtnMappingEntityRepository mappingEntityRepository;


    public IQMService(InterviewQuestionTblRepository interviewQuestionTblRepository, InterviewQtnListingTblRepository listingTblRepository, IntListingQtnMappingEntityRepository mappingEntityRepository) {
        this.interviewQuestionTblRepository = interviewQuestionTblRepository;
        this.listingTblRepository = listingTblRepository;
        this.mappingEntityRepository = mappingEntityRepository;
    }

      /*

    public void saveModule(TutorialModuleTblEntity moduleTblEntity) {
        if (ValConditions.isEmpty(moduleTblEntity.getId())) {
            Random randomno = new Random();
            int a = randomno.nextInt(20000);
            moduleTblEntity.setId("mod" + a);
        }
        tutorialModuleTblEntityRepository.save(moduleTblEntity);
    }


    public List<TutorialStepsTblEntityDto> getSteps(String title, String type, String tutId) {
        List<TutorialStepsTblEntity> tutorialStepsTblEntities = null;
        if (!ValConditions.isEmpty(title) && ValConditions.isNotEmpty(type)) {
            tutorialStepsTblEntities = tutorialStepsTblEntityRepository.findByTitleAndContentType(title, type);
        } else if (!ValConditions.isEmpty(title)) {
            tutorialStepsTblEntities = tutorialStepsTblEntityRepository.findByTitle(title);
        } else {
            tutorialStepsTblEntities = tutorialStepsTblEntityRepository.findAll();
        }
        List<TutorialStepsTblEntityDto> list = new ArrayList<>();

        for (TutorialStepsTblEntity tutorialStepsTblEntity : tutorialStepsTblEntities) {
            TutorialStepsTblEntityDto chapterDto = new TutorialStepsTblEntityDto();
            chapterDto.setId(tutorialStepsTblEntity.getId());
            chapterDto.setTitle(tutorialStepsTblEntity.getTitle());
            chapterDto.setContentType(tutorialStepsTblEntity.getContentType());
            chapterDto.setAddedToCourse(false);
            for(TutStepsModuleMappingTblEntity tutStepsModuleMappingTblEntity: tutorialStepsTblEntity.getTutStepsModuleMappingTblsById()) {
                if(tutStepsModuleMappingTblEntity.getTutId().equalsIgnoreCase(tutId)) {
                    chapterDto.setAddedToCourse(true);
                    break;
                }
            }
            list.add(chapterDto);
        }
        return list;
    }

    public void saveMap(List<TutStepsModuleMappingTblEntity> map) {
        repository.saveAll(map);
    }

    public void saveTutorial(TutorialsTableEntity tutorialsTableEntity) {
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        if (ValConditions.isEmpty(tutorialsTableEntity.getId())) {
            Random randomno = new Random();
            int a = randomno.nextInt(20000);
            tutorialsTableEntity.setId("tut" + a);
        } else {
            tutorialsTableEntity.setUpdateDate(sqlDate);
        }

        tutorialsTableEntityRepository.save(tutorialsTableEntity);
    }

    public void saveStep(InterviewQuestionTblEntity iq) {

        tutorialStepsTblEntityRepository.save(chapter);
    }



    public List<TutorialsTableEntity> getAll() {
        return tutorialsTableEntityRepository.findAll();
    }

    public List<TutorialStepsTblEntity> getAllSteps() {
        return tutorialStepsTblEntityRepository.findAll();
    }

    public void deleteStep(String id) {
        TutorialStepsTblEntity chapter = tutorialStepsTblEntityRepository.findById(Integer.valueOf(id)).get();
        tutorialStepsTblEntityRepository.delete(chapter);
    }

    public void deleteChapterFromModule(String moduleId, String stid) {
        TutStepsModuleMappingTblEntity map = repository.findByModuleIdAndStepId(moduleId, Integer.parseInt(stid));
        repository.delete(map);
    }

    public void deleteModule(String moduleId) {
        //first delete all chapters on that module
        repository.deleteAll(repository.findAllByModuleId(moduleId));
        //then del module
        if (tutorialModuleTblEntityRepository.findById(moduleId).isPresent()) {
            TutorialModuleTblEntity moduleTblEntity = tutorialModuleTblEntityRepository.findById(moduleId).get();
            tutorialModuleTblEntityRepository.delete(moduleTblEntity);
        }
    }*/
//iq
    public void save(InterviewQuestionTblEntity interview) {
        interviewQuestionTblRepository.save(interview);
    }
    public InterviewQuestionTblEntity getIQ(int id) {

        return interviewQuestionTblRepository.findById(id).get();
    }

    public List<InterviewQuestionTblEntity> getAll() {
        return  interviewQuestionTblRepository.findAll();
    }

    public void saveList(InterviewQtnListingTblEntity interviewQtnListingTblEntity) {
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        if (ValConditions.isEmpty(interviewQtnListingTblEntity.getId())) {
            Random randomno = new Random();
            int a = randomno.nextInt(20000);
            interviewQtnListingTblEntity.setId("int" + a);
        }
        interviewQtnListingTblEntity.setUpdateDate(sqlDate);
        interviewQtnListingTblEntity.setAuthor("shamsudeen");


        listingTblRepository.save(interviewQtnListingTblEntity);

    }
    public void getList(String id, Model model) {
        model.addAttribute("iqsList", listingTblRepository.findById(id).get());
    }

    public List<InterviewQuestionTblEntity> getQuestionList(String category, String subCategory) {
        return interviewQuestionTblRepository.findAllByCategoryAndSubcategory(category, subCategory);
    }
    public List<InterviewQuestionTblEntity> getQuestionListOnListId(String lid) {
        return interviewQuestionTblRepository.findByIntListingQtnMappingsById_IntListId(lid);
    }

    public void saveMapping(IntListingQtnMappingEntity intListingQtnMapping) {
        mappingEntityRepository.save(intListingQtnMapping);
    }

    public void deleteQtnMapping(String listId, String questionId) {
        mappingEntityRepository.delete(mappingEntityRepository.findByIntListIdAndQtnId(listId, Integer.valueOf(questionId)));
    }
}
