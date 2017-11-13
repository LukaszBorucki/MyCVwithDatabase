package co.borucki.mycvwithdatabase.view.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import co.borucki.mycvwithdatabase.R;
import co.borucki.mycvwithdatabase.adapter.ExperienceAdapter;
import co.borucki.mycvwithdatabase.repository.ExperienceCompanyRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceCompanyRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;

public class ExperienceFragment extends Fragment {
    private ExperienceCompanyRepository mCompany = ExperienceCompanyRepositoryImpl.getInstance();
    private RecyclerView mRecyclerView;
    private ExperienceAdapter mExperienceAdapter;
    private ProgressDialog mProgressDialog;

    public ExperienceFragment() {
    }

    public static ExperienceFragment newInstance() {
        return new ExperienceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_experience, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView =  view.findViewById(R.id.experience_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mExperienceAdapter = new ExperienceAdapter(getActivity());
        mRecyclerView.setAdapter(mExperienceAdapter);
        mExperienceAdapter.setData(mCompany.getAllExperienceCompany());
    }


}
