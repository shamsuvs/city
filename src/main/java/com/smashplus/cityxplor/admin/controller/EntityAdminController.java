package com.smashplus.cityxplor.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class EntityAdminController {
    @RequestMapping(value="/admin/cms", method = {RequestMethod.GET})
    public String cmsIndex(Model model) {
        return "admin/cms-list-index";
    }
}
