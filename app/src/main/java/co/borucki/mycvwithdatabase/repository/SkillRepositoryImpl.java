package co.borucki.mycvwithdatabase.repository;


import java.util.List;

import co.borucki.mycvwithdatabase.AndroidApplication;
import co.borucki.mycvwithdatabase.database.Database;
import co.borucki.mycvwithdatabase.model.Skill;

public class SkillRepositoryImpl implements SkillRepository {
    private static SkillRepositoryImpl mInstance = new SkillRepositoryImpl();
    private final Database mDatabase;

    private SkillRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }

    public static SkillRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveSkill(List<Skill> skillList) {
        for (Skill skill : skillList) {
            mDatabase.saveSkill(skillList);
        }
    }

    @Override
    public void saveSkill(Skill skill) {
        mDatabase.saveSkill(skill);
    }

    @Override
    public List<Skill> getAllSkillTechnology() {
        return mDatabase.getAllSkillTechnology();
    }

    @Override
    public List<Skill> getAllSkillTraits() {
        return mDatabase.getAllSkillTraits();
    }

    @Override
    public void truncate() {
        mDatabase.truncateSkill();
    }
}
