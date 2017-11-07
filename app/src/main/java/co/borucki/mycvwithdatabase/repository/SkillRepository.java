package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.model.Skill;

public interface SkillRepository {
    void saveSkill(List<Skill> skillList);

    void saveSkill(Skill skill);
}
