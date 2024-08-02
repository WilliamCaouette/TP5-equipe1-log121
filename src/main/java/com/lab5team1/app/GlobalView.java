package com.lab5team1.app;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The type Global view.
 */
public class GlobalView implements Observer{
    /**
     * The Controller.
     */
    GlobalViewController controller = GlobalViewController.getInstance();
    private ImageModel model = GlobalViewController.getInstance().getModel();

    /**
     * Instantiates a new Global view.
     */
    public GlobalView(){
    }

    /**
     * Build view v box.
     *
     * @return the v box
     */
    public VBox buildView(){
        VBox root = new VBox();
        root.setSpacing(10);
        HBox tabsContainer = new HBox();
        model.subscribe(this);
        tabsContainer.getChildren().addAll(controller.getStaticTab().buildTab(),
                controller.getOperationTab1().buildTab(),
                controller.getOperationTab2().buildTab());
        root.getChildren().addAll(controller.getToolBar().buildToolBar(), tabsContainer);


        return root;
    }

    /**
     * Update image source.
     *
     * @param url the url
     */
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
