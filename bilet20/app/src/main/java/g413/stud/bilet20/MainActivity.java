package g413.stud.bilet20;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode == 12345) {
            if (data != null) {
                int pos = data.getIntExtra("my note index", 1);
                String title = data.getStringExtra("my note title");
                String content = data.getStringExtra("my note content");
                Note n = adp.getItem(pos);
                n.title = title;
                n.content = content;
                adp.notifyDataSetChanged();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void on_new_click(View v){
        Note n = new Note();
        n.title = "New note";
        n.content = "Some content";
        adp.add(n);
        int pos = adp.getPosition(n);
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("my note index", pos);
        i.putExtra("my note title", n.title);
        i.putExtra("my note content", n.content);
        startActivityForResult(i, 12345);
    }
    public void on_edit_click(View v){
        try{
            Note n = adp.getItem(sel);
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("my note index", sel);
            i.putExtra("my note title", n.title);
            i.putExtra("my note content", n.content);
            startActivityForResult(i, 12345);
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
            dialog.setIcon(R.drawable.myicon);
            dialog.show();
        }catch (Exception e){
            Toast.makeText(this, "Выберите заметку", Toast.LENGTH_SHORT).show();
        }
    }
}