package com.example.tacademy.sampleapplicationcomponent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputView;
    TextView resultView;

    private static final int REQUST_CODE_OTHER =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputView = (EditText) findViewById(R.id.text_input);
        resultView = (TextView) findViewById(R.id.text_result);
        Button btn = (Button) findViewById(R.id.btn_other);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                String text = inputView.getText().toString();
                intent.putExtra(OtherActivity.EXTRA_MESSAGE, text);
                //startActivity(intent);
                startActivityForResult(intent, REQUST_CODE_OTHER);
                //REQUEST_CODE 값이 0보다 크거나 같아야함
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==REQUST_CODE_OTHER && resultCode ==RESULT_OK){
                String message = data.getStringExtra(OtherActivity.RESULT_MESSAGE);
                resultView.setText(message);
            }

    }
}
