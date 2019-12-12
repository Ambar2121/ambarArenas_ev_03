package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class github_act extends AppCompatActivity {

    private Spinner spUno;
    private TextView tvUno;
    private Button btnUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);
        spUno = findViewById(R.id.spn1);
        tvUno = findViewById(R.id.tv1);
        btnUno = findViewById(R.id.btn);
        Bundle b = this.getIntent().getExtras();
        String[] datos = b.getStringArray("ListaNombresLibros");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUno.setAdapter(adapter);


    }

    public void mostrar(View view){
        Bundle b = this.getIntent().getExtras();
        int[] datos1 = b.getIntArray("ListaCostosLibros");
        int valorFarenheit = datos1[0];
        int valorRevival = datos1[1];
        int valorElAlquimista = datos1[2];
        if(spUno.getSelectedItem().equals("Farenheit")){
            tvUno.setText("El valor de Farenheit es: "+ valorFarenheit);
        }
        if(spUno.getSelectedItem().equals("Revival")){
            tvUno.setText("El valor de Revival es: "+ valorRevival);
        }
        if(spUno.getSelectedItem().equals("Tesla")){

            tvUno.setText("El valor de El alquimista es: "+ valorElAlquimista);
        }
    }
}
