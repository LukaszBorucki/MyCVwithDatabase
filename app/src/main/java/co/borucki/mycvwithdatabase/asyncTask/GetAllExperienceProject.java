package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.ExperienceProjectDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.ExperienceProjectRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceProjectRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllExperienceProject extends AsyncTask<Void, Void, List<ExperienceProjectDTO>> {
    private ExperienceProjectRepository mExperienceProjectRepository = ExperienceProjectRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllExperienceProject() {
    }

    @Override
    protected List<ExperienceProjectDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/experience/getAllProjects/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ExperienceProjectDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ExperienceProjectDTO> experienceProjectDTOS) {
        mExperienceProjectRepository.saveExperienceProject(Mapper.fromExperienceProjectDTOToExperienceProject(experienceProjectDTOS));
    }
}
