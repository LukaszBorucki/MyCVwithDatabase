package co.borucki.mycvwithdatabase.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.dto.ExperienceBranchDTO;
import co.borucki.mycvwithdatabase.dto.mappers.Mapper;
import co.borucki.mycvwithdatabase.repository.ExperienceBranchRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceBranchRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;
import co.borucki.mycvwithdatabase.security.MD5Encryption;

public class GetAllExperienceBranch extends AsyncTask<Void, Void, List<ExperienceBranchDTO>> {
    private ExperienceBranchRepository mExperienceBranchRepository = ExperienceBranchRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();


    public GetAllExperienceBranch() {
    }

    @Override
    protected List<ExperienceBranchDTO> doInBackground(Void... voids) {
        String link = "http://www.borucki.co/api_v2/experience/getAllBranch/?id="
                + mApplicationAccessPermission.getAccessMail()
                + "&pass="
                + MD5Encryption.encrypt(mApplicationAccessPermission.getAccessPassword());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ExperienceBranchDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ExperienceBranchDTO> experienceBranchDTOS) {
        mExperienceBranchRepository.saveExperienceBranch(Mapper.fromExperienceBranchDTOToExperienceBranch(experienceBranchDTOS));
    }
}
