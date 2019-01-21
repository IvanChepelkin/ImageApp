package com.example.user.imageapp.presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class ImagePresenter extends MvpPresenter<SetImageView> {

    public void loadImageFromCamers(int i, String[] items) {
        if (items[i].equals("Camera")) {
            getViewState().setImageFromCamera();

        } else if (items[i].equals("Gallery")) {
            getViewState().setImageFromGallery();
        }
    }


}
