package study.xuqi.demo.com.babylistener;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CheckStateService extends Service {
    private boolean isRunning = false;
    public CheckStateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("绑定");

        return new Binder();
    }

    public class Binder extends android.os.Binder {
        public void setData(String data) {
            System.out.println("Binder 设置数据");
        }
    }

    @Override
    public void onCreate() {
        System.out.println("onCreate");
        isRunning = true;
        super.onCreate();
    }


    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestory");
        isRunning = false;
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread() {

            @Override
            public void run() {
                super.run();
                int i =0;
                while(isRunning) {
                    i++;

                    System.out.println("hello");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }



}
