package com.example.fragmentmenagers;

public interface IFragmentCallback {
    void sendMsgToActivity(String msg);
    String getMsgFromActivity(String msg);
}
