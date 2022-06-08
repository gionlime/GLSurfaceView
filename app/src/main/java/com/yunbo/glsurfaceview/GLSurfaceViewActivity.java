package com.yunbo.glsurfaceview;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.yunbo.glsurfaceview.render.OpenGLRender;

public class GLSurfaceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        GLSurfaceView glsurfaceView = new GLSurfaceView(this);
        glsurfaceView.setRenderer(new OpenGLRender());
        setContentView(glsurfaceView);
    }
}