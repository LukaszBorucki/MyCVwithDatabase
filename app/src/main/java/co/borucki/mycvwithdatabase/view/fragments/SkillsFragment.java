package co.borucki.mycvwithdatabase.view.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.borucki.mycvwithdatabase.R;
import co.borucki.mycvwithdatabase.adapter.SkillsTechnologiesAdapter;
import co.borucki.mycvwithdatabase.adapter.SkillsTraitsAdapter;
import co.borucki.mycvwithdatabase.model.Skill;
import co.borucki.mycvwithdatabase.repository.SkillRepository;
import co.borucki.mycvwithdatabase.repository.SkillRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;


public class SkillsFragment extends Fragment {
    private SkillRepository mSkillRepository = SkillRepositoryImpl.getInstance();
    private ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerViewTraits;
    private RecyclerView mRecyclerViewTechnologies;
    private SkillsTraitsAdapter mSkillsTraitsAdapter;
    private SkillsTechnologiesAdapter mSkillsTechnologiesAdapter;

    public SkillsFragment() {
    }

    public static SkillsFragment newInstance() {
        return new SkillsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skills, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerViewTraits = view.findViewById(R.id.skills_fragment_list_view_traits);
        LinearLayoutManager linearLayoutManagerTraits = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerViewTraits.setLayoutManager(linearLayoutManagerTraits);
        DividerItemDecoration dividerItemDecorationTraits = new DividerItemDecoration(getActivity(), linearLayoutManagerTraits.getOrientation());
        mRecyclerViewTraits.addItemDecoration(dividerItemDecorationTraits);
        mSkillsTraitsAdapter = new SkillsTraitsAdapter(getActivity());
        mRecyclerViewTraits.setAdapter(mSkillsTraitsAdapter);
        mRecyclerViewTechnologies =  view.findViewById(R.id.skills_fragment_list_view_technology);
        LinearLayoutManager linearLayoutManagerTechnologies = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerViewTechnologies.setLayoutManager(linearLayoutManagerTechnologies);
        DividerItemDecoration dividerItemDecorationTechnologies = new DividerItemDecoration(getActivity(), linearLayoutManagerTechnologies.getOrientation());
        mRecyclerViewTechnologies.addItemDecoration(dividerItemDecorationTechnologies);
        mSkillsTechnologiesAdapter = new SkillsTechnologiesAdapter(getActivity());
        mRecyclerViewTechnologies.setAdapter(mSkillsTechnologiesAdapter);

        mSkillsTechnologiesAdapter.setData(mSkillRepository.getAllSkillTechnology());
        mSkillsTraitsAdapter.setData(mSkillRepository.getAllSkillTraits());

    }


}
