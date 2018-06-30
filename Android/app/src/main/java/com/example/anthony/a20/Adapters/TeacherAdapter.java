package com.example.anthony.a20.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.anthony.a20.Entities.Teacher;
import com.example.anthony.a20.R;

import java.util.ArrayList;

public class TeacherAdapter extends ArrayAdapter<Teacher>{
    private int mColorResourceId;

    public TeacherAdapter(Activity context, ArrayList<Teacher> teachers, int colorResourceId) {
        super(context,0, teachers);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.teacher_item, parent, false);
        }
        Teacher teacher_item=getItem(position);

        TextView txtName = listItemView.findViewById(R.id.txt_teacher_name);
        ImageView mImageView = (ImageView) listItemView.findViewById(R.id.image);
        RatingBar ratingBar = listItemView.findViewById(R.id.rating_bar);
        txtName.setText(teacher_item.getName());
        ratingBar.setRating(teacher_item.getRating());
       //ratingBar.setRating(Float.parseFloat("2.3"));
        if (teacher_item.hasImage()){
            mImageView.setImageResource(teacher_item.getmProfileImage());
        }
        else  {
            mImageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
        View textContainer = listItemView.findViewById(R.id.item_container);

        // set its backgroung resource to the mColorResourceId
        textContainer.setBackgroundResource(mColorResourceId);

        return listItemView;
    }
}
