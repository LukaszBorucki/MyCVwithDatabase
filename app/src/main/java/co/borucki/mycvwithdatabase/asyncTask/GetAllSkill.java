package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.SkillDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.SkillRepository;
import co.borucki.mycvwithdatabase.repository.SkillRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllSkill extends AsyncTask<Void, Void, List<SkillDTO>> {
    private SkillRepository mSkillRepository = SkillRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllSkill() {
    }

    @Override
    protected List<SkillDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/skills/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, SkillDTO[].class));
    }

    @Override
    protected void onPostExecute(List<SkillDTO> skillDTOS) {
        mSkillRepository.saveSkill(Mapper.fromSkillDTOToSkill(skillDTOS));
    }
}
