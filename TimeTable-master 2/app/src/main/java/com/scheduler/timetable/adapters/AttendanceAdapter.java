package com.scheduler.timetable.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.scheduler.timetable.R;
import com.scheduler.timetable.model.Subject;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.MyViewHolder> {

    private List<Subject> subjectList;
    private List<Integer> progressList;

    int targetAttendance;

    public AttendanceAdapter(List<Subject> subjectList, List<Integer> progress,
                             int targetAttendance) {
        this.subjectList = subjectList;
        this.progressList = progress;
        updateTargetAttendance(targetAttendance);
    }

    public void updateTargetAttendance(int targetAttendance) {
        this.targetAttendance = targetAttendance;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_attendance, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.subjectName.setText(subject.getSubjectName());
        holder.attendance.setProgress(progressList.get(position));
        int attendedLectures, totalLectures, x;
        attendedLectures = subjectList.get(position).getAttendedLectures();
        totalLectures = subjectList.get(position).getTotalLectures();
        if (attendedLectures == 0 && totalLectures == 0) {
            x = 0;
        } else {
            x = attendedLectures * 100 / totalLectures;
        }
        int redColorValue = Color.parseColor("#FF0000");
        int blueColorValue = Color.parseColor("#4385F4");
        if (x >= targetAttendance || x == 0) {
            holder.attendance.setReachedBarColor(blueColorValue);
            holder.attendance.setProgressTextColor(blueColorValue);
        } else {
            holder.attendance.setReachedBarColor(redColorValue);
            holder.attendance.setProgressTextColor(redColorValue);
        }


    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView subjectName;
        NumberProgressBar attendance;


        MyViewHolder(View view) {
            super(view);
            subjectName = view.findViewById(R.id.subjectNameAttendance);
            attendance = view.findViewById(R.id.attendance_progress_bar);
        }
    }
}
