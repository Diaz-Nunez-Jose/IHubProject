package com.ihub.ihub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by anggo on 6/30/2017.
 */

public class EditFieldClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_layout);
    }

    /**
     * This is where the saving should be happening. Watch youtube video min 13.
     * https://www.youtube.com/watch?v=3QHgJnPPnqQ
     * @param v
     */
    public void saveButtonClicked(View v) {
        String messageText = ((EditText)findViewById(R.id.message)).getText().toString();
        if(messageText.equals("")){
        }
        else{
            Intent intent = new Intent();
            intent.putExtra(Intent_Constants.INTENT_MESSAGE_FIELD,messageText);
            setResult(Intent_Constants.INTENT_RESULT_CODE, intent);
            finish();

        }
    }
}
