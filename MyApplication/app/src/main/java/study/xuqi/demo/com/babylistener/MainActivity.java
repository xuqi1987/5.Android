package study.xuqi.demo.com.babylistener;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener, ServiceConnection {

    TextView tvStatus = null;
    CheckStateService.Binder binder = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);
        findViewById(R.id.play).setOnClickListener(this);
        findViewById(R.id.stopplay).setOnClickListener(this);

        tvStatus = (TextView) findViewById(R.id.status);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:

                System.out.println("start service");
                tvStatus.setText("start");
                startService(new Intent(MainActivity.this, CheckStateService.class));

                if (binder == null) {
                    System.out.println("bind service");
                    bindService(new Intent(MainActivity.this, CheckStateService.class), this, Context.BIND_AUTO_CREATE);
                }else
                {
                    System.out.println("已经绑定，不用再绑");
                }
                break;
            case R.id.stop:
                System.out.println("stop");
                tvStatus.setText("stop");

                // 必须判断是否绑定，没有绑定的话，就去解绑会挂掉。
                if(binder != null) {
                    unbindService(this);
                    binder = null;
                }
                else {
                    System.out.println("还未绑定所以不能解绑，否则会挂掉，这是一个bug");
                }
                stopService(new Intent(MainActivity.this,CheckStateService.class));

                break;
            case R.id.play:
                if(binder!=null){
                    binder.play();
                }
                break;
            case R.id.stopplay:
                if(binder!=null) {
                    binder.stopplay();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(MainActivity.this, CheckStateService.class));
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("服务连接" + name.getClassName().toString());
        binder = (CheckStateService.Binder) service;

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }


}
