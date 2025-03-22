package com.example.movie.network;

import android.content.Context;

import com.example.movie.base.activity.BaseActivity;
import com.example.movie.model.response.BaseDataResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CallbackHandler<T extends BaseDataResponse> implements Callback<T> {
    private BaseActivity mContext;
    private String screen = "";

    public CallbackHandler(Context context) {
        if (context instanceof BaseActivity) {
            this.mContext = (BaseActivity) context;
        }
    }

    public CallbackHandler(Context context, String screen) {
        if (context instanceof BaseActivity) {
            this.mContext = (BaseActivity) context;
        }
        this.screen = screen;
    }


    public abstract void onError(Call<T> call, Throwable t);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful() && response.body() != null) {
            // Xử lý phản hồi JSON thành công
            return;
        }

        // Xử lý lỗi từ phản hồi HTTP
        String errorMessage = "Unknown error";
        if (response.errorBody() != null) {
            try {
                errorMessage = response.errorBody().string();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        onError(call, new Exception("HTTP Error: " + response.code() + " - " + errorMessage));
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        String errorMsg = throwable.getMessage();
        if (errorMsg == null) errorMsg = "Unknown error occurred";

        // Log lỗi để debug
        throwable.printStackTrace();

        onError(call, new Exception(errorMsg, throwable));
    }
}
