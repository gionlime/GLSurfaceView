package com.yunbo.glsurfaceview.render;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * create by jeek
 * 2022/6/8
 * des: OpenGl ES 图形绘制接口
 **/
public class OpenGLRender implements GLSurfaceView.Renderer {

    /**
     * 主要设置一些绘制时不常变化参数，例如：背景色。是否打开Z-Buffer（去除隐藏面）等等
     */
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        // 设置背景颜色
        gl.glClearColor(0f, 1f, 0f, 0.5f);
        // 使用光滑材质、默认不需要
        gl.glShadeModel(GL10.GL_SMOOTH);
        // 深度缓冲设置
        gl.glClearDepthf(1.0f);
        // 启用深度测试
        gl.glEnable(GL10.GL_DEPTH_TEST);
        // 深度测试类型
        gl.glDepthFunc(GL10.GL_LEQUAL);
        // 最好的角度计算
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

    /**
     * 如果设备支持屏幕的横向和纵向切换，这这方法在横向、纵向互换时调用，此时可以重新设置绘制的纵横比率
     */
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        // 将当前视图窗口设置为新的大小
        gl.glViewport(0, 0, width, height);
        // 选择投影矩阵
        gl.glMatrixMode(GL10.GL_PROJECTION);
        // 重置投影矩阵
        gl.glLoadIdentity();
        // 计算窗口的长宽比
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);
        //选择modeview矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // 重置投影矩阵
        gl.glLoadIdentity();
    }


    /**
     * 绘制每一帧
     */
    @Override
    public void onDrawFrame(GL10 gl) {
        // 清除屏幕缓冲和深度缓冲
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }
}
