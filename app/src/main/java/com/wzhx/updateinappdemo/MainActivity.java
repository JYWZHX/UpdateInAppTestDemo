package com.wzhx.updateinappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.wzhx.updateinappdemo.http.OKHttpUpdateHttpService;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;
import com.xuexiang.xupdate.utils.UpdateUtils;

public class MainActivity extends AppCompatActivity {

    private String updateUrl = "https://raw.githubusercontent.com/JYWZHX/UpdateInAppTestDemo/master/jsonapi/version.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XUpdate.newBuild(this)
                .updateUrl(updateUrl)
                .update();
    }
}
