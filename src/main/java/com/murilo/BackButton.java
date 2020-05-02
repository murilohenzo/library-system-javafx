package com.murilo;

import javafx.event.ActionEvent;

import java.io.IOException;

public class BackButton {

    public void back(ActionEvent actionEvent) throws IOException {
        Main.setRoot("Primary");
    }
}
