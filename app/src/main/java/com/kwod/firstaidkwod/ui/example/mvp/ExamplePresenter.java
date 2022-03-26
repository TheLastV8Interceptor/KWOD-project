package com.kwod.firstaidkwod.ui.example.mvp;

public class ExamplePresenter implements ExampleMVP.Presenter {

    private ExampleMVP.View view;
    private ExampleModel model;

    public ExamplePresenter(ExampleMVP.View view, ExampleModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void doSomething() {
        if(this.model.giveMeData() == 0)
            this.view.onDataCorrect();
        else
            this.view.onDataIncorrect();
    }

    @Override
    public void analyzeSpeech(String recordedText) {
        String message = this.model.getMessage(recordedText);
        if(message.equals("TAK"))
            this.view.onMessageYes();
        else if(message.equals("NIE"))
            this.view.onMessageNo();
        else
            this.view.onMessageUnrecognized();
    }
}
