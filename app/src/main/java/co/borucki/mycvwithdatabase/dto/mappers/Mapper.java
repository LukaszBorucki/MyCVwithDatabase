package co.borucki.mycvwithdatabase.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.EducationDTO;
import co.borucki.mycvwithdatabase.dto.HobbiesDTO;
import co.borucki.mycvwithdatabase.dto.MailUserAuthorizationDTO;
import co.borucki.mycvwithdatabase.dto.PersonalDataDTO;
import co.borucki.mycvwithdatabase.dto.SkillDTO;
import co.borucki.mycvwithdatabase.model.Education;
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
                , myEducationDTO.getLogotype());

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
                    , myEducationDTO.getLogotype()));
        }

        return resultList;
    }

    public static List<Skill> fromMySkillsDTOToMySkills(List<SkillDTO> skillDTOs) {
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

    public static Skill fromMySkillsDTOToMySkills(SkillDTO skillDTO) {
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
            , hobbiesDTO.getLogo()));
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
}
