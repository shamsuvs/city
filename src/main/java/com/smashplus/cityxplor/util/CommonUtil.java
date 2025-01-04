package com.smashplus.cityxplor.util;

import com.smashplus.cityxplor.controller.RestUrlConstants;
import com.smashplus.cityxplor.dto.EstablishmentCategoryDTO;
import com.smashplus.cityxplor.dto.GenericResponse;
import com.smashplus.cityxplor.service.EstablishmentCategoryService;
import com.smashplus.cityxplor.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommonUtil {
    @Autowired
    EstablishmentService establishmentService;
    public List<EstablishmentCategoryDTO> getCategoryDTO(){
        List<EstablishmentCategoryDTO> list = new ArrayList<>();
        EstablishmentCategoryDTO establishmentCategoryDTO=new EstablishmentCategoryDTO("Hospitals","https://res.cloudinary.com/dw8him6rb/image/upload/v1665039690/city-explorer/hospital.jpg","Best Hospitals","/hospital-in--sulthan-bathery","hospital");
        list.add(establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Hotels","https://res.cloudinary.com/dw8him6rb/image/upload/v1663933000/cld-sample-4.jpg","Best Hotels","/hotels--sb","hotel");
        list.add(establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Textiles"," https://res.cloudinary.com/dw8him6rb/image/upload/v1665039236/city-explorer/shopping.jpg","Best Textiles In Sulthan Bathery","/textiles--sb","textile");
        list.add(establishmentCategoryDTO);


        return list;
    }
    public Map<String, EstablishmentCategoryDTO> getCategoryDTOMapFromRestService(){
        Map<String,EstablishmentCategoryDTO> establishmentCategoryDTOMap = new HashMap<>();
        List<EstablishmentCategoryDTO>  establishmentCategoryDTOS = establishmentService.fetchEstablishmentCategories();
        if(ValConditions.isNotEmpty(establishmentCategoryDTOS)) {
            establishmentCategoryDTOS.stream().forEach(establishmentCategoryDTO -> establishmentCategoryDTOMap.put(establishmentCategoryDTO.getKey(), establishmentCategoryDTO));
        }
        return establishmentCategoryDTOMap;
    }
    public List<EstablishmentCategoryDTO> getCategoryDTOlistFromRestService(){

        List<EstablishmentCategoryDTO>  establishmentCategoryDTOS = establishmentService.fetchEstablishmentCategories();
        return establishmentCategoryDTOS;
    }
    public Map<String, EstablishmentCategoryDTO> getCategoryDTOMap(){
        Map<String,EstablishmentCategoryDTO> establishmentCategoryDTOMap = new HashMap<>();
        EstablishmentCategoryDTO establishmentCategoryDTO=new EstablishmentCategoryDTO("Hospitals","https://res.cloudinary.com/dw8him6rb/image/upload/v1665039690/city-explorer/hospital.jpg","Best Hospitals","/hospital--sb","hospital");
        establishmentCategoryDTOMap.put("hospital",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Hotels","https://res.cloudinary.com/dw8him6rb/image/upload/v1663933000/cld-sample-4.jpg","Best Hotels","/hotels--sb","hotel");
        establishmentCategoryDTOMap.put("hotel",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Textiles","https://res.cloudinary.com/dw8him6rb/image/upload/v1665039236/city-explorer/shopping.jpg","Best Textiles In Sulthan Bathery","/textiles--sb","textile");
        establishmentCategoryDTOMap.put("textile",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Schools","https://res.cloudinary.com/dw8him6rb/image/upload/v1665386645/city-explorer/school_kids.jpg","","/schools--sb","school");
        establishmentCategoryDTOMap.put("school",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Colleges","https://res.cloudinary.com/dw8him6rb/image/upload/v1665040024/city-explorer/college_fn.jpg","","/colleges--sb","college");
        establishmentCategoryDTOMap.put("college",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Temples","https://res.cloudinary.com/dw8him6rb/image/upload/v1665141467/city-explorer/temple1.jpg","","/temples--sb","temple");
        establishmentCategoryDTOMap.put("temple",establishmentCategoryDTO);

        establishmentCategoryDTO=new EstablishmentCategoryDTO("Social Service Center","https://res.cloudinary.com/dw8him6rb/image/upload/v1667029507/city-explorer/hannah-busing-Zyx1bK9mqmA-unsplash.jpg","","/all-establishments--sb","social-service");
        establishmentCategoryDTOMap.put("social-service",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Tourist Attractions","https://res.cloudinary.com/dw8him6rb/image/upload/v1665141468/city-explorer/wayanad2.jpg","List of Tourist Attraction in and around town","/all-establishments--sb","tourist-attraction");
        establishmentCategoryDTOMap.put("tourist-attraction",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Technology","https://res.cloudinary.com/dw8him6rb/image/upload/v1665039322/city-explorer/studio.jpg","","/all-establishments--sb","technology");
        establishmentCategoryDTOMap.put("technology",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Shopping","https://res.cloudinary.com/dw8him6rb/image/upload/v1667031636/city-explorer/boxed-water-is-better-7H1hDt694s8-unsplash.jpg","","/all-establishments--sb","shopping");
        establishmentCategoryDTOMap.put("shopping",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("Church","https://res.cloudinary.com/dw8him6rb/image/upload/v1667032464/city-explorer/biel-morro-d0xjEv-WJQk-unsplash.jpg","","/all-establishments--sb","church");
        establishmentCategoryDTOMap.put("church",establishmentCategoryDTO);
        establishmentCategoryDTO=new EstablishmentCategoryDTO("All","","All Establishments in Sulthan Bathery","/all-establishments--sb","all");
        establishmentCategoryDTOMap.put("all",establishmentCategoryDTO);
        return establishmentCategoryDTOMap;
    }

}
