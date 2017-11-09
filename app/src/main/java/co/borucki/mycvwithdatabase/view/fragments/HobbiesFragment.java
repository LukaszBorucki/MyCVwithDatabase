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
import co.borucki.mycvwithdatabase.adapter.HobbiesAdapter;
import co.borucki.mycvwithdatabase.repository.HobbiesRepository;
import co.borucki.mycvwithdatabase.repository.HobbiesRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;


public class HobbiesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private HobbiesAdapter mHobbiesAdapter;
    private ProgressDialog progressDialog;
    private HobbiesRepository mHobbiesRepository = HobbiesRepositoryImpl.getInstance();

    public HobbiesFragment() {
        // Required empty public constructor
    }

    public static HobbiesFragment newInstance() {

        return new HobbiesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_hobbies, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.hobbies_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mHobbiesAdapter = new HobbiesAdapter(getActivity());
        mRecyclerView.setAdapter(mHobbiesAdapter);
        mHobbiesAdapter.setData(mHobbiesRepository.getAllHobbiesDataByLanguage());

    }
}
