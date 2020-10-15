package org.wecancodeit.librarydemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.librarydemo.models.Campus;
import org.wecancodeit.librarydemo.repositories.CampusRepository;

import javax.annotation.Resource;

@Controller
public class CampusController {

    @Resource
    private CampusRepository campusRepo;

    @RequestMapping({"/campuses", "/", ""})
    public String displayCampuses(Model model){
        model.addAttribute("campuses", campusRepo.findAll());
        return "campusesView";
    }

    @GetMapping("campuses/{location}")
    public String displaySingleCampus(@PathVariable String location, Model model){
        Campus retrievedCampus = campusRepo.findCampusByLocation(location);
        model.addAttribute("campus", retrievedCampus);
        return "campusView";
    }
}
