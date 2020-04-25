package bubbleshooter.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class HandlerAdapterMouseClicked implements EventHandler<MouseEvent> {

    @Override
    public final void handle(final MouseEvent event) {
        System.out.println("x = " + event.getX() + ", y = " + event.getY());
    }
}

