package vn.edu.iuh.lab_05.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobSkillDto {
    private String skillName;
    private String skillDescription;
    private String skillType;
    private String skillLevel;

    @Override
    public String toString() {
        return "JobSkillDto{" +
                "skillName='" + skillName + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                ", skillType='" + skillType + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                '}';
    }
}
