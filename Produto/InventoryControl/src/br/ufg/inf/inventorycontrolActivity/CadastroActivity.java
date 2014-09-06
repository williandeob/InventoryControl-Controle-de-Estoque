package br.ufg.inf.inventorycontrolActivity;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.inventorycontrolControle.ControleProdutos;
import br.ufg.inf.inventorycontrolModel.*;

import com.example.inventorycontrol.R;



import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class CadastroActivity extends Activity {
	private Spinner unidadeDeMedida;
	private ArrayAdapter<UnidadeDeMedida> mAdapater;
	public static List <UnidadeDeMedida> mItens;
	ControleProdutos controleCCA = new ControleProdutos();
	private Intent it;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		mItens=new ArrayList<UnidadeDeMedida>();
		populandoListaDeUnidadeDeMedidas();
		mAdapater = new ArrayAdapter<UnidadeDeMedida>(this, R.layout.activity_spinner, mItens);
		unidadeDeMedida= (Spinner) findViewById(R.id.spUnidadeDeMeida);
		mAdapater.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		unidadeDeMedida.setAdapter(mAdapater);
		
		ActionBar ab = getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		
	}
	
	public static void populandoListaDeUnidadeDeMedidas(){
		UnidadeDeMedida kg = new UnidadeDeMedida(0, "KG");
		mItens.add(kg);
		UnidadeDeMedida g = new UnidadeDeMedida(1, "g");
		mItens.add(g);
		UnidadeDeMedida l = new UnidadeDeMedida(2, "L");
		mItens.add(l);
		UnidadeDeMedida ml = new UnidadeDeMedida(3, "mL");
		mItens.add(ml);
		UnidadeDeMedida va = new UnidadeDeMedida(4, "Valor Absoluto");
		mItens.add(va);
		
	}
	
	public void incluir (View view){
		EditText nomeEt=(EditText) findViewById(R.id.etNome);
		EditText fabricanteEt=(EditText) findViewById(R.id.etFabricante);
		EditText quantidadeEt= (EditText) findViewById(R.id.etQuantidade);
	
		controleCCA.cadastraProduto(nomeEt.getText().toString(), fabricanteEt.getText().toString(),
				unidadeDeMedida.getSelectedItem().toString(), Integer.parseInt(quantidadeEt.getText().toString()));
		
		
		AlertDialog ad = new AlertDialog.Builder(this).create();
		ad.setTitle("Cadastro de Produto");
		ad.setMessage("Produto "+nomeEt.getText().toString()+" incluido com sucesso");
		ad.show();
		
		limparCampos();
		
		
	}
	
	public void limparCampos(){
		EditText nomeEt=(EditText) findViewById(R.id.etNome);
		EditText fabricanteEt=(EditText) findViewById(R.id.etFabricante);
		EditText quantidadeEt= (EditText) findViewById(R.id.etQuantidade);
		
		nomeEt.setText("");
		fabricanteEt.setText("");
		quantidadeEt.setText("");
		unidadeDeMedida.setSelection(0);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == android.R.id.home) {
			it = new Intent();
			it.setClass(this, ListarActivity.class);
			startActivity(it);	
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	

}
