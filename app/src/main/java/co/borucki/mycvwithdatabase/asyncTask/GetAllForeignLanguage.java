package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.ForeignLanguageDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.ForeignLanguageRepository;
import co.borucki.mycvwithdatabase.repository.ForeignLanguageRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllForeignLanguage extends AsyncTask<Void, Void, List<ForeignLanguageDTO>> {
    private ForeignLanguageRepository mForeignLanguageRepository = ForeignLanguageRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllForeignLanguage() {
    }

    @Override
    protected List<ForeignLanguageDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/languages/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ForeignLanguageDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ForeignLanguageDTO> foreignLanguageDTOS) {
        mForeignLanguageRepository.saveForeignLanguage(Mapper.fromForeignLanguageDTOToForeignLanguage(foreignLanguageDTOS));
    }
}
