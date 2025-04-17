package g413.stud.bilet1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txta, txtb;
    TextView txtresult;

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

        txta = findViewById(R.id.txtinputa);
        txtb = findViewById(R.id.txtinputb);
        txtresult = findViewById(R.id.txtoutput);
    }

    public void onAdd_click(View v){
        if (txta.getText().toString().isEmpty() || txtb.getText().toString().isEmpty()){
            txtresult.setText("Введите значения");
        }
        else {
            double a = Double.parseDouble(txta.getText().toString());
            double b = Double.parseDouble(txtb.getText().toString());
            txtresult.setText(String.valueOf(a+b));
        }
    }
    public void onSub_click(View v){
        if (txta.getText().toString().isEmpty() || txtb.getText().toString().isEmpty()){
            txtresult.setText("Введите значения");
        }
        else {
            double a = Double.parseDouble(txta.getText().toString());
            double b = Double.parseDouble(txtb.getText().toString());
            txtresult.setText(String.valueOf(a-b));
        }
    }
    public void onMul_click(View v){
        if (txta.getText().toString().isEmpty() || txtb.getText().toString().isEmpty()){
            txtresult.setText("Введите значения");
        }
        else {
            double a = Double.parseDouble(txta.getText().toString());
            double b = Double.parseDouble(txtb.getText().toString());
            txtresult.setText(String.valueOf(a*b));
        }
    }
    public void onDiv_click(View v){
        if (txta.getText().toString().isEmpty() || txtb.getText().toString().isEmpty()){
            txtresult.setText("Введите значения");
        }
        else {
            if (!txtb.getText().toString().equals("0")){
                double a = Double.parseDouble(txta.getText().toString());
                double b = Double.parseDouble(txtb.getText().toString());
                txtresult.setText(String.valueOf(a/b));
            }
            else txtresult.setText("На 0 делить нельзя");
        }
    }
    public void onSin_click(View v){
        if (txta.getText().toString().isEmpty()){
            txtresult.setText("Введите значение");
        }
        else {
            double a = Double.parseDouble(txta.getText().toString());
            txtresult.setText(String.valueOf(Math.sin(a)));
        }
    }
    public void onCos_click(View v){
        if (txta.getText().toString().isEmpty()){
            txtresult.setText("Введите значение");
        }
        else {
            double a = Double.parseDouble(txta.getText().toString());
            txtresult.setText(String.valueOf(Math.cos(a)));
        }
    }
    public void onTan_click(View v){
        if (txta.getText().toString().isEmpty()){
            txtresult.setText("Введите значение");
        }
        else {
            try {
                double a = Double.parseDouble(txta.getText().toString());
                txtresult.setText(String.valueOf(Math.tan(a)));
            }
            catch (Exception e){
                txtresult.setText("Значение не существует");
            }
        }
    }
    public void onPi_click(View v){
        txta.setText(String.valueOf(Math.PI));
    }
    public void onE_click(View v){
        txta.setText(String.valueOf(Math.E));
    }
}