package com.example.user.imageapp.presenter;

import com.arellomobile.mvp.MvpView;

public interface SetImageView extends MvpView {
    void setImageFromCamera();

    void setImageFromGallery();

    void setImage(int id);

    void rotateImage();

    void invertImage();

    void mirrorImage();


}
