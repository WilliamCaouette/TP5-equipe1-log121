package com.lab5team1.app;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GlobalView implements Observer{
    GlobalViewController controller = GlobalViewController.getInstance();
    private ImageModel model = GlobalViewController.getInstance().getModel();

    public GlobalView(Stage primaryStage){
        controller.setToolBar(primaryStage);
    }

    public VBox buildView(){
        VBox root = new VBox();
        root.setSpacing(10);
        HBox tabsContainer = new HBox();
        model.subscribe(this);
        controller.getStaticTab().setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        controller.getOperationTab1().setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        controller.getOperationTab2().setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        tabsContainer.getChildren().addAll(controller.getStaticTab().buildTable(),
                controller.getOperationTab1().buildTable(),
                controller.getOperationTab2().buildTable());
        root.getChildren().addAll(controller.getToolBar().buildToolBar(), tabsContainer);


        return root;
    }


    @Override
    public void getNotify(Subject context) {
        // ici renvoyer à la tab pour qu'il change la position
        controller.getOperationTab1().updateView(model.getPositionTab1());
    }
}
