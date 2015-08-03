
package br.gov.al.itec.negocio;
/**
     Atencao:   
     - Codigo gerado, nao modifique manualmente.
*/

import br.gov.al.itec.geral.controle.ControleGeral;
import br.gov.al.itec.geral.controle.ControleCrud;
import br.gov.al.itec.geral.controle.ControleGenerico;

public class CatalogoRegraNegocio
{

	private ControleGenerico controleGenerico;

private ControleGeral controleGeral;
private ControleCrud controleCrud;

public ControleGeral getControleGeral()
{
	return controleGeral;
}

public void setControleGeral(ControleGeral controleGeral)
{
	this.controleGeral = controleGeral;
}

public ControleCrud getControleCrud()
{
	return controleCrud;
}

public void setControleCrud(ControleCrud controleCrud)
{
	this.controleCrud = controleCrud;
}

	public br.gov.al.itec.geral.controle.ControleGenerico getControleGenerico()
	{
		return this.controleGenerico;
	}
	public void setControleGenerico(br.gov.al.itec.geral.controle.ControleGenerico controleGenerico)
	{
		this.controleGenerico = controleGenerico;
	}




}
