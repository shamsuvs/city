package com.smashplus.cityxplor.admin.service;

import com.smashplus.cityxplor.domain.*;
import com.smashplus.cityxplor.dto.InterviewQtnListingTblEntityMapper;
import com.smashplus.cityxplor.repository.TutStepsModuleMappingTblEntityRepository;
import com.smashplus.cityxplor.repository.TutorialModuleTblEntityRepository;
import com.smashplus.cityxplor.repository.TutorialStepsTblEntityRepository;
import com.smashplus.cityxplor.repository.TutorialsTableEntityRepository;
import com.smashplus.cityxplor.util.ValConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ESService {
    private final TutorialsTableEntityRepository tutorialsTableEntityRepository;
    private final TutorialStepsTblEntityRepository tutorialStepsTblEntityRepository;
    private final TutStepsModuleMappingTblEntityRepository repository;
    private final TutorialModuleTblEntityRepository tutorialModuleTblEntityRepository;
    @Autowired
    InterviewQtnListingTblEntityMapper interviewQtnListingTblEntityMapper;
    public ESService(TutorialsTableEntityRepository tutorialsTableEntityRepository, TutorialStepsTblEntityRepository tutorialStepsTblEntityRepository, TutStepsModuleMappingTblEntityRepository repository, TutorialModuleTblEntityRepository tutorialModuleTblEntityRepository) {
        this.tutorialsTableEntityRepository = tutorialsTableEntityRepository;
        this.repository = repository;
        this.tutorialModuleTblEntityRepository = tutorialModuleTblEntityRepository;
        this.tutorialStepsTblEntityRepository = tutorialStepsTblEntityRepository;
    }

    public void getTut(String id, Model model) {
        TutorialsTableEntity obj = null;
        if (tutorialsTableEntityRepository.findById(id).isPresent()) {
            obj = tutorialsTableEntityRepository.findById(id).get();
        }
        model.addAttribute("tutorial", obj);
    }

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

    public void saveStep(TutorialStepsTblEntity chapter) {
        if (chapter.getId() == 0) {
            Random randomno = new Random();
            int a = randomno.nextInt(20000);
            chapter.setId(a);
        }
        tutorialStepsTblEntityRepository.save(chapter);
    }

    public TutorialStepsTblEntity getStep(int id) {
        TutorialStepsTblEntity tutorialStepsTblEntity = null;
        if (tutorialStepsTblEntityRepository.findById(id).isPresent())
            tutorialStepsTblEntity = tutorialStepsTblEntityRepository.findById(id).get();
        return tutorialStepsTblEntity;
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
    }
}
