package com.example.qiu.demo2018.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.qiu.demo2018.R;
public class FlashActivity extends Activity implements View.OnClickListener {
  private Handler handler=new Handler();
    private TextView textView2;
  private  MyCountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        textView2= (TextView) findViewById(R.id.textView2);
        textView2.setAlpha(0.6f);
        timer=new MyCountDownTimer(3000,1000);
        timer.start();
        textView2.setOnClickListener(this);
        handler.postDelayed(run,3000);
    }
  Runnable run=new Runnable() {
      @Override
      public void run() {
          startActivity(new Intent(FlashActivity.this,MainActivity.class));
          FlashActivity.this.finish();
      }
  };
    @Override
    public void onClick(View v) {
        startActivity(new Intent(FlashActivity.this,MainActivity.class));
        handler.removeCallbacks(run);
        this.finish();
    }
    //倒计时显示在文本中
    class  MyCountDownTimer extends CountDownTimer{
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
                  textView2.setText("请等待("+(millisUntilFinished/1000)+")s");
        }
        @Override
        public void onFinish() {
            textView2.setText("正在跳转");
        }
    }

}

