package g413.stud.bilet19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText Txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            Txt2= findViewById(R.id.SecondTXTInput);
            String t1= getIntent().getStringExtra("abc");
            Txt2.setText(t1);
        }
        catch (Exception ignored){}
    }

    public void on_cancel_click(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void on_ok_click(View v){
        try {
            Txt2=findViewById(R.id.SecondTXTInput);
            String t2= Txt2.getText().toString();
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            intent.putExtra("Text2",t2);
            Toast.makeText(this, t2, Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK, intent);
            finish();
        }
        catch (Exception ignored){}
    }
}