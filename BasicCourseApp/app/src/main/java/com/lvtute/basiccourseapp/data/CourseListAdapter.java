package com.lvtute.basiccourseapp.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.lvtute.basiccourseapp.R;
import com.lvtute.basiccourseapp.model.Course;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder>{
//    private ArrayList<Course> courseArrayList;


    private CourseData courseData = new CourseData();
    private OnItemClickListener itemClickListener;


    @NonNull
    @Override
    public CourseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_row, parent, false);
        return new ViewHolder(courseRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CourseListAdapter.ViewHolder holder, int position) {
        final Context context = holder.courseTitleTv.getContext();

        Course course = courseData.courseList().get(position);
        holder.courseTitleTv.setText(course.getCourseName());
        Picasso.with(holder.courseTitleTv.getContext())
                .load(course.getImageResourceId(holder.courseTitleTv.getContext()))
                .into(holder.courseImageView);

        Picasso.with(holder.courseTitleTv.getContext())
                .load(course.getImageResourceId(holder.courseTitleTv.getContext()))
                .into(holder.authorImageView);
        holder.courseTitleTv.setText(course.getCourseName());

        Bitmap photo = BitmapFactory.decodeResource(context.getResources(), course.getImageResourceId(context));
        Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int bgColor = palette.getMutedColor(ContextCompat.getColor(context,
                        android.R.color.black));
                holder.courseTitleTv.setBackgroundColor(bgColor);
                holder.authorImageView.setBorderColor(bgColor);


            }
        });
    }

    @Override
    public int getItemCount() {
        return courseData.courseList().size();
    }
    public void setOnClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView courseTitleTv;
        public ImageView courseImageView;
        public CircleImageView authorImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            courseTitleTv = itemView.findViewById(R.id.course_title);
            courseImageView = itemView.findViewById(R.id.course_image);
            authorImageView = itemView.findViewById(R.id.author_image);


        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
