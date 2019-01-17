package com.example.user.imageapp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.user.imageapp.Presenter.ImageView;
import com.example.user.imageapp.Presenter.Presenter;
import com.example.user.imageapp.R;

import butterknife.BindView;

public class MainActivity extends MvpAppCompatActivity implements ImageView {
    @InjectPresenter
    Presenter presenter;
    @BindView(R.id.originalImage)
    ImageView originalImage;
    @BindView(R.id.rotate)
    Button rotateImage;
    @BindView(R.id.invert)
    Button invertImage;
    @BindView(R.id.mirror)
    Button mirrorImage;
    @BindView(R.id.rec_view_list_images)
    RecyclerView RecViewlistImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
