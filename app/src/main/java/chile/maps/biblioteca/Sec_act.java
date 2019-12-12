package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sec_act extends AppCompatActivity {

    private Button btnUno, btnDos;
    private TextView tvUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_act);
        btnUno = findViewById(R.id.btn1);
        btnDos  = findViewById(R.id.btn2);
        tvUno = findViewById(R.id.tv1);
    }
    public void onClickIncidenciaUno(View view){
        String[] pass = {"123","hola"};
        tvUno.setText("Hardcoded");
    }
}
