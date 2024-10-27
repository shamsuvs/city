package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.domain.TutStepsModuleMappingTblEntity;
import com.smashplus.cityxplor.domain.TutorialModuleTblEntity;
import com.smashplus.cityxplor.domain.TutorialStepsTblEntity;
import com.smashplus.cityxplor.domain.TutorialsTableEntity;
import com.smashplus.cityxplor.repository.TutorialStepsTblEntityRepository;
import com.smashplus.cityxplor.repository.TutorialsTableEntityRepository;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TutorialService {
    private final TutorialsTableEntityRepository tutorialsTableEntityRepository;
    private final TutorialStepsTblEntityRepository tutorialStepsTblEntityRepository;
    @Autowired
    public TutorialService(TutorialsTableEntityRepository tutorialsTableEntityRepository, TutorialStepsTblEntityRepository tutorialStepsTblEntityRepository) {
        this.tutorialsTableEntityRepository = tutorialsTableEntityRepository;
        this.tutorialStepsTblEntityRepository = tutorialStepsTblEntityRepository;
    }

    //Tutorial
    public List<TutorialsTableEntity> getAllTutorials(String publish) {
        return tutorialsTableEntityRepository.findAllByPublishEquals(Integer.parseInt(publish)==1?true:false);
    }
    public void getTutorial(String id, Model model, HttpServletRequest request) {
        Optional<TutorialsTableEntity> tutorialsTableEntity1 = tutorialsTableEntityRepository.findById(id);
        for(TutorialModuleTblEntity moduleTbl:tutorialsTableEntity1.get().getTutorialModuleTblEntities()){
            for(TutStepsModuleMappingTblEntity steps: moduleTbl.getTutStepsModuleMappingTblsById()){
                if(ValConditions.isNotEmpty(steps.getTutorialStepsTblByStepId().getBlogpostLink())){
                    //Post post = bloggerService.getPostOnId("8396722402836868056", steps.getTutorialStepsTblByStepId().getBlogpostLink(), request);
                    //if(ValConditions.isNotEmpty(post)) {
                      //  steps.getTutorialStepsTblByStepId().setBlogContent(post.getContent());
                    //}
                }
                }
            }

        model.addAttribute("tutorial",tutorialsTableEntity1);
    }

    public Optional<TutorialStepsTblEntity> getStepById(String id) {
        return tutorialStepsTblEntityRepository.findById(Integer.valueOf(id));

    }
}
