package com.lab5team1.app;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GlobalView implements Observer{
    GlobalViewController controller = GlobalViewController.getInstance();
    private ImageModel model = GlobalViewController.getInstance().getModel();

    public GlobalView(){
    }

    public VBox buildView(){
        VBox root = new VBox();
        root.setSpacing(10);
        HBox tabsContainer = new HBox();
        model.subscribe(this);
        tabsContainer.getChildren().addAll(controller.getStaticTab().buildTable(),
                controller.getOperationTab1().buildTable(),
                controller.getOperationTab2().buildTable());
        root.getChildren().addAll(controller.getToolBar().buildToolBar(), tabsContainer);


        return root;
    }

    public void updateImageSource(String url){
        controller.getStaticTab().setImageURL(url);
        controller.getOperationTab1().setImageURL(url);
        controller.getOperationTab2().setImageURL(url);
    }


    @Override
    public void getNotify(Subject context) {
        // ici renvoyer à la tab pour qu'il change la position
        controller.getOperationTab1().updateView(model.getPositionTab1());
        controller.getOperationTab2().updateView(model.getPositionTab2());
        updateImageSource(model.getImageURL());
    }
}
