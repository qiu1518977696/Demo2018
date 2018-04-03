package com.example.qiu.demo2018.activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.example.qiu.demo2018.R;
public class LoginActivity extends AppCompatActivity {
    private Button button_login;
    private EditText   textView_num,textView_pwd;
    private TextView text_not_pssword;
    private CheckBox chk_is;
    private  boolean isLogNUm=false;//是否记住密码
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_login=(Button) findViewById(R.id.button_login);
        textView_num= (EditText) findViewById(R.id.text_login_num);
        textView_pwd= (EditText) findViewById(R.id.text_login_password);
        preferences=getSharedPreferences("edit", Context.MODE_PRIVATE);
        text_not_pssword= (TextView) findViewById(R.id.text_not_pssword);
        chk_is=(CheckBox) findViewById(R.id.chk_is);

        //获取保存到的数据是否记住选择记住密码  选择就提取数据
        isLogNUm=preferences.getBoolean("is",false);
        if(isLogNUm)
        {
            String num= preferences.getString("num","");
            String pwd=preferences.getString("pwd","");
            textView_num.setText(num);
            textView_pwd.setText(pwd);
            chk_is.setChecked(true);
        }
        else
        {
            textView_num.setText("");
            textView_pwd.setText("");
        }
        button_login.setAlpha(0.4f);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=preferences.edit() ;
                //判断是否选择记住密码  选择就存储数据
                if(chk_is.isChecked())
                {
                    editor.putBoolean("is",true);
                    editor.putString("num",textView_num.getText().toString().trim());
                    editor.putString("pwd",textView_pwd.getText().toString().trim());
                }
                else
                {
                    //清空数据  之后在存储数据
                    preferences.edit().clear();
                    editor.putBoolean("is",false);
                }
                //提交数据
                editor.apply();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                //销毁资源
                LoginActivity.this.finish();
            }
        });
        text_not_pssword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("忘记密码");
                View view= LayoutInflater.from(LoginActivity.this).inflate(R.layout.layout_alert,null);
                builder.setView(view);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.create().dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.create().dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }
}
