package com.example.proyectofinalprimertrimestre;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinalprimertrimestre.utilidades.utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoId, campoNombre, campoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoId= (EditText) findViewById(R.id.campoId);
        campoNombre= (EditText) findViewById(R.id.campoNombre);
        campoTelefono= (EditText) findViewById(R.id.campoTelefono);

    }

    public void onClick(View view){
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd usuarios", null, 1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());

        Long idResultante=db.insert(utilidades.TABLA_USUARIO,utilidades.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro:"+idResultante, Toast.LENGTH_SHORT).show();

        db.close();

    }

}
