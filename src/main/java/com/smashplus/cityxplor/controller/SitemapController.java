package com.smashplus.cityxplor.controller;

import com.smashplus.cityxplor.admin.controller.EstablishAdminController;
import com.smashplus.cityxplor.dto.HousekeepingDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SitemapController {


        //private List<String> URLS = List.of("/", "/projects", "/about", "/contactus");
        private String DOMAIN = "sulthanbathery";
        final
        EstablishAdminController techPostAdminService;

    public SitemapController(EstablishAdminController techPostAdminService) {
        this.techPostAdminService = techPostAdminService;
    }

    @RequestMapping(value = "/sitemap.xml",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
        public XmlUrlSet main() {
            XmlUrlSet xmlUrlSet = new XmlUrlSet();
        List<HousekeepingDTO>  urls = techPostAdminService.generateSitemapUrls(DOMAIN);
            for (HousekeepingDTO eachLink : urls) {
                create(xmlUrlSet, eachLink.getUrl(), eachLink.getDate_mod(), XmlUrl.Priority.HIGH);
            }
            return xmlUrlSet;
        }

        private void create(XmlUrlSet xmlUrlSet, String link, String date_mod, XmlUrl.Priority priority) {
            xmlUrlSet.addUrl(new XmlUrl(link, date_mod, priority));
        }
    }
