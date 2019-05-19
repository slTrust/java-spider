package com.littlejava.view;

import com.littlejava.model.News;
import com.littlejava.model.Viewable;

import java.util.ArrayList;

public class ListView {
    private ArrayList<Viewable> viewableList;

    public ListView(ArrayList<Viewable> viewableList) {
        this.viewableList = viewableList;
    }

    public void display(){
        for (Viewable viewItem: viewableList) {
            System.out.println("---------------------------------");
            viewItem.display();
        }
    }


}
