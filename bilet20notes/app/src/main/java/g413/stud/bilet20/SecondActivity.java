package g413.stud.bilet20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    EditText txt_title;
    EditText txt_content;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt_title = findViewById(R.id.TxtTitle);
        txt_content = findViewById(R.id.TxtContent);
        Intent i = getIntent();
        pos = i.getIntExtra("my note index", -1);
        txt_title.setText(i.getStringExtra("my note title"));
        txt_content.setText(i.getStringExtra("my note content"));
    }
    public void on_cancel_click(View v){
        finish();
    }

    public void on_ok_click(View v){
        Intent i = new Intent();
        i.putExtra("my note index", pos);
        i.putExtra("my note title", txt_title.getText().toString());
        i.putExtra("my note content", txt_content.getText().toString());
        setResult(RESULT_OK, i);
        finish();
    }

}