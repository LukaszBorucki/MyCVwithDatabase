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

import co.borucki.mycvwithdatabase.R;
import co.borucki.mycvwithdatabase.adapter.ForeignLanguageAdapter;
import co.borucki.mycvwithdatabase.repository.ForeignLanguageRepository;
import co.borucki.mycvwithdatabase.repository.ForeignLanguageRepositoryImpl;


public class ForeignLanguageFragment extends Fragment {
    private ForeignLanguageRepository mForeignLanguageRepository = ForeignLanguageRepositoryImpl.getInstance();
    private RecyclerView mRecyclerView;
    private ForeignLanguageAdapter mLanguageAdapter;
    private ProgressDialog progressDialog;

    public ForeignLanguageFragment() {
        // Required empty public constructor
    }

    public static ForeignLanguageFragment newInstance() {

        return new ForeignLanguageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_language, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.language_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mLanguageAdapter = new ForeignLanguageAdapter(getActivity());
        mRecyclerView.setAdapter(mLanguageAdapter);

        mLanguageAdapter.setData(mForeignLanguageRepository.getAllForeignLanguage());

    }



}
