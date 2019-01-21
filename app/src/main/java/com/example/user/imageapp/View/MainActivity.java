package com.example.user.imageapp.View;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.user.imageapp.presenter.ImagePresenter;
import com.example.user.imageapp.presenter.SetImageView;
import com.example.user.imageapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements SetImageView {
    @InjectPresenter
    ImagePresenter presenter;
    @BindView(R.id.originalImage)
    ImageView originalImage;
    @BindView(R.id.rec_view_list_images)
    RecyclerView RecViewlistImages;
    final int REQUEST_CAMERA = 1;
    final int SELECT_FILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Привязываем наши вюшки к этому классу
        ButterKnife.bind(this);
    }

    @OnClick(R.id.originalImage)
    void setImage() {
        final String[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                presenter.loadImageFromCamers(i, items);
            }
        });
        builder.show();
    }

    @OnClick(R.id.rotate)
    void setRotateImage() {

    }

    @OnClick(R.id.mirror)
    void setMirrorImage() {

    }

    @OnClick(R.id.invert)
    void setInvertImage() {

    }


    @Override
    public void setImageFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    public void setImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, SELECT_FILE);
    }

    @Override
    public void setImage(int id) {

    }

    @Override
    public void rotateImage() {

    }

    @Override
    public void invertImage() {

    }

    @Override
    public void mirrorImage() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == REQUEST_CAMERA) {

                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                // ivImage.setImageBitmap(bmp);

            } else if (requestCode == SELECT_FILE) {

                Uri selectedImageUri = data.getData();
                originalImage.setImageURI(selectedImageUri);
            }

        }
    }
}
