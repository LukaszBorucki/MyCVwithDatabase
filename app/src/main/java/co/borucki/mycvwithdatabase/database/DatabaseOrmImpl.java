package co.borucki.mycvwithdatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import co.borucki.mycvwithdatabase.model.Education;
import co.borucki.mycvwithdatabase.model.ExperienceBranch;
import co.borucki.mycvwithdatabase.model.ExperienceCompany;
import co.borucki.mycvwithdatabase.model.ExperiencePeriod;
import co.borucki.mycvwithdatabase.model.ExperienceProject;
import co.borucki.mycvwithdatabase.model.ForeignLanguage;
import co.borucki.mycvwithdatabase.model.Hobbies;
import co.borucki.mycvwithdatabase.model.Skill;

public class DatabaseOrmImpl extends OrmLiteSqliteOpenHelper implements Database {
    private static final String DATABASE_NAME = "ŁBDB";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<Education, Integer> mEducationDao;
    private RuntimeExceptionDao<ExperienceBranch, Integer> mExperienceBranchDao;
    private RuntimeExceptionDao<ExperienceCompany, Integer> mExperienceCompanyDao;
    private RuntimeExceptionDao<ExperiencePeriod, Integer> mExperiencePeriodDao;
    private RuntimeExceptionDao<ExperienceProject, Integer> mExperienceProjectDao;
    private RuntimeExceptionDao<ForeignLanguage, Integer> mForeignLanguageDao;
    private RuntimeExceptionDao<Hobbies, Integer> mHobbiesDao;
    private RuntimeExceptionDao<Skill, Integer> mSkillDao;

    public DatabaseOrmImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mEducationDao = getRuntimeExceptionDao(Education.class);
        mExperienceBranchDao = getRuntimeExceptionDao(ExperienceBranch.class);
        mExperienceCompanyDao = getRuntimeExceptionDao(ExperienceCompany.class);
        mExperiencePeriodDao = getRuntimeExceptionDao(ExperiencePeriod.class);
        mExperienceProjectDao = getRuntimeExceptionDao(ExperienceProject.class);
        mForeignLanguageDao = getRuntimeExceptionDao(ForeignLanguage.class);
        mHobbiesDao = getRuntimeExceptionDao(Hobbies.class);
        mSkillDao = getRuntimeExceptionDao(Skill.class);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Education.class);
            TableUtils.createTableIfNotExists(connectionSource, ExperienceBranch.class);
            TableUtils.createTableIfNotExists(connectionSource, ExperienceCompany.class);
            TableUtils.createTableIfNotExists(connectionSource, ExperiencePeriod.class);
            TableUtils.createTableIfNotExists(connectionSource, ExperienceProject.class);
            TableUtils.createTableIfNotExists(connectionSource, ForeignLanguage.class);
            TableUtils.createTableIfNotExists(connectionSource, Hobbies.class);
            TableUtils.createTableIfNotExists(connectionSource, Skill.class);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }


    @Override
    public void saveEducation(List<Education> educationList) {
        for (Education education : educationList) {
            mEducationDao.createOrUpdate(education);
        }
    }

    @Override
    public void saveEducation(Education education) {
        mEducationDao.createOrUpdate(education);
    }

    @Override
    public void saveExperienceBranch(List<ExperienceBranch> experienceBranchList) {
        for (ExperienceBranch experienceBranch : experienceBranchList) {
            mExperienceBranchDao.createOrUpdate(experienceBranch);
        }
    }

    @Override
    public void saveExperienceBranch(ExperienceBranch experienceBranch) {
        mExperienceBranchDao.createOrUpdate(experienceBranch);
    }

    @Override
    public void saveExperienceCompany(ExperienceCompany experienceCompany) {
        mExperienceCompanyDao.createOrUpdate(experienceCompany);
    }

    @Override
    public void saveExperienceCompany(List<ExperienceCompany> experienceCompanyList) {
        for (ExperienceCompany experienceCompany : experienceCompanyList) {
            mExperienceCompanyDao.createOrUpdate(experienceCompany);
        }
    }

    @Override
    public void saveExperiencePeriod(ExperiencePeriod experiencePeriod) {
        mExperiencePeriodDao.createOrUpdate(experiencePeriod);
    }

    @Override
    public void saveExperiencePeriod(List<ExperiencePeriod> experiencePeriodList) {
        for (ExperiencePeriod experiencePeriod : experiencePeriodList) {
            mExperiencePeriodDao.createOrUpdate(experiencePeriod);
        }
    }

    @Override
    public void saveExperienceProject(ExperienceProject experienceProject) {
        mExperienceProjectDao.createOrUpdate(experienceProject);
    }

    @Override
    public void saveExperienceProject(List<ExperienceProject> experienceProjectList) {
        for (ExperienceProject experienceProject : experienceProjectList) {
            mExperienceProjectDao.createOrUpdate(experienceProject);
        }
    }

    @Override
    public void saveForeignLanguage(List<ForeignLanguage> foreignLanguageList) {
        for (ForeignLanguage foreignLanguage : foreignLanguageList) {
            mForeignLanguageDao.createOrUpdate(foreignLanguage);
        }
    }

    @Override
    public void saveForeignLanguage(ForeignLanguage foreignLanguage) {
        mForeignLanguageDao.createOrUpdate(foreignLanguage);
    }

    @Override
    public void saveHobbies(List<Hobbies> hobbiesList) {
        for (Hobbies hobbies : hobbiesList) {
            mHobbiesDao.createOrUpdate(hobbies);
        }
    }

    @Override
    public void saveHobbies(Hobbies hobbies) {
        mHobbiesDao.createOrUpdate(hobbies);
    }

    @Override
    public void saveSkill(List<Skill> skillList) {
        for (Skill skill : skillList) {
            mSkillDao.createOrUpdate(skill);
        }
    }

    @Override
    public void saveSkill(Skill skill) {
        mSkillDao.createOrUpdate(skill);
    }
}
