package br.ufg.inf.inventorycontrolActivity;

import java.util.ArrayList;

import br.ufg.inf.inventorycontrolControle.ControleProdutos;
import br.ufg.inf.inventorycontrolModel.Produto;

import com.example.inventorycontrol.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListarActivity extends Activity{
	private Intent it;
	public static int posicaoSelecionadoDoArray;
	
	private static ArrayList<String> populandoListView (ArrayList<Produto> produtos){
		ArrayList<String> nomeProdutoCadastro = new ArrayList<String>();
		
		for(int i=0; i<produtos.size(); i++){
			nomeProdutoCadastro.add(produtos.get(i).getNome()+" "+produtos.get(i).getFabricante()+" - "
		+produtos.get(i).getQuantidade()+" "+produtos.get(i).getUnidadeDeMedida());
		}
		
		return nomeProdutoCadastro;
	}
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listar);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,
				populandoListView(ControleProdutos.produtosCadastrados));
		ListView lv = (ListView) findViewById(R.id.lListView);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(chamarAtividade());
		
	}
	
	
	
	private OnItemClickListener chamarAtividade() {
		      return (new OnItemClickListener() {
		@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
			
		            posicaoSelecionadoDoArray=position;
		            
					it = new Intent(getBaseContext(), ConsultaActivity.class);
					startActivity(it);
				}
			});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.add) {
			it=new Intent();
			it.setClass(this, CadastroActivity.class);
			startActivity(it);
			return true;
		}
	
		return super.onOptionsItemSelected(item);
	}
}
