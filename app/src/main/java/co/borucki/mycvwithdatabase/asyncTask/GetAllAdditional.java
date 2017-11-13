package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.AdditionalDTO;
import co.borucki.mycvwithdatabase.dto.HobbiesDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.AdditionalRepository;
import co.borucki.mycvwithdatabase.repository.AdditionalRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.HobbiesRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllAdditional extends AsyncTask<Void, Void, List<AdditionalDTO>> {
    private AdditionalRepository mAdditionalRepository = AdditionalRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllAdditional() {
    }

    @Override
    protected List<AdditionalDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/additional/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, AdditionalDTO[].class));
    }

    @Override
    protected void onPostExecute(List<AdditionalDTO> additionalDTOS) {
        mAdditionalRepository.saveAdditional(Mapper.fromAdditionalDTOToAdditional(additionalDTOS));
    }
}
