package co.borucki.mycvwithdatabase.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.borucki.mycvwithdatabase.R;
import co.borucki.mycvwithdatabase.model.ExperienceProject;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;


public class ExperienceAdapterProjects extends RecyclerView.Adapter<ExperienceAdapterProjects.ProjectsViewHolder> {
    private ApplicationAccessPermission mApplicationAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private final LayoutInflater mLayoutInflater;
    private final List<ExperienceProject> mData = new ArrayList<>();

    public ExperienceAdapterProjects(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ProjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_experience_prjects_single_row, parent, false);
        return new ProjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectsViewHolder holder, int position) {
        ExperienceProject project = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();
        if(mApplicationAccessPermission.getAppLanguage().equals("pl")) {
            holder.mProjectText.setText(project.getDescriptionPl());
        }else{
            holder.mProjectText.setText(project.getDescriptionEn());
        }
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<ExperienceProject> projects) {
        mData.clear();
        mData.addAll(projects);
        notifyDataSetChanged();
    }

    public class ProjectsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.experience_projects_text)
        TextView mProjectText;

        public ProjectsViewHolder(View itemView) {
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
