package com.example.gojekdashboard.ui.chat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ChatViewModel {


    private final MutableLiveData<String> mText;

    public ChatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

