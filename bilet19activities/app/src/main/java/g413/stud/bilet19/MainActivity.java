package g413.stud.bilet19;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.InputTXT);
    }
    public void on_exit_click(View v){
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Выход отменён", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setIcon(R.drawable.myicon);
            builder.setTitle("Вы уверены?");
            builder.show();
        }
        catch (Exception ignored){}
    }

    public void on_open_click(View v){
        try
        {
            String s = txt.getText().toString();
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("abc", s);
            startActivityForResult(i,555);
        }
        catch (Exception ignored){}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            txt.setText(data.getStringExtra("Text2"));
        }
    }
}