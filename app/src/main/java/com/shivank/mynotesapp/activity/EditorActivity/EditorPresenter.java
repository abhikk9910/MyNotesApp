package com.shivank.mynotesapp.activity.EditorActivity;

import android.util.Log;
import android.widget.Toast;

import com.shivank.mynotesapp.api.ApiClient;
import com.shivank.mynotesapp.api.ApiInterface;
import com.shivank.mynotesapp.model.Note;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorPresenter {

    private  EditorView view;

    public  EditorPresenter(EditorView view){
        this.view = view;
    }

    void saveNote(final String title, final String note, final int color) {

        Log.d("SAVENOTE_FNS", "true");
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Note> call = apiInterface.saveNote(title, note, color);
        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response) {
                Log.d("onResponse\n", "response\n"+response.toString()+"\nresponse");
               view.hideProgress();
                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();

                    if (success) {
                       view.onAddSuccess(String.valueOf(response.body().getMessage()));

                    } else {
                        view.onAddError(String.valueOf(response.body().getMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                Log.d("onFailure: ", "call\n"+call.toString()+"\nThrowable:\n"+t.toString());
                view.onAddError(t.getLocalizedMessage());
            }
        });


    }
}
