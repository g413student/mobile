package g413.stud.bilet16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;
    ArrayAdapter <String> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.spinnerFrom);
        spTo = findViewById(R.id.spinnerTo);
        etFrom = findViewById(R.id.TextInput);
        tvTo = findViewById(R.id.TextOut);

        adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);


        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }
    public void on_convert(View v)
    {
        if (etFrom.getText().toString().equals("")){
            tvTo.setText("Введите значение");
            return;
        }
        float from = Float.parseFloat(etFrom.getText().toString());

        String sFrom = (String) spFrom.getSelectedItem();
        String sTo = (String) spTo.getSelectedItem();

        float to = 0.0f;

        if (sFrom.equals("mm"))
        {
            if (sTo.equals("mm")) to = from;
            if (sTo.equals("cm")) to = from * 0.1f;
            if (sTo.equals("m")) to = from * 0.001f;
            if (sTo.equals("km")) to = from * 0.000001f;
        }

        if (sFrom.equals("cm"))
        {
            if (sTo.equals("mm")) to = from * 10.0f;
            if (sTo.equals("cm")) to = from;
            if (sTo.equals("m")) to = from * 0.01f;
            if (sTo.equals("km")) to = from * 0.00001f;
        }

        if (sFrom.equals("m"))
        {
            if (sTo.equals("mm")) to = from * 1000.0f;
            if (sTo.equals("cm")) to = from * 100f;
            if (sTo.equals("m")) to = from;
            if (sTo.equals("km")) to = from * 0.001f;
        }

        if (sFrom.equals("km"))
        {
            if (sTo.equals("mm")) to = from * 1000000.0f;
            if (sTo.equals("cm")) to = from * 100000.0f;
            if (sTo.equals("m")) to = from * 1000.0f;
            if (sTo.equals("km")) to = from;
        }



        // Единицы измерения информации
        if (sFrom.equals("bit"))
        {
            if (sTo.equals("bit")) to = from;
            if (sTo.equals("B")) to = from / 8.0f;
            if (sTo.equals("Kb")) to = from / (8.0f * 1024.0f);
            if (sTo.equals("Mb")) to = from / (8.0f * 1024.0f * 1024.0f);
            if (sTo.equals("Gb")) to = from / (8.0f * 1024.0f * 1024.0f * 1024.0f);
        }

        if (sFrom.equals("B"))
        {
            if (sTo.equals("bit")) to = from * 8.0f;
            if (sTo.equals("B")) to = from;
            if (sTo.equals("Kb")) to = from / (1024.0f);
            if (sTo.equals("Mb")) to = from / (1024.0f * 1024.0f);
            if (sTo.equals("Gb")) to = from / (1024.0f * 1024.0f * 1024.0f);
        }

        if (sFrom.equals("Kb"))
        {
            if (sTo.equals("bit")) to = from * 8.0f * 1024.0f;
            if (sTo.equals("B")) to = from * 1024.0f;
            if (sTo.equals("Kb")) to = from;
            if (sTo.equals("Mb")) to = from / (1024.0f);
            if (sTo.equals("Gb")) to = from / (1024.0f * 1024.0f);
        }

        if (sFrom.equals("Mb"))
        {
            if (sTo.equals("bit")) to = from * 8.0f * 1024.0f * 1024.0f;
            if (sTo.equals("B")) to = from * 1024.0f * 1024.0f;
            if (sTo.equals("Kb")) to = from * 1024.0f;
            if (sTo.equals("Mb")) to = from;
            if (sTo.equals("Gb")) to = from / (1024.0f);
        }

        if (sFrom.equals("Gb"))
        {
            if (sTo.equals("bit")) to = from * 8.0f * 1024.0f * 1024.0f * 1024.0f;
            if (sTo.equals("B")) to = from * 1024.0f * 1024.0f * 1024.0f;
            if (sTo.equals("Kb")) to = from * 1024.0f * 1024.0f;
            if (sTo.equals("Mb")) to = from * 1024.0f;
            if (sTo.equals("Gb")) to = from;
        }

        tvTo.setText(String.format("%.4f", to));
    }

    public void onCheckboxClicked(View view) {
        CheckBox checkBox = (CheckBox) view;
        if(checkBox.isChecked()) {
            adp.clear();
            adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);
            adp.add("bit");
            adp.add("B");
            adp.add("Kb");
            adp.add("Mb");
            adp.add("Gb");
            spFrom.setAdapter(adp);
            spTo.setAdapter(adp);
        }
        else {
            adp.clear();
            adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);
            adp.add("mm");
            adp.add("cm");
            adp.add("m");
            adp.add("km");
            spFrom.setAdapter(adp);
            spTo.setAdapter(adp);
        }
    }

}