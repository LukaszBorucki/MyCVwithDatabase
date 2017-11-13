package co.borucki.mycvwithdatabase.adapter;

import android.content.Context;
import android.content.res.Resources;
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
import co.borucki.mycvwithdatabase.model.ForeignLanguage;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;


public class ForeignLanguageAdapter extends RecyclerView.Adapter<ForeignLanguageAdapter.LanguageViewHolder> {
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private final LayoutInflater mLayoutInflater;
    private final List<ForeignLanguage> mData = new ArrayList<>();

    public ForeignLanguageAdapter(Context context) {

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public LanguageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_language_single_row, parent, false);

        return new LanguageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LanguageViewHolder holder, int position) {
        ForeignLanguage language = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();
        if (mAccessPermission.getAppLanguage().equals("pl")) {
            holder.mLanguageName.setText(language.getNamePl());
        } else {
            holder.mLanguageName.setText(language.getNameEn());
        }
        holder.mLanguageLevel.setText("-\t\t\t" + language.getLevel());
        holder.mLanguageFlag.setImageBitmap(LocaleHelper.decodeImageFromByteArrayToBitmap(language.getLogo()));

    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<ForeignLanguage> languages) {
        mData.clear();
        mData.addAll(languages);
        notifyDataSetChanged();
    }

    public class LanguageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.language_name)
        TextView mLanguageName;

        @BindView(R.id.language_level)
        TextView mLanguageLevel;

        @BindView(R.id.language_flag)
        ImageView mLanguageFlag;

        public LanguageViewHolder(View itemView) {
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
