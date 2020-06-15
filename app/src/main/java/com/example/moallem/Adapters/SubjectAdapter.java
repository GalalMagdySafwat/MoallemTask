package com.example.moallem.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moallem.Models.Subject;
import com.example.moallem.R;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectAdapterVH> {
    private List<Subject> listOfSubjects;
    private Context mContext;

    public SubjectAdapter(Context context , List<Subject> passedData)
    {
        this.listOfSubjects = passedData;
        mContext = context;
    }
    @NonNull
    @Override
    public SubjectAdapter.SubjectAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_list_items, null, false);
        return new SubjectAdapterVH(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull SubjectAdapter.SubjectAdapterVH holder, int position) {

        holder.subjectImage.setBackgroundResource(listOfSubjects.get(position).getSubjectBg());
        holder.subjectName.setText(listOfSubjects.get(position).getSubjectName());


    }
    public Subject getItemInPosition(int pos)
    {
        return listOfSubjects.get(pos);
    }

    @Override
    public int getItemCount() {
        return listOfSubjects == null ? 0 : listOfSubjects.size();
    }
    public class SubjectAdapterVH extends RecyclerView.ViewHolder{

        public ImageView subjectImage;
        public TextView subjectName;


        public SubjectAdapterVH(@NonNull View itemView) {
            super(itemView);
            subjectImage = itemView.findViewById(R.id.subjectImage);
            subjectName = itemView.findViewById(R.id.subjectName);


        }
    }
}
