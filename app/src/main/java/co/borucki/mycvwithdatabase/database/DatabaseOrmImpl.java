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


}
