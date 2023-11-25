package vn.edu.iuh.lab_05.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.lab_05.enums.SkillLevel;
import vn.edu.iuh.lab_05.enums.SkillType;
import vn.edu.iuh.lab_05.helpers.JobHelper;
import vn.edu.iuh.lab_05.models.Job;
import vn.edu.iuh.lab_05.models.Skill;
import vn.edu.iuh.lab_05.services.JobService;
import vn.edu.iuh.lab_05.services.SkillService;

import java.util.List;


@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService  skillService;

    @GetMapping("/companies/{id}/job")
    public String showAddJobForm(@PathVariable("id")long id, Model model){
        SkillLevel[] skillLevels = SkillLevel.values();
        List<Skill> skills = skillService.getAll();
        Job job = new Job();

        model.addAttribute("job", job);
        model.addAttribute("skills", skills);
        model.addAttribute("SkillLevels", skillLevels);
        model.addAttribute("companyId", id);
        return "create_job";
    }

    @PostMapping("/job/save")
    public String saveProduct(@ModelAttribute("job") Job job,
                              @RequestParam(name = "skills") String[] skillNames,
                              @RequestParam(name = "skillLevel") String[] skillLevels,
                              @RequestParam(name = "companyId") String companyId
    ){
        JobHelper.setJobSkills(skillNames, skillLevels, companyId, job);
        jobService.addJob(job);
        return "redirect:/companies/"+companyId;
    }

    @GetMapping("/job")
    public String showJob(Model model){
        List<Job>jobs = jobService.getAll();

        model.addAttribute("jobs", jobs);
        return "job";
    }
}