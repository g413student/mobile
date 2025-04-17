package g413.stud.bilet18;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter <Note> adp;
    int sel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        adp = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1);
        ListView lst = findViewById(R.id.list_notes);
        lst.setAdapter(adp);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sel = position;
            }
        });
    }
    public void on_new_click(View v){
        Note n = new Note();
        n.content = "some content";
        adp.add(n);
        LayoutInflater li = LayoutInflater.from(this);
        View customalert = li.inflate(R.layout.custom_alert, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setView(customalert);
        EditText inputcontent = customalert.findViewById(R.id.txtcontent);
        inputcontent.setText(n.content);
        dialog.setTitle("Введите текст");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                n.content = inputcontent.getText().toString();
                adp.notifyDataSetChanged();
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
    public void on_edit_click(View v){
        try {
            Note n = adp.getItem(sel);
            LayoutInflater li = LayoutInflater.from(this);
            View customalert = li.inflate(R.layout.custom_alert, null);
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setView(customalert);
            EditText inputcontent = customalert.findViewById(R.id.txtcontent);
            inputcontent.setText(n.content);
            dialog.setTitle("Введите текст");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    n.content = inputcontent.getText().toString();
                    adp.notifyDataSetChanged();
                }
            });
            dialog.setNegativeButton("Отмена", null);
            AlertDialog alertDialog = dialog.create();
            alertDialog.show();
        }catch (Exception e){
            Toast.makeText(this, "Выберите заметку", Toast.LENGTH_SHORT).show();
        }
    }
    public void on_delete_click(View v){
        try {
            Note n = adp.getItem(sel);
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Вы уверены?");
            dialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    adp.remove(n);
                }
            });
            dialog.setNegativeButton("Нет", null);
            dialog.setIcon(getDrawable(R.drawable.myicon));
            dialog.show();
        }catch (Exception e){
            Toast.makeText(this, "Выберите заметку", Toast.LENGTH_SHORT).show();
        }

    }
}