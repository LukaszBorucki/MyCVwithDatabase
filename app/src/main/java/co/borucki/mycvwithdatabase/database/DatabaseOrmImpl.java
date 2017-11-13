package co.borucki.mycvwithdatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import co.borucki.mycvwithdatabase.model.Additional;
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
    private RuntimeExceptionDao<Additional, Integer> mAdditionalDao;

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
        mAdditionalDao = getRuntimeExceptionDao(Additional.class);
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
            TableUtils.createTableIfNotExists(connectionSource, Additional.class);

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
    public List<Education> getAllEducationDataByLanguage(String language) {
        QueryBuilder<Education, Integer> qb = mEducationDao.queryBuilder();
        Where where = qb.where();
        try {
            where.eq("language", language);
            qb.orderBy("id", true);
            return qb.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void truncateEducation() {
        mEducationDao.delete(mEducationDao.queryForAll());
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
    public ExperienceBranch getBranchByBranchId(int branchId) {
        QueryBuilder<ExperienceBranch, Integer> qb = mExperienceBranchDao.queryBuilder();
        Where where = qb.where();
        try {
            where.eq("id", branchId);
            qb.groupBy("id");
            return qb.query().get(0);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

//        return (ExperienceBranch) mExperienceBranchDao.queryForEq("id", branchId);

    }

    @Override
    public void truncateExperienceBranch() {
        mExperienceBranchDao.delete(mExperienceBranchDao.queryForAll());
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
    public List<ExperienceCompany> getAllExperienceCompany() {
        return mExperienceCompanyDao.queryForAll();
    }

    @Override
    public void truncateExperienceCompany() {
        mExperienceCompanyDao.delete(mExperienceCompanyDao.queryForAll());
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
    public List<ExperiencePeriod> getAllByCompanyIdByLanguage(int id, String appLanguage) {
        QueryBuilder<ExperiencePeriod, Integer> qb = mExperiencePeriodDao.queryBuilder();
        Where where = qb.where();
        try {

            where.and(
                    where.eq("companyId", id),
                    where.eq("language", appLanguage)
            );

            qb.orderBy("id", true);
            return qb.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void truncateExperiencePeriod() {
        mExperiencePeriodDao.delete(mExperiencePeriodDao.queryForAll());
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
    public List<ExperienceProject> getAllByCompanyId(int id) {
        return mExperienceProjectDao.queryForEq("companyId", id);
    }

    @Override
    public void truncateExperienceProject() {
        mExperienceProjectDao.delete(mExperienceProjectDao.queryForAll());
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
    public List<ForeignLanguage> getAllForeignLanguage() {
        return mForeignLanguageDao.queryForAll();

    }

    @Override
    public void truncateForeignLanguage() {
        mForeignLanguageDao.delete(mForeignLanguageDao.queryForAll());
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
    public List<Hobbies> getAllHobbiesDataByLanguage() {
        return mHobbiesDao.queryForAll();
    }

    @Override
    public void truncateHobbies() {
        mHobbiesDao.delete(mHobbiesDao.queryForAll());
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

    @Override
    public List<Skill> getAllSkillTechnology() {
        QueryBuilder<Skill, Integer> qb = mSkillDao.queryBuilder();
        Where where = qb.where();
        try {
            where.eq("type", "technology");
            qb.orderBy("id", true);
            return qb.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Skill> getAllSkillTraits() {
        QueryBuilder<Skill, Integer> qb = mSkillDao.queryBuilder();
        Where where = qb.where();
        try {
            where.eq("type", "traits");
            qb.orderBy("id", true);
            return qb.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void truncateSkill() {
        mSkillDao.delete(mSkillDao.queryForAll());
    }

    @Override
    public void saveAdditional(Additional additional) {
        mAdditionalDao.createOrUpdate(additional);
    }

    @Override
    public void saveAdditional(List<Additional> additionalList) {
        for (Additional additional : additionalList) {
            mAdditionalDao.createOrUpdate(additional);
        }
    }

    @Override
    public List<Additional> getAllAdditional() {
        return mAdditionalDao.queryForAll();
    }

    @Override
    public void truncateAdditional() {
        mAdditionalDao.delete(mAdditionalDao.queryForAll());
    }
}
