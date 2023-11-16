package vn.edu.iuh.lab_05.helpers;

import vn.edu.iuh.lab_05.enums.SkillLevel;
import vn.edu.iuh.lab_05.models.Company;
import vn.edu.iuh.lab_05.models.Job;

public class JobHelper {
    public static void setJobSkills(String[] skills, String[] skillLevels, String companyId, Job job){
        job.setCompany(new Company(Long.parseLong(companyId)));
        for(int i = 0; i < skills.length; i++){
            System.out.println("SKILL: "+ skills[i]);
            System.out.println("SKILL LEVEL: "+ skillLevels[i]);
            job.addJobSKill(Long.parseLong(skills[i]), SkillLevel.valueOf(skillLevels[i]));


        }
        System.out.println("Job Skill length: "+job.getJobSkills().size());
    }
}
