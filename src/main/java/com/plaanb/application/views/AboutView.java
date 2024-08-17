package com.plaanb.application.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("/about")
public class AboutView extends HorizontalLayout {

    public AboutView() {
        TextArea textArea = new TextArea();
        textArea.setWidthFull();
        textArea.setValue("Vaadiniga test");

        add(textArea);
    }
}
