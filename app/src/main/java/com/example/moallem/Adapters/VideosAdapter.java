package com.example.moallem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moallem.Models.Videos;
import com.example.moallem.R;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideosAdapterVH> {
    private List<Videos> listOfVideos;
    private Context mContext;
    private HandelClick mHandelClick;

    public VideosAdapter(Context context , List<Videos> passedData,HandelClick handelClick)
    {
        this.listOfVideos = passedData;
        mContext = context;
        mHandelClick = handelClick ;
    }
    @NonNull
    @Override
    public VideosAdapter.VideosAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_items, null, false);
        return new VideosAdapter.VideosAdapterVH(itemView,mHandelClick);
    }

    @Override
    public void onBindViewHolder(@NonNull VideosAdapter.VideosAdapterVH holder, final int position) {

        holder.videoImage.setBackgroundResource(Integer.valueOf(listOfVideos.get(position).getVideoImagePath()));
        holder.videoPath.setText(listOfVideos.get(position).getVideoPath());


    }
    public Videos getItemInPosition(int pos)
    {
        return listOfVideos.get(pos);
    }

    @Override
    public int getItemCount() {
        return listOfVideos == null ? 0 : listOfVideos.size();
    }
    public class VideosAdapterVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView videoImage;
        private TextView videoPath;
        HandelClick handelClick;


        private VideosAdapterVH(@NonNull View itemView,HandelClick handelClick) {
            super(itemView);
            videoImage = itemView.findViewById(R.id.videoImage);
            videoPath = itemView.findViewById(R.id.videoPath);
            this.handelClick = handelClick ;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            handelClick.onHandelClick(getAdapterPosition());
        }
    }
    public interface HandelClick {
        void onHandelClick(int position);
    }
}
