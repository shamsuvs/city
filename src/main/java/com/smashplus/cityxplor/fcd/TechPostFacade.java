package com.smashplus.cityxplor.fcd;

import com.smashplus.cityxplor.service.TechPostService;
import com.smashplus.cityxplor.dto.TechPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TechPostFacade {
    @Autowired
    TechPostService techPostService;
    public TechPostDTO getQuestion(String qid) {
        return techPostService.getQuestion(qid);
    }
}
