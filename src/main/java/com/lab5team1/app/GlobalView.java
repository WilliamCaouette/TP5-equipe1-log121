package com.lab5team1.app;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GlobalView{
    private Tab staticTab = new StaticTab();
    private Tab OperationTab1 = new OperationTab();
    private Tab OperationTab2 = new OperationTab();
    private ToolBar toolBar;

    public GlobalView(Stage primaryStage){
        toolBar = new ToolBar(primaryStage);
    }

    public VBox buildView(){
        VBox root = new VBox();
        root.setSpacing(10);
        HBox tabsContainer = new HBox();
        staticTab.setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        OperationTab1.setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        OperationTab2.setImageURL("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");
        tabsContainer.getChildren().addAll(staticTab.buildTable(), OperationTab1.buildTable(), OperationTab2.buildTable());
        root.getChildren().addAll(toolBar.buildToolBar(), tabsContainer);
        return root;
    }


}
