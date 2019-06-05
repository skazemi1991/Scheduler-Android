package com.scheduler.timetable.viewmodel;

import com.scheduler.timetable.database.AppDatabase;
import com.scheduler.timetable.model.Lecture;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class LectureViewModel extends ViewModel {
    private LiveData<List<Lecture>> lecture;

    public LectureViewModel(AppDatabase database, int mDay) {
        lecture = database.lectureDao().loadAllLectures(mDay);
    }

    public LiveData<List<Lecture>> getLecture() {
        return lecture;
    }


}
