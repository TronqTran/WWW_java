package vn.edu.iuh.lab_05.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.lab_05.enums.SkillLevel;
import vn.edu.iuh.lab_05.helpers.CandidateHelper;
import vn.edu.iuh.lab_05.models.Candidate;
import vn.edu.iuh.lab_05.models.Skill;
import vn.edu.iuh.lab_05.services.CandidateService;
import vn.edu.iuh.lab_05.services.SkillService;

import java.util.List;
import java.util.Optional;

@Controller
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private SkillService skillService;


    @GetMapping("/candidates")
    public String getAll(Model model){
        List<Candidate> candidates = candidateService.findAll();
        model.addAttribute("candidates", candidates);
        return "candidate";
    }

    @GetMapping("/candidates/new")
    public String showAddCandidateForm(Model model){
        Candidate candidate = new Candidate();
        CountryCode[] countryCode = CountryCode.values();
        SkillLevel[] skillLevels = SkillLevel.values();
        List<Skill> skills = skillService.getAll();

        model.addAttribute("candidate", candidate);
        model.addAttribute("skills" , skills);
        model.addAttribute("SkillLevels", skillLevels);
        model.addAttribute("countryCodes", countryCode);
        model.addAttribute("type", "ADD");
        return "candidate_form";
    }

    @PostMapping("/candidates/save")
    public String saveCandidate(Candidate candidate,
                                @RequestParam(name = "skills") String[] skillNames,
                                @RequestParam(name = "skillLevel") String[] skillLevels,
                                @RequestParam(name = "experienceCompanyName", required = false) String[] experienceCompanyName,
                                @RequestParam(name = "experienceRole", required = false)String[] experienceRole,
                                @RequestParam(name = "experienceWorkDescription", required = false) String[] experienceWorkDescription,
                                @RequestParam(name = "experienceFormDate", required = false)String[] experienceFormDate,
                                @RequestParam(name = "experienceToDate", required = false)String[] experienceToDate){

        CandidateHelper.setCandidateInfo(skillNames, skillLevels, experienceCompanyName, experienceRole,experienceWorkDescription,experienceFormDate, experienceToDate, candidate);

        candidateService.save(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/candidates/{id}")
    public String showCandidateDetail(@PathVariable("id")long id, Model model){
        Optional<Candidate>candidate = candidateService.findById(id);
        if(candidate.isEmpty()){
            return "redirect:/candidates/";
        }

        model.addAttribute("candidate", candidate.get());
        return "candidate_detail";
    }

    @GetMapping("candidates/update/{id}")
    public String showUpdateCandidateForm(@PathVariable("id")long id, Model model){
        Optional<Candidate>candidate = candidateService.findById(id);
        if(candidate.isEmpty()){
            return "redirect:/candidates";
        }

        CountryCode[] countryCode = CountryCode.values();
        SkillLevel[] skillLevels = SkillLevel.values();
        List<Skill> skills = skillService.getAll();

        model.addAttribute("skills" , skills);
        model.addAttribute("SkillLevels", skillLevels);
        model.addAttribute("countryCodes", countryCode);
        model.addAttribute("type", "UPDATE");
        model.addAttribute("candidate", candidate.get());
        return "candidate_form";
    }

    @GetMapping("candidates/delete/{id}")
    public String delete(@PathVariable("id")long id){
        candidateService.delete(id);
        return "redirect:/candidates";
    }
}
