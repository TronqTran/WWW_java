package vn.edu.iuh.lab_05.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.lab_05.models.Skill;
import vn.edu.iuh.lab_05.repositories.SkillRepository;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public Skill addSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public List<Skill> getAll(){
        return skillRepository.findAll();
    }

    public void deleteSkill(long id){
        skillRepository.deleteById(id);
    }
}