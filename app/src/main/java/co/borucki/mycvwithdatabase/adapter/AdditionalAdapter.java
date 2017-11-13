package co.borucki.mycvwithdatabase.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
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
import co.borucki.mycvwithdatabase.model.Additional;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;


public class AdditionalAdapter extends RecyclerView.Adapter<AdditionalAdapter.AdditionalViewHolder> {
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private final LayoutInflater mLayoutInflater;
    private final List<Additional> mData = new ArrayList<>();

    public AdditionalAdapter(Context context) {

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public AdditionalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_additional_single_row, parent, false);
        return new AdditionalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdditionalViewHolder holder, int position) {
        Additional additional = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();
        if (mAccessPermission.getAppLanguage().equals("pl")) {
            holder.mAdditionalDescription.setText(additional.getNamePl());
        } else {
            holder.mAdditionalDescription.setText(additional.getNameEn());
        }

        holder.mAdditionalDate.setText(additional.getDate());

    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<Additional> additionalList) {
        mData.clear();
        mData.addAll(additionalList);
        notifyDataSetChanged();
    }

    public class AdditionalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.additional_description)
        TextView mAdditionalDescription;
        @BindView(R.id.additional_date)
        TextView mAdditionalDate;

        public AdditionalViewHolder(View itemView) {
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
