package co.borucki.mycvwithdatabase.dto.mappers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.util.ArrayList;
import java.util.List;

import co.borucki.mycvwithdatabase.LocaleHelper;
import co.borucki.mycvwithdatabase.dto.EducationDTO;
import co.borucki.mycvwithdatabase.dto.ExperienceBranchDTO;
import co.borucki.mycvwithdatabase.dto.ExperienceCompanyDTO;
import co.borucki.mycvwithdatabase.dto.ExperiencePeriodDTO;
import co.borucki.mycvwithdatabase.dto.ExperienceProjectDTO;
import co.borucki.mycvwithdatabase.dto.ForeignLanguageDTO;
import co.borucki.mycvwithdatabase.dto.HobbiesDTO;
import co.borucki.mycvwithdatabase.dto.MailUserAuthorizationDTO;
import co.borucki.mycvwithdatabase.dto.PersonalDataDTO;
import co.borucki.mycvwithdatabase.dto.SkillDTO;
import co.borucki.mycvwithdatabase.model.Education;
import co.borucki.mycvwithdatabase.model.ExperienceBranch;
import co.borucki.mycvwithdatabase.model.ExperienceCompany;
import co.borucki.mycvwithdatabase.model.ExperiencePeriod;
import co.borucki.mycvwithdatabase.model.ExperienceProject;
import co.borucki.mycvwithdatabase.model.ForeignLanguage;
import co.borucki.mycvwithdatabase.model.Hobbies;
import co.borucki.mycvwithdatabase.model.MailUserAuthorization;
import co.borucki.mycvwithdatabase.model.PersonalData;
import co.borucki.mycvwithdatabase.model.Skill;


public class Mapper {
    public static PersonalData fromPersonalDataDTOToPersonalData(PersonalDataDTO personalDataDTO) {
        return new PersonalData(personalDataDTO.getId()
                , personalDataDTO.getName()
                , personalDataDTO.getSurname()
                , personalDataDTO.getPhone()
                , personalDataDTO.getEmail()
                , personalDataDTO.getCity()
                , personalDataDTO.getStreet()
                , personalDataDTO.getHouseNo()
                , personalDataDTO.getPostCode()
                , personalDataDTO.getGitHub()
                , personalDataDTO.getWebService()
                , personalDataDTO.getSkype()
                , personalDataDTO.getLinkedIn()
                , personalDataDTO.getGoogleLocation()
                , personalDataDTO.getPhoto()
                , personalDataDTO.getAboutPl()
                , personalDataDTO.getAboutEn()
        );
    }

    public static Education fromEducationDTOToEducation(EducationDTO myEducationDTO) {
        return new Education(myEducationDTO.getId()
                , myEducationDTO.getStartDate()
                , myEducationDTO.getEndDate()
                , myEducationDTO.getAcademy()
                , myEducationDTO.getFaculty()
                , myEducationDTO.getCourse()
                , myEducationDTO.getLevelOfEducation()
                , myEducationDTO.getThesisTopic()
                , myEducationDTO.getAppliedTechnologies()
                , myEducationDTO.getLanguage()
                , LocaleHelper.decodeImageFromStringToByteArray(myEducationDTO.getLogotype()));

    }

    public static List<Education> fromEducationDTOToEducation(List<EducationDTO> myEducationDTOList) {
        List<Education> resultList = new ArrayList<>();
        for (EducationDTO myEducationDTO : myEducationDTOList) {
            resultList.add(new Education(myEducationDTO.getId()
                    , myEducationDTO.getStartDate()
                    , myEducationDTO.getEndDate()
                    , myEducationDTO.getAcademy()
                    , myEducationDTO.getFaculty()
                    , myEducationDTO.getCourse()
                    , myEducationDTO.getLevelOfEducation()
                    , myEducationDTO.getThesisTopic()
                    , myEducationDTO.getAppliedTechnologies()
                    , myEducationDTO.getLanguage()
                    , LocaleHelper.decodeImageFromStringToByteArray(myEducationDTO.getLogotype())));
        }

        return resultList;
    }

    public static List<Skill> fromSkillsDTOToSkills(List<SkillDTO> skillDTOs) {
        List<Skill> resultList = new ArrayList<>();
        for (SkillDTO skillDTO : skillDTOs) {
            resultList.add(new Skill(skillDTO.getId()
                    , skillDTO.getType()
                    , skillDTO.getNamePl()
                    , skillDTO.getNameEn()
                    , skillDTO.getLevel()));
        }

        return resultList;
    }

    public static Skill fromSkillsDTOToSkills(SkillDTO skillDTO) {
        return new Skill(skillDTO.getId()
                , skillDTO.getType()
                , skillDTO.getNamePl()
                , skillDTO.getNameEn()
                , skillDTO.getLevel());
    }


    public static List<Hobbies> fromHobbiesDTOToHobbies(List<HobbiesDTO> hobbiesDTOs) {
        List<Hobbies> hobbies = new ArrayList<>();
        for (HobbiesDTO hobbiesDTO : hobbiesDTOs) {
            hobbies.add(new Hobbies(hobbiesDTO.getId()
                    , hobbiesDTO.getNamePl()
                    , hobbiesDTO.getNameEn()
                    , LocaleHelper.decodeImageFromStringToByteArray(hobbiesDTO.getLogo())));
        }

        return hobbies;
    }

    public static MailUserAuthorization fromMailUserAuthorizationDTOToMailUserAuthorization(MailUserAuthorizationDTO mailUserAuthorizationDTO) {
        return new MailUserAuthorization(mailUserAuthorizationDTO.getMailUserName()
                , mailUserAuthorizationDTO.getMailUserPassword()
                , mailUserAuthorizationDTO.getMailHost()
                , mailUserAuthorizationDTO.getMailSmtpPort()
                , mailUserAuthorizationDTO.getMailTo());
    }

    public static List<ExperienceBranch> fromExperienceBranchDTOToExperienceBranch(List<ExperienceBranchDTO> experienceBranchDTOs) {
        List<ExperienceBranch> experienceBranches = new ArrayList<>();
        for (ExperienceBranchDTO experienceBranchDTO : experienceBranchDTOs) {
            experienceBranches.add(new ExperienceBranch(experienceBranchDTO.getId()
                    , experienceBranchDTO.getBranchPl()
                    , experienceBranchDTO.getBranchEn()));
        }
        return experienceBranches;
    }

    public static ExperienceBranch fromExperienceBranchDTOToExperienceBranch(ExperienceBranchDTO experienceBranchDTO) {

        return new ExperienceBranch(experienceBranchDTO.getId()
                , experienceBranchDTO.getBranchPl()
                , experienceBranchDTO.getBranchEn());


    }

    public static List<ExperienceCompany> fromExperienceCompanyDTOToExperienceCompany(List<ExperienceCompanyDTO> companyDTOS) {
        List<ExperienceCompany> experienceCompanies = new ArrayList<>();
        for (ExperienceCompanyDTO companyDTO : companyDTOS) {
            experienceCompanies.add(
                    new ExperienceCompany(companyDTO.getId()
                            , companyDTO.getBranchId()
                            , companyDTO.getName()
                            , LocaleHelper.decodeImageFromStringToByteArray(companyDTO.getLogotype()))
            );
        }
        return experienceCompanies;
    }

    public static ExperienceCompany fromExperienceCompanyDTOToExperienceCompany(ExperienceCompanyDTO experienceCompanyDTO) {
        return new ExperienceCompany(experienceCompanyDTO.getId()
                , experienceCompanyDTO.getBranchId()
                , experienceCompanyDTO.getName()
                , LocaleHelper.decodeImageFromStringToByteArray(experienceCompanyDTO.getLogotype()));
    }

    public static List<ExperiencePeriod> fromExperiencePeriodDTOToExperiencePeriod(List<ExperiencePeriodDTO> experiencePeriodDTOS) {
        List<ExperiencePeriod> experiencePeriods = new ArrayList<>();
        for (ExperiencePeriodDTO experiencePeriodDTO : experiencePeriodDTOS) {
            experiencePeriods.add(new ExperiencePeriod(experiencePeriodDTO.getId()
                    , experiencePeriodDTO.getPeriodFrom()
                    , experiencePeriodDTO.getPeriodTo()
                    , experiencePeriodDTO.getPosition()
                    , experiencePeriodDTO.getLanguage()
                    , experiencePeriodDTO.getCompanyId()));
        }
        return experiencePeriods;
    }

    public static ExperiencePeriod fromExperiencePeriodDTOToExperiencePeriod(ExperiencePeriodDTO experiencePeriodDTO) {
        return new ExperiencePeriod(experiencePeriodDTO.getId()
                , experiencePeriodDTO.getPeriodFrom()
                , experiencePeriodDTO.getPeriodTo()
                , experiencePeriodDTO.getPosition()
                , experiencePeriodDTO.getLanguage()
                , experiencePeriodDTO.getCompanyId());

    }

    public static List<ExperienceProject> fromExperienceProjectDTOToExperienceProject(List<ExperienceProjectDTO> experienceProjectDTOS) {
        List<ExperienceProject> experienceProjects = new ArrayList<>();
        for (ExperienceProjectDTO experienceProjectDTO : experienceProjectDTOS) {
            experienceProjects.add(new ExperienceProject(experienceProjectDTO.getId()
                    , experienceProjectDTO.getDescriptionPl()
                    , experienceProjectDTO.getDescriptionEn()
                    , experienceProjectDTO.getCompanyId()));
        }
        return experienceProjects;
    }

    public static ExperienceProject fromExperienceProjectDTOToExperienceProject(ExperienceProjectDTO experienceProjectDTO) {
        return new ExperienceProject(experienceProjectDTO.getId()
                , experienceProjectDTO.getDescriptionPl()
                , experienceProjectDTO.getDescriptionEn()
                , experienceProjectDTO.getCompanyId());
    }

    public static List<ForeignLanguage> fromForeignLanguageDTOToForeignLanguage(List<ForeignLanguageDTO> foreignLanguageDTOS) {
        List<ForeignLanguage> foreignLanguages = new ArrayList<>();
        for (ForeignLanguageDTO foreignLanguageDTO : foreignLanguageDTOS) {
            foreignLanguages.add(new ForeignLanguage(foreignLanguageDTO.getId()
                    , foreignLanguageDTO.getNamePl()
                    , foreignLanguageDTO.getNameEn()
                    , foreignLanguageDTO.getLevel()
                    , LocaleHelper.decodeImageFromStringToByteArray(foreignLanguageDTO.getLogo())));
        }
        return foreignLanguages;
    }

    public static ForeignLanguage fromForeignLanguageDTOToForeignLanguage(ForeignLanguageDTO foreignLanguageDTO) {
        return new ForeignLanguage(foreignLanguageDTO.getId()
                , foreignLanguageDTO.getNamePl()
                , foreignLanguageDTO.getNameEn()
                , foreignLanguageDTO.getLevel()
                , LocaleHelper.decodeImageFromStringToByteArray(foreignLanguageDTO.getLogo()));
    }

    public static List<Skill> fromSkillDTOToSkill(List<SkillDTO> skillDTOS) {
        List<Skill> skills = new ArrayList<>();

        for (SkillDTO skillDTO : skillDTOS) {
            skills.add(new Skill(skillDTO.getId()
                    , skillDTO.getType()
                    , skillDTO.getNamePl()
                    , skillDTO.getNameEn()
                    , skillDTO.getLevel()));
        }

        return skills;
    }
}
