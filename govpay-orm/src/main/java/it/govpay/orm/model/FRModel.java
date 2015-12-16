/*
 * GovPay - Porta di Accesso al Nodo dei Pagamenti SPC 
 * http://www.gov4j.it/govpay
 * 
 * Copyright (c) 2014-2015 Link.it srl (http://www.link.it).
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
package it.govpay.orm.model;

import it.govpay.orm.FR;

import org.openspcoop2.generic_project.beans.AbstractModel;
import org.openspcoop2.generic_project.beans.IField;
import org.openspcoop2.generic_project.beans.Field;
import org.openspcoop2.generic_project.beans.ComplexField;


/**     
 * Model FR 
 *
 * @author Giovanni Bussu (bussu@link.it)
 * @author Lorenzo Nardi (nardi@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class FRModel extends AbstractModel<FR> {

	public FRModel(){
	
		super();
	
		this.ID_TRACCIATO_XML = new it.govpay.orm.model.IdTracciatoModel(new Field("idTracciatoXML",it.govpay.orm.IdTracciato.class,"FR",FR.class));
		this.ID_PSP = new it.govpay.orm.model.IdPspModel(new Field("idPsp",it.govpay.orm.IdPsp.class,"FR",FR.class));
		this.COD_FLUSSO = new Field("codFlusso",java.lang.String.class,"FR",FR.class);
		this.ANNO_RIFERIMENTO = new Field("annoRiferimento",int.class,"FR",FR.class);
		this.DATA_ORA_FLUSSO = new Field("dataOraFlusso",java.util.Date.class,"FR",FR.class);
		this.IUR = new Field("iur",java.lang.String.class,"FR",FR.class);
		this.DATA_REGOLAMENTO = new Field("dataRegolamento",java.util.Date.class,"FR",FR.class);
		this.NUMERO_PAGAMENTI = new Field("numeroPagamenti",long.class,"FR",FR.class);
		this.IMPORTO_TOTALE_PAGAMENTI = new Field("importoTotalePagamenti",double.class,"FR",FR.class);
		this.STATO = new Field("stato",java.lang.String.class,"FR",FR.class);
		this.DESCRIZIONE_STATO = new Field("descrizioneStato",java.lang.String.class,"FR",FR.class);
	
	}
	
	public FRModel(IField father){
	
		super(father);
	
		this.ID_TRACCIATO_XML = new it.govpay.orm.model.IdTracciatoModel(new ComplexField(father,"idTracciatoXML",it.govpay.orm.IdTracciato.class,"FR",FR.class));
		this.ID_PSP = new it.govpay.orm.model.IdPspModel(new ComplexField(father,"idPsp",it.govpay.orm.IdPsp.class,"FR",FR.class));
		this.COD_FLUSSO = new ComplexField(father,"codFlusso",java.lang.String.class,"FR",FR.class);
		this.ANNO_RIFERIMENTO = new ComplexField(father,"annoRiferimento",int.class,"FR",FR.class);
		this.DATA_ORA_FLUSSO = new ComplexField(father,"dataOraFlusso",java.util.Date.class,"FR",FR.class);
		this.IUR = new ComplexField(father,"iur",java.lang.String.class,"FR",FR.class);
		this.DATA_REGOLAMENTO = new ComplexField(father,"dataRegolamento",java.util.Date.class,"FR",FR.class);
		this.NUMERO_PAGAMENTI = new ComplexField(father,"numeroPagamenti",long.class,"FR",FR.class);
		this.IMPORTO_TOTALE_PAGAMENTI = new ComplexField(father,"importoTotalePagamenti",double.class,"FR",FR.class);
		this.STATO = new ComplexField(father,"stato",java.lang.String.class,"FR",FR.class);
		this.DESCRIZIONE_STATO = new ComplexField(father,"descrizioneStato",java.lang.String.class,"FR",FR.class);
	
	}
	
	

	public it.govpay.orm.model.IdTracciatoModel ID_TRACCIATO_XML = null;
	 
	public it.govpay.orm.model.IdPspModel ID_PSP = null;
	 
	public IField COD_FLUSSO = null;
	 
	public IField ANNO_RIFERIMENTO = null;
	 
	public IField DATA_ORA_FLUSSO = null;
	 
	public IField IUR = null;
	 
	public IField DATA_REGOLAMENTO = null;
	 
	public IField NUMERO_PAGAMENTI = null;
	 
	public IField IMPORTO_TOTALE_PAGAMENTI = null;
	 
	public IField STATO = null;
	 
	public IField DESCRIZIONE_STATO = null;
	 

	@Override
	public Class<FR> getModeledClass(){
		return FR.class;
	}
	
	@Override
	public String toString(){
		if(this.getModeledClass()!=null){
			return this.getModeledClass().getName();
		}else{
			return "N.D.";
		}
	}

}