package vn.edu.iuh.lab_05.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.lab_05.enums.SkillType;
import vn.edu.iuh.lab_05.models.Skill;
import vn.edu.iuh.lab_05.services.SkillService;

import java.util.List;

@Controller
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping("/skills/new")
    public String createSkill(Model model){
        Skill skill = new Skill();
        SkillType[] skillTypes = SkillType.values();
        model.addAttribute("skill", skill);
        model.addAttribute("skillTypes", skillTypes);
        return "skill_form";
    }

    @GetMapping("/skills")
    public String getAllSkill(Model model){
        List<Skill> skills = skillService.getAll();
        model.addAttribute("skills", skills);

        return "skill";
    }

    @PostMapping("/skills/save")
    public String saveSkill(Skill skill){
        skillService.addSkill(skill);

        return "redirect:/skills";
    }

    @GetMapping("/skills/delete/{id}")
    public String deleteSKill(@PathVariable("id") long id){
        skillService.deleteSkill(id);

        return "redirect:/skills";
    }
}
