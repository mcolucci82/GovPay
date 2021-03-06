/*
 * GovPay - Porta di Accesso al Nodo dei Pagamenti SPC 
 * http://www.gov4j.it/govpay
 * 
 * Copyright (c) 2014-2015 Link.it srl (http://www.link.it).
 * Copyright (c) 2014-2015 TAS S.p.A. (http://www.tasgroup.it).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package it.govpay.web.console.anagrafica.form;

import it.govpay.ejb.core.model.ConnettorePddModel;
import it.govpay.ejb.ndp.model.IntermediarioModel;
import it.govpay.web.console.anagrafica.bean.IntermediarioNdpBean;
import it.govpay.web.console.utils.Utils;

import java.io.Serializable;

import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.openspcoop2.generic_project.web.factory.FactoryException;
import org.openspcoop2.generic_project.web.form.CostantiForm;
import org.openspcoop2.generic_project.web.form.Form;
import org.openspcoop2.generic_project.web.impl.jsf1.form.BaseForm;
import org.openspcoop2.generic_project.web.input.Text;

@Named("intNdpForm")
public class IntermediarioNdpForm extends BaseForm implements Form,Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Text nomeSoggettoSPC;
	private Text idIntermediarioPA;
	
	private ConnettoreForm connettore;

	public IntermediarioNdpForm(){
		try {
			init();
		} catch (FactoryException e) {
		}
	}

	@Override
	public void init() throws FactoryException{
		this.setClosable(false);
		this.setId("formIntNdp");
		this.setNomeForm(null); 

		this.nomeSoggettoSPC = this.getWebGenericProjectFactory().getInputFieldFactory().createText();
		this.nomeSoggettoSPC.setRequired(true);
		this.nomeSoggettoSPC.setLabel(Utils.getInstance().getMessageFromResourceBundle("intermediariNdp.nomeSoggettoSPC"));
		this.nomeSoggettoSPC.setName("nomeSoggettoSPC");
		this.nomeSoggettoSPC.setValue(null);

		this.idIntermediarioPA = this.getWebGenericProjectFactory().getInputFieldFactory().createText();
		this.idIntermediarioPA.setRequired(true);
		this.idIntermediarioPA.setLabel(Utils.getInstance().getMessageFromResourceBundle("intermediariNdp.idIntermediarioPA"));
		this.idIntermediarioPA.setName("idIntermediarioPA");
		this.idIntermediarioPA.setValue(null);

		this.connettore = new ConnettoreForm();
		this.connettore.setConnettorePdd(true); 
		this.connettore.setForm(this); 
	}

	@Override
	public void reset() {
		this.nomeSoggettoSPC.reset();
		this.idIntermediarioPA.reset();
		this.connettore.reset();
	}

	/**
	 * Inizializza la form con i valori dell'elemento selezionato.
	 * 
	 * @param bean
	 */
	public void setValues(IntermediarioNdpBean bean){
		if(bean != null){
			this.nomeSoggettoSPC.setDefaultValue(bean.getDTO().getNomeSoggettoSPC());
			this.idIntermediarioPA.setDefaultValue(bean.getDTO().getIdIntermediarioPA());
			this.idIntermediarioPA.setDisabled(true);
			//this.password.setDefaultValue(bean.getDTO().getPassword());
			this.connettore.setValues(bean.getConnettore());
		} else {
			this.idIntermediarioPA.setDisabled(false);
			this.nomeSoggettoSPC.setDefaultValue(null);
			this.idIntermediarioPA.setDefaultValue(null);
			this.connettore.setValues(null);
		}

		this.reset();
	}

	public Text getNomeSoggettoSPC() {
		return nomeSoggettoSPC;
	}

	public void setNomeSoggettoSPC(Text nomeSoggettoSPC) {
		this.nomeSoggettoSPC = nomeSoggettoSPC;
	}

	public Text getIdIntermediarioPA() {
		return idIntermediarioPA;
	}

	public void setIdIntermediarioPA(Text idIntermediarioPA) {
		this.idIntermediarioPA = idIntermediarioPA;
	}

	public ConnettoreForm getConnettore() {
		return connettore;
	}

	public void setConnettore(ConnettoreForm connettore) {
		this.connettore = connettore;
	}
	
	
	public IntermediarioModel getIntermediario(){
		IntermediarioModel intermediarioModel = new IntermediarioModel();
		
		intermediarioModel.setIdIntermediarioPA(this.idIntermediarioPA.getValue());
		intermediarioModel.setNomeSoggettoSPC(this.nomeSoggettoSPC.getValue());
		//intermediarioModel.setPassword(this.password.getValue());
		
		intermediarioModel.setConnettoreServizioRPT((ConnettorePddModel)this.connettore.getConnettore());
		
		return intermediarioModel;
	}

	public String valida(){
		String _nomeSoggettoSPC = this.nomeSoggettoSPC.getValue();
		if(StringUtils.isEmpty(_nomeSoggettoSPC))
			return Utils.getInstance().getMessageWithParamsFromCommonsResourceBundle(CostantiForm.FIELD_NON_PUO_ESSERE_VUOTO, this.nomeSoggettoSPC.getLabel());

		String _idIntermediarioPA = this.idIntermediarioPA.getValue();
		if(StringUtils.isEmpty(_idIntermediarioPA))
			return Utils.getInstance().getMessageWithParamsFromCommonsResourceBundle(CostantiForm.FIELD_NON_PUO_ESSERE_VUOTO, this.idIntermediarioPA.getLabel());
	
		return this.connettore.valida();
	}

}
