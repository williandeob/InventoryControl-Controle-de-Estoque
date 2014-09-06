package br.ufg.inf.inventorycontrolActivity;

import java.util.ArrayList;

import br.ufg.inf.inventorycontrolControle.ControleProdutos;
import br.ufg.inf.inventorycontrolModel.UnidadeDeMedida;

import com.example.inventorycontrol.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class EditarActivity extends Activity {
EditText nomeProdutoAlterado, fabricanteAlterado, quantidadeAlterado;
Spinner unidadeDeMedidaAlterado;
ControleProdutos controleProdutos;
private Intent it;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar);
        nomeProdutoAlterado=(EditText)findViewById(R.id.etNome);
        fabricanteAlterado=(EditText)findViewById(R.id.etFabricante);
        quantidadeAlterado=(EditText)findViewById(R.id.etQuantidade);
        unidadeDeMedidaAlterado=(Spinner)findViewById(R.id.spUnidadeDeMedida);
        
        CadastroActivity.mItens=new ArrayList<UnidadeDeMedida>();
		CadastroActivity.populandoListaDeUnidadeDeMedidas();
		ArrayAdapter<UnidadeDeMedida> mAdapter = new ArrayAdapter<UnidadeDeMedida>(this, R.layout.activity_spinner, CadastroActivity.mItens);
		mAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		unidadeDeMedidaAlterado.setAdapter(mAdapter);
        
        nomeProdutoAlterado.setText(""+ControleProdutos.produtosCadastrados.get(ListarActivity.posicaoSelecionadoDoArray).getNome());
		fabricanteAlterado.setText(""+ControleProdutos.produtosCadastrados.get(ListarActivity.posicaoSelecionadoDoArray).getFabricante());
		quantidadeAlterado.setText(""+ControleProdutos.produtosCadastrados.get(ListarActivity.posicaoSelecionadoDoArray).getQuantidade());
		
		for(int i=0; i<CadastroActivity.mItens.size();i++){
			if(ControleProdutos.produtosCadastrados.get(ListarActivity.posicaoSelecionadoDoArray)
					.getUnidadeDeMedida().equals(CadastroActivity.mItens.get(i).getNome())){
				     unidadeDeMedidaAlterado.setSelection(i);
				     break;
			}
		}
		
		ActionBar ab = getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		
	}
	
	
	public void editar(View view){
		controleProdutos = new ControleProdutos();
		controleProdutos.alterarProduto(ListarActivity.posicaoSelecionadoDoArray, 
				nomeProdutoAlterado.getText().toString(), fabricanteAlterado.getText().toString(), 
				unidadeDeMedidaAlterado.getSelectedItem().toString(), Integer.parseInt(quantidadeAlterado.getText().toString()));
		
	/*	AlertDialog dialog = new AlertDialog.Builder(this).create();
		dialog.setTitle("Alterando Produto");
		dialog.setMessage("Produto "+nomeProdutoAlterado.getText().toString()+" alterado com sucesso");
		dialog.show();
		
		*/
		it=new Intent();
		it.setClass(this, ConsultaActivity.class);
		startActivity(it);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		it = new Intent();
		if (id == android.R.id.home) {
			it.setClass(this, ConsultaActivity.class);
			startActivity(it);	
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	

}
