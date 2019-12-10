package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Base_act extends AppCompatActivity {
    private EditText etUno,etDos,etTres;
    private Button btnUno,btnDos,btnTres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);
        etUno = findViewById(R.id.et1);
        etDos = findViewById(R.id.et2);
        etTres = findViewById(R.id.et3);
        btnUno = findViewById(R.id.btn1);
        btnDos = findViewById(R.id.btn2);
        btnTres = findViewById(R.id.btn3);
    }

    public void AñadirLibro(View view ){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!etUno.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",etUno.getText().toString());
            registro.put("nombre",etDos.getText().toString());
            registro.put("precio",etTres.getText().toString());

            BaseDeDatos.insert("libros",null,registro);

            BaseDeDatos.close();

            Toast.makeText(this, "Se ha ingresado un Libro.", Toast.LENGTH_LONG).show();
        }
    }
    public void EliminarLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = etUno.getText().toString();

        BaseDeDatos.delete("libros","codigo="+codigo,null);
        BaseDeDatos.close();
        Toast.makeText(this, "Se ha eliminado un Libro con el codigo: "+codigo, Toast.LENGTH_LONG).show();
    }
    public void ModificarLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BIBLIOTECA",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("codigo", etUno.getText().toString());
        content.put("nombre", etDos.getText().toString());
        content.put("precio", etTres.getText().toString());

        String codigo = etUno.getText().toString();
        if(!etUno.getText().toString().isEmpty()) {
            BaseDeDatos.update("libros", content, "codigo=" + codigo, null);
            Toast.makeText(this, "Se ha actualizado un Libro con el codigo: "+codigo, Toast.LENGTH_LONG).show();
        }
    }
}
