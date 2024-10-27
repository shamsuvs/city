package com.smashplus.cityxplor.slaitz.fcd;

import com.smashplus.cityxplor.slaitz.dto.StoryDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Component
public class StoryFacade {
    public void getDeviceType(Model model, HttpServletRequest request) {
        boolean isMobile = false;
        String usAg = request.getHeader("User-Agent").toUpperCase();
        if(usAg.indexOf("MOBILE") != -1||usAg.indexOf("SMARTPHONE") != -1) {
            isMobile=true;
        }
        model.addAttribute("isMobile",isMobile);
    }

    public List<String> generateSmallParts(StoryDTO storyDTO) {
        String[] smallParts = storyDTO.getStory().split(storyDTO.getSplitchar());
        return Arrays.asList(smallParts);

    }
}
