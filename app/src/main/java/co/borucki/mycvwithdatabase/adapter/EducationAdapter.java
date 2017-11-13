package co.borucki.mycvwithdatabase.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import co.borucki.mycvwithdatabase.model.Education;



public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.MyEducationViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final List<Education> mData = new ArrayList<>();

    public EducationAdapter(Context context) {

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyEducationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.education_single_row, parent, false);

        return new MyEducationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyEducationViewHolder holder, int position) {
        Education education = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();

        holder.mEducationAcademy.setText(education.getAcademy());

        if (!education.getFaculty().equals("")) {
            holder.mEducationFaculty.setText(education.getFaculty());
        } else {
            holder.mEducationFaculty.setVisibility(View.GONE);
        }
        holder.mEducationCourse.setText(education.getCourse());

        holder.mEducationStartDate.setText(education.getStartDate());
        holder.mEducationEndDate.setText(education.getEndDate());
        if (!education.getLevelOfEducation().equals("")) {
            holder.mEducationLevelOfEducation.setText(res.getString(R.string.education_level_of_education)
                    + " \n\t\t"
                    + education.getLevelOfEducation());
        } else {
            holder.mEducationLevelOfEducation.setVisibility(View.GONE);
        }
        if (!education.getThesisTopic().equals("")) {
            holder.mEducationThesisTopic.setText("\t\t" + education.getThesisTopic());
        } else {
            holder.mEducationThesisTopic.setVisibility(View.GONE);
            holder.mEducationThesisTopicHeading.setVisibility(View.GONE);
        }
        if (!education.getAppliedTechnologies().equals("")) {
            holder.mEducationAppliedTechnology.setText("\t\t" + education.getAppliedTechnologies());
        } else {
            holder.mEducationAppliedTechnology.setVisibility(View.GONE);
            holder.mEducationAppliedTechnologiesHeading.setVisibility(View.GONE);
        }
        holder.mEducationLogotype.setImageBitmap(LocaleHelper.decodeImageFromByteArrayToBitmap(education.getLogotype()));
    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<Education> educationList) {
        mData.clear();
        mData.addAll(educationList);
        notifyDataSetChanged();
    }

    public class MyEducationViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.education_single_row_academy)
        TextView mEducationAcademy;

        @BindView(R.id.education_single_row_faculty)
        TextView mEducationFaculty;

        @BindView(R.id.education_single_row_course)
        TextView mEducationCourse;

        @BindView(R.id.education_single_row_start_date)
        TextView mEducationStartDate;

        @BindView(R.id.education_single_row_end_date)
        TextView mEducationEndDate;

        @BindView(R.id.education_single_row_level_of_education)
        TextView mEducationLevelOfEducation;

        @BindView(R.id.education_single_row_thesis_topic)
        TextView mEducationThesisTopic;

        @BindView(R.id.education_single_row_applied_technologies)
        TextView mEducationAppliedTechnology;

        @BindView(R.id.education_single_row_logotype)
        ImageView mEducationLogotype;

        @BindView(R.id.education_single_row_thesis_topic_heading)
        TextView mEducationThesisTopicHeading;

        @BindView(R.id.education_single_row_applied_technologies_heading)
        TextView mEducationAppliedTechnologiesHeading;

        public MyEducationViewHolder(View itemView) {
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
