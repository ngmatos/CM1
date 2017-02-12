package org.feup.nmatos.cm1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    Button sendButton;
    public final static String EXTRA_MESSAGE = "HELLO.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        sendButton = (Button)findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });
    }

    public void sendMessage(View v) throws NullPointerException {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        try {
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }

    }

}
