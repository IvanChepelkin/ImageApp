package com.example.user.imageapp.presenter;

import android.content.Intent;

public interface SetImageView  {
    void setImageFromCamera(Intent intent);

    void setImageFromGallery(Intent intent);

    void setImage(int id);

    void rotateImage();

    void invertImage();

    void mirrorImage();


}
