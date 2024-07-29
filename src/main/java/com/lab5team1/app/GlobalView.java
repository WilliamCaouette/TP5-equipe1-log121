package com.lab5team1.app;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GlobalView {
    GlobalViewController controller = GlobalViewController.getInstance();

    public GlobalView(Stage primaryStage){
        controller.setToolBar(primaryStage);
    }

    public VBox buildView(){
        VBox root = new VBox();
        root.setSpacing(10);
        HBox tabsContainer = new HBox();

        controller.getStaticTab().setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        controller.getOperationTab1().setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        controller.getOperationTab2().setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        tabsContainer.getChildren().addAll(controller.getStaticTab().buildTable(),
                controller.getOperationTab1().buildTable(),
                controller.getOperationTab2().buildTable());
        root.getChildren().addAll(controller.getToolBar().buildToolBar(), tabsContainer);
        return root;
    }


}
