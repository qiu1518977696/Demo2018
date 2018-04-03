package com.example.qiu.demo2018.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.example.qiu.demo2018.R;
public class LoginActivity extends AppCompatActivity {
    private Button button_login;
    private EditText    textView_num,textView_pwd;
    private TextView text_not_pssword;
    private CheckBox chk_is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_login=(Button) findViewById(R.id.button_login);
        textView_num= (EditText) findViewById(R.id.text_login_num);
        textView_pwd= (EditText) findViewById(R.id.text_login_num);
        text_not_pssword= (TextView) findViewById(R.id.text_not_pssword);
        chk_is=(CheckBox) findViewById(R.id.chk_is);
        button_login.setAlpha(0.5f);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                LoginActivity.this.finish();
            }
        });
    }
}
