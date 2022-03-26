package com.kwod.firstaidkwod.ui.example.mvp;

public interface ExampleMVP {

    interface Presenter {
        void doSomething();

        void analyzeSpeech(String recordedText);
    }

    interface View {
        void onDataCorrect();
        void onDataIncorrect();

        void onMessageYes();
        void onMessageNo();
        void onMessageUnrecognized();
    }

    interface Model {
        int giveMeData();

        String getMessage(String recordedText);
    }
}
