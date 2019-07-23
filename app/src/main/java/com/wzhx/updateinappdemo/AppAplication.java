package com.wzhx.updateinappdemo;

import android.app.Application;
import android.widget.Toast;

import com.wzhx.updateinappdemo.http.OKHttpUpdateHttpService;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;
import com.xuexiang.xupdate.utils.UpdateUtils;

public class AppAplication extends Application {
    private static final int CHECK_NO_NEW_VERSION = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        XUpdate.get()
                .debug(false)
                .isWifiOnly(false)
                .isGet(true)
                .isAutoMode(false)
                .param("versionCode", UpdateUtils.getVersionCode(this))
                .param("appKey", getPackageName())
                .setOnUpdateFailureListener(new OnUpdateFailureListener() {
                    @Override
                    public void onFailure(UpdateError error) {
                        if (error.getCode() != CHECK_NO_NEW_VERSION) {
                            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .supportSilentInstall(true)
                .setIUpdateHttpService(new OKHttpUpdateHttpService())
                .init(this);
    }
}
