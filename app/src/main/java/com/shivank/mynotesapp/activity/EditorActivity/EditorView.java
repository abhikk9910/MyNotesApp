package com.shivank.mynotesapp.activity.EditorActivity;

public interface EditorView {

    void showProgress();
    void hideProgress();
    void onAddSuccess(String message);
    void onAddError(String message);
}
