package com.example.user.imageapp.presenter;

import android.content.Intent;
import android.provider.MediaStore;

public class ImagePresenter {
    private SetImageView setImageView;

    public ImagePresenter(SetImageView setImageView) {
        this.setImageView = setImageView;
    }

    public void setFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        setImageView.setImageFromGallery(intent);

    }

    public void setFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        setImageView.setImageFromCamera(intent);

    }


}
