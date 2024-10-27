package com.smashplus.cityxplor.service;

import com.smashplus.cityxplor.domain.InterviewQtnListingTblEntity;
import com.smashplus.cityxplor.repository.InterviewQtnListingTblRepository;
import com.smashplus.cityxplor.util.ValConditions;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class InterviewQtnListingTblService {
    final
    InterviewQtnListingTblRepository interviewQtnListingTblRepository;

    public InterviewQtnListingTblService(InterviewQtnListingTblRepository interviewQtnListingTblRepository) {
        this.interviewQtnListingTblRepository = interviewQtnListingTblRepository;
    }

    public void getInterviewSeries(String id, Model model, HttpServletRequest servletRequest) {
        model.addAttribute("interview",interviewQtnListingTblRepository.findByIdAndPublishTrue(id));
    }

    public InterviewQtnListingTblEntity getInterviewSeriesFiltered(String technology, String targetExp, Model model) {
        String subCat = technology;
        InterviewQtnListingTblEntity interviewQtnListingTblEntity = interviewQtnListingTblRepository.findByTechnologyLikeAndTargetExperienceLikeAndPublishTrue("%"+technology+"%","%"+targetExp+"%");
        if(ValConditions.isEmpty(interviewQtnListingTblEntity)){
            interviewQtnListingTblEntity = interviewQtnListingTblRepository.findBySubcategoryAndTargetExperienceLikeAndPublishTrue(subCat, "%"+targetExp+"%");
        }
        return interviewQtnListingTblEntity;
    }

    public List<InterviewQtnListingTblEntity> getAllInterviewSeries() {
        try {
            return interviewQtnListingTblRepository.findByPublishTrue();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
