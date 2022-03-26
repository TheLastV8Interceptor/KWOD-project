package com.kwod.firstaidkwod.ui.example.mvp;

public class ExampleModel implements ExampleMVP.Model {
    @Override
    public int giveMeData() {
        return 0;
    }

    @Override
    public String getMessage(String recordedText) {
        if(recordedText.equals("tak"))
            return "TAK";
        else
            return "NIE";
    }
}
