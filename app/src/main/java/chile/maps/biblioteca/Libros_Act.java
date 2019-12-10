package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Libros_Act extends AppCompatActivity {
    private EditText etUno, etDos;
    private Button btnUno;
    private Spinner spnUno;
    private TextView tvUno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_);
        etUno = findViewById(R.id.et1);
        etDos = findViewById(R.id.et2);
        btnUno = findViewById(R.id.btn1);
        spnUno = findViewById(R.id.spn1);
        tvUno = findViewById(R.id.tv1);
        recibirDatos();
    }

    public void recibirDatos(){
        Bundle b = this.getIntent().getExtras();
        String[] datos = b.getStringArray("ListaNombresLibros");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnUno.setAdapter(adapter);

    }
    public void xd(View view){
        Bundle b = this.getIntent().getExtras();
        int[] datos1 = b.getIntArray("ListaCostosLibros");
        int valorFarenheit = datos1[0];
        int valorRevival = datos1[1];
        int valorTesla = datos1[2];
        if(spnUno.getSelectedItem().equals("Farenheit")){
            int stock = Integer.parseInt(etUno.getText().toString());
            int costoPrestamo = Integer.parseInt(etDos.getText().toString());
            int total = ((valorFarenheit*stock)+costoPrestamo);
            tvUno.setText("Stock disponible: \n"+ stock + "El costo total es: "+ total);
        }
        if(spnUno.getSelectedItem().equals("Revival")){
            int stock = Integer.parseInt(etUno.getText().toString());
            int costoPrestamo = Integer.parseInt(etDos.getText().toString());
            int total = ((valorRevival*stock)+costoPrestamo);
            tvUno.setText("Stock disponible: "+ stock + "El costo total es: "+ total);
        }
        if(spnUno.getSelectedItem().equals("Tesla")){
            int stock = Integer.parseInt(etUno.getText().toString());
            int costoPrestamo = Integer.parseInt(etDos.getText().toString());
            int total = ((valorTesla*stock)+costoPrestamo);
            tvUno.setText("Stock disponible: "+ stock + "El costo total es: "+ total);
        }
    }

}
