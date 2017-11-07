package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.EducationDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.EducationRepository;
import co.borucki.mycvwithdatabase.repository.EducationRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllEducation extends AsyncTask<Void, Void, List<EducationDTO>> {
    private EducationRepository mEducationRepository = EducationRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllEducation() {
    }

    @Override
    protected List<EducationDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/education/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, EducationDTO[].class));
    }

    @Override
    protected void onPostExecute(List<EducationDTO> educationDTOS) {
        mEducationRepository.saveEducation(Mapper.fromEducationDTOToEducation(educationDTOS));
    }
}
