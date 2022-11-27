package pe.idat.joeinventoryapp.OpcionesProducto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import pe.idat.joeinventoryapp.R;

public class Agregar_Producto extends AppCompatActivity {

  EditText EtTitulo,EtProducto,EtNombreProveedor,EtCorreoProveedor,EtNota,EtStock;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_agregar_producto);
    ActionBar actionBar=getSupportActionBar();
    assert actionBar != null;
    actionBar.setTitle("");


  }

  private void InicializarVariables(){
    EtTitulo=findViewById((R.id.EtTitulo));
    EtProducto=findViewById(R.id.EtProducto);
    EtNombreProveedor=findViewById(R.id.EtNombreProveedor);
    EtCorreoProveedor=findViewById(R.id.EtCorreoProveedor);
    EtNota=findViewById(R.id.EtNota);
    EtStock=findViewById(R.id.EtStock);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater=getMenuInflater();
    menuInflater.inflate(R.menu.menu_guardar,menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if (item.getItemId()== R.id.Guardar_Producto){
      Toast.makeText(this, "Guardar Producto", Toast.LENGTH_SHORT).show();
    }
    return super.onOptionsItemSelected(item);
  }
}