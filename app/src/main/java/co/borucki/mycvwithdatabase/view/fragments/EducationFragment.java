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

import co.borucki.mycvwithdatabase.R;
import co.borucki.mycvwithdatabase.adapter.EducationAdapter;
import co.borucki.mycvwithdatabase.repository.EducationRepository;
import co.borucki.mycvwithdatabase.repository.EducationRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;


public class EducationFragment extends Fragment {
    private EducationRepository mEducation = EducationRepositoryImpl.getInstance();
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private RecyclerView mRecyclerView;
    private EducationAdapter mEducationAdapter;

    public EducationFragment() {
        // Required empty public constructor
    }

    public static EducationFragment newInstance() {

        return new EducationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_education, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.education_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mEducationAdapter = new EducationAdapter(getActivity());
        mRecyclerView.setAdapter(mEducationAdapter);

        mEducationAdapter.setData(mEducation.getAllEducationDataByLanguage(mApplicationAccessPermission.getAppLanguage()));

    }


}
