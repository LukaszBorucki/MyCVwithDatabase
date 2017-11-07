package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.HobbiesDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.HobbiesRepository;
import co.borucki.mycvwithdatabase.repository.HobbiesRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllHobbies extends AsyncTask<Void, Void, List<HobbiesDTO>> {
    private HobbiesRepository mHobbiesRepository = HobbiesRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllHobbies() {
    }

    @Override
    protected List<HobbiesDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/hobbies/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, HobbiesDTO[].class));
    }

    @Override
    protected void onPostExecute(List<HobbiesDTO> hobbiesDTOS) {
        mHobbiesRepository.saveHobbies(Mapper.fromHobbiesDTOToHobbies(hobbiesDTOS));
    }
}
