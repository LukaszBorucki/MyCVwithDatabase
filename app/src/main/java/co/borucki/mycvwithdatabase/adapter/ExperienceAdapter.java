package co.borucki.mycvwithdatabase.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycvwithdatabase.LocaleHelper;
import co.borucki.mycvwithdatabase.R;
import co.borucki.mycvwithdatabase.model.ExperienceBranch;
import co.borucki.mycvwithdatabase.model.ExperienceCompany;
import co.borucki.mycvwithdatabase.model.ExperiencePeriod;
import co.borucki.mycvwithdatabase.repository.ExperienceBranchRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceBranchRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.ExperiencePeriodRepository;
import co.borucki.mycvwithdatabase.repository.ExperiencePeriodRepositoryImpl;
import co.borucki.mycvwithdatabase.repository.ExperienceProjectRepository;
import co.borucki.mycvwithdatabase.repository.ExperienceProjectRepositoryImpl;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.EmployerViewHolder> {
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private ExperienceBranchRepository mBranch = ExperienceBranchRepositoryImpl.getInstance();
    private ExperiencePeriodRepository mPeriod = ExperiencePeriodRepositoryImpl.getInstance();
    private ExperienceProjectRepository mProject = ExperienceProjectRepositoryImpl.getInstance();
    private final LayoutInflater mLayoutInflater;
    private RecyclerView mRecyclerViewPeriods;
    private RecyclerView mRecyclerViewProjects;
    private final List<ExperienceCompany> mData = new ArrayList<>();
    private ExperienceAdapterPeriods mExperienceAdapterPeriods;
    private ExperienceAdapterProjects mExperienceAdapterProjects;

    public ExperienceAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public EmployerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_experience_single_row, parent, false);

        mRecyclerViewPeriods = view.findViewById(R.id.experience_periods);
        LinearLayoutManager linearLayoutManagerPeriods = new LinearLayoutManager(parent.getContext());
        mRecyclerViewPeriods.setLayoutManager(linearLayoutManagerPeriods);
        DividerItemDecoration dividerItemDecorationPeriods = new DividerItemDecoration(parent.getContext(), linearLayoutManagerPeriods.getOrientation());
        mRecyclerViewPeriods.addItemDecoration(dividerItemDecorationPeriods);
        mExperienceAdapterPeriods = new ExperienceAdapterPeriods(parent.getContext());
        mRecyclerViewPeriods.setAdapter(mExperienceAdapterPeriods);

        mRecyclerViewProjects =  view.findViewById(R.id.experience_projects);
        LinearLayoutManager linearLayoutManagerProjects = new LinearLayoutManager(parent.getContext());
        mRecyclerViewProjects.setLayoutManager(linearLayoutManagerProjects);
        DividerItemDecoration dividerItemDecorationProjects = new DividerItemDecoration(parent.getContext(), linearLayoutManagerProjects.getOrientation());
        mRecyclerViewProjects.addItemDecoration(dividerItemDecorationProjects);
        mExperienceAdapterProjects = new ExperienceAdapterProjects(parent.getContext());
        mRecyclerViewProjects.setAdapter(mExperienceAdapterProjects);

        return new EmployerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployerViewHolder holder, int position) {
        ExperienceCompany employer = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();
        String nameOfBranchInUsedLanguage;

        ExperienceBranch branch =  mBranch.getBranchByBranchId(employer.getBranchId());
        if(mAccessPermission.getAppLanguage().equals("pl")) {
            nameOfBranchInUsedLanguage = branch.getBranchPl();
        }
        else{
            nameOfBranchInUsedLanguage = branch.getBranchEn();
        }

        holder.mEmployerBranch.setText(nameOfBranchInUsedLanguage);
        holder.mEmployerName.setText(employer.getName());
        holder.mLogotype.setImageBitmap(LocaleHelper.decodeImageFromByteArrayToBitmap(employer.getLogotype()));
        int id = employer.getId();




        mExperienceAdapterProjects.setData(mProject.getAllByCompanyId(id));
        mExperienceAdapterPeriods.setData(mPeriod.getAllByCompanyIdByLanguage(id, mAccessPermission.getAppLanguage()));
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<ExperienceCompany> experienceCompanyList) {
        mData.clear();
        mData.addAll(experienceCompanyList);
        notifyDataSetChanged();
    }

    public class EmployerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.experience_branch)
        TextView mEmployerBranch;

        @BindView(R.id.experience_company_name)
        TextView mEmployerName;

        @BindView(R.id.experience_imageView)
        ImageView mLogotype;

        public EmployerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
//        mOnLongClickListener = onLongClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
//        mOnClickListener = onClickListener;
    }
}
