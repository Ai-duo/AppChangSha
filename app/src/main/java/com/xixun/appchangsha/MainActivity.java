package com.xixun.appchangsha;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.xixun.appchangsha.databinding.ActivityMainBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

//import androidx.databinding.DataBindingUtil;
public class MainActivity extends Activity {
    ActivityMainBinding mainBinding;
    TempView wd;
    ShiDuView sd;
    TextView fs, fx, qy, yl, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        wd = findViewById(R.id.wd);
        sd = findViewById(R.id.sd);
        fs = findViewById(R.id.fs);
        fx = findViewById(R.id.fx);
        qy = findViewById(R.id.qy);
        yl = findViewById(R.id.yl);
        time = findViewById(R.id.time);
        intent = new Intent(this, ElementsService.class);
        startService(intent);
    }

    Intent intent;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getInfo(Dmgd dmgd) {
        wd.setMinc(dmgd.wd);
        sd.setMinc(dmgd.sd);
        fs.setText(dmgd.fs+"m/s");
        fx.setText(dmgd.fx+"风");
        qy.setText(dmgd.qy+"hPa");
        yl.setText(dmgd.js+"mm");
        time.setText(dmgd.time);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        stopService(intent);
        super.onDestroy();
    }
}