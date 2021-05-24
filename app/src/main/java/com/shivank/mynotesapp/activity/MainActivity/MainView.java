package com.shivank.mynotesapp.activity.MainActivity;

import com.shivank.mynotesapp.model.Note;

import java.util.List;

public interface MainView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Note> notes);
    void onErrorLoading(String message);
}
