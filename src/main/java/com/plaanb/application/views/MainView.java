package com.plaanb.application.views;

import com.plaanb.application.services.GreetService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

@CssImport("./styles/views/main/main-view.css")
@Route("")
public class MainView extends VerticalLayout {

    public MainView(@Autowired GreetService service) {

        Div center = new Div();
        setSizeFull();
        addClassName("main-view");

        center.add(createCenterContent());
        add(createHeaderContent(), center);
    }

    private Component createCenterContent() {
        HorizontalLayout navbar = new HorizontalLayout();
        navbar.addClassName("nav");

        HorizontalLayout navLeft = new HorizontalLayout();
        navLeft.addClassName("nav-left");

        HorizontalLayout navRight = new HorizontalLayout();
        navRight.addClassName("nav-right");

        navLeft.add(createTab("PLAAN B", VaadinIcon.ENTER, MainView.class));
        navRight.add(createTab("Hello World", VaadinIcon.ACCORDION_MENU, HelloWorldView.class));
        navRight.add(createTab("About", VaadinIcon.ACADEMY_CAP, AboutView.class));
        navRight.add(createTab("Services", VaadinIcon.ARCHIVE, ServicesView.class));

        navbar.add(navLeft, navRight);
        return navbar;
    }

    private Component createHeaderContent() {
        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setId("header");

        Span contactInfo = new Span("Email: example@example.com | Phone: 123-456-7890");
        contactInfo.addClassName("contact-info");

        header.add(contactInfo);
        header.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate(MainView.class));
        });

        return header;
    }

    private static Tab createTab(String text, VaadinIcon icon, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        RouterLink link = new RouterLink(text, navigationTarget);
        link.add(icon.create());
        tab.add(link);
        return tab;
    }
}