package com.plaanb.application.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("/services")
public class ServicesView extends HorizontalLayout {

    public ServicesView() {
        TextArea textArea = new TextArea();
        textArea.setWidthFull();
        textArea.setValue("siia tuleb list teenustest jeejee");

        add(textArea);
    }
}
