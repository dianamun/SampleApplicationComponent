package com.example.tacademy.sampleapplicationcomponent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {
    TextView messageView;
    String mMessage;

    public  static final String EXTRA_MESSAGE = "message";
    public static final String RESULT_MESSAGE = "result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        messageView = (TextView)findViewById(R.id.text_message);
        Button btn = (Button)findViewById(R.id.btn_finish);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(RESULT_MESSAGE, "echo : "+mMessage );
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        mMessage = intent.getStringExtra(EXTRA_MESSAGE); //"message"로 직접 받기보다는 상수처리
        messageView.setText(mMessage);
    }
}
