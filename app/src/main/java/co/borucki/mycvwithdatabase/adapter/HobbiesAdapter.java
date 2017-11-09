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
import co.borucki.mycvwithdatabase.model.Hobbies;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermission;
import co.borucki.mycvwithdatabase.security.ApplicationAccessPermissionImpl;



public class HobbiesAdapter extends RecyclerView.Adapter<HobbiesAdapter.HobbiesViewHolder> {
    private ApplicationAccessPermission mAccessPermission = ApplicationAccessPermissionImpl.getInstance();
    private final LayoutInflater mLayoutInflater;
    private final List<Hobbies> mData = new ArrayList<>();

    public HobbiesAdapter(Context context) {

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public HobbiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.fragment_hobbies_single_row, parent, false);

        return new HobbiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HobbiesViewHolder holder, int position) {
        Hobbies hobbies = mData.get(position);
        Resources res = holder.itemView.getContext().getResources();
        if (mAccessPermission.getAppLanguage().equals("pl")) {
            holder.mhobbiesDescription.setText(hobbies.getNamePl());
        } else {
            holder.mhobbiesDescription.setText(hobbies.getNameEn());
        }

        holder.mHobbiesLogo.setImageBitmap(LocaleHelper.decodeImageFromByteArrayToBitmap(hobbies.getLogo()));

    }

    @Override
    public int getItemCount() {


        return mData.size();
    }

    public void setData(List<Hobbies> hobbies) {
        mData.clear();
        mData.addAll(hobbies);
        notifyDataSetChanged();
    }

    public class HobbiesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hobbies_description)
        TextView mhobbiesDescription;


        @BindView(R.id.hobbies_logo)
        ImageView mHobbiesLogo;

        public HobbiesViewHolder(View itemView) {
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
