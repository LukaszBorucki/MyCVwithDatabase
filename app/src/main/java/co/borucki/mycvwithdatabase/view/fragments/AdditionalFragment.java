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

import co.borucki.mycvwithdatabase.R;
import co.borucki.mycvwithdatabase.adapter.AdditionalAdapter;
import co.borucki.mycvwithdatabase.repository.AdditionalRepository;
import co.borucki.mycvwithdatabase.repository.AdditionalRepositoryImpl;


public class AdditionalFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private AdditionalAdapter mAdditionalAdapter;
    private AdditionalRepository mAdditionalRepository = AdditionalRepositoryImpl.getInstance();

    public AdditionalFragment() {
        // Required empty public constructor
    }

    public static AdditionalFragment newInstance() {

        return new AdditionalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_additional, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.additional_fragment_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdditionalAdapter = new AdditionalAdapter(getActivity());
        mRecyclerView.setAdapter(mAdditionalAdapter);
        mAdditionalAdapter.setData(mAdditionalRepository.getAllAdditional());

    }
}
