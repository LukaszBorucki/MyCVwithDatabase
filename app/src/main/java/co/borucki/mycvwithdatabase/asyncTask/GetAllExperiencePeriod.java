package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.ExperiencePeriodDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.ExperiencePeriodRepository;
import co.borucki.mycvwithdatabase.repository.ExperiencePeriodRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllExperiencePeriod extends AsyncTask<Void, Void, List<ExperiencePeriodDTO>> {
    private ExperiencePeriodRepository mExperiencePeriodRepository = ExperiencePeriodRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllExperiencePeriod() {
    }

    @Override
    protected List<ExperiencePeriodDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/experience/getAllPeriods/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ExperiencePeriodDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ExperiencePeriodDTO> experiencePeriodDTOS) {
        mExperiencePeriodRepository.saveExperiencePeriod(Mapper.fromExperiencePeriodDTOToExperiencePeriod(experiencePeriodDTOS));
    }
}
