package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.ExperienceCompanyDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.ExperienceCompanyRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceCompanyRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllExperienceCompany extends AsyncTask<Void, Void, List<ExperienceCompanyDTO>> {
    private ExperienceCompanyRepository mExperienceCompanyRepository = ExperienceCompanyRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllExperienceCompany() {
    }

    @Override
    protected List<ExperienceCompanyDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/experience/getAllCompany/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ExperienceCompanyDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ExperienceCompanyDTO> companyDTOS) {
        mExperienceCompanyRepository.saveExperienceCompany(Mapper.fromExperienceCompanyDTOToExperienceCompany(companyDTOS));
    }
}
