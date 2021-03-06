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
package it.govpay.ejb.ndp.model;

import java.math.BigDecimal;
import java.util.Date;

import it.govpay.ejb.core.model.PagamentoModel;

public class RendicontazionePagamentoModel {
	
	private PagamentoModel pagamento;
	private String esitoPagamento;
	private String identificativoUnivocoRiscossione;
	private String identificativoUnivocoVersamento;
	private String codAnomalia;
	private boolean riconciliato;
	private Date dataEsitoPagamento;
	private BigDecimal importoPagato;
	
	public PagamentoModel getPagamento() {
		return pagamento;
	}
	public void setPagamento(PagamentoModel pagamento) {
		this.pagamento = pagamento;
	}
	public String getEsitoPagamento() {
		return esitoPagamento;
	}
	public void setEsitoPagamento(String esitoPagamento) {
		this.esitoPagamento = esitoPagamento;
	}
	public Date getDataEsitoPagamento() {
		return dataEsitoPagamento;
	}
	public void setDataEsitoPagamento(Date dataEsitoPagamento) {
		this.dataEsitoPagamento = dataEsitoPagamento;
	}
	public BigDecimal getImportoPagato() {
		return importoPagato;
	}
	public void setImportoPagato(BigDecimal importoPagato) {
		this.importoPagato = importoPagato;
	}
	public boolean isRiconciliato() {
		return riconciliato;
	}
	public void setRiconciliato(boolean riconciliato) {
		this.riconciliato = riconciliato;
	}
	public String getCodAnomalia() {
		return codAnomalia;
	}
	public void setCodAnomalia(String codAnomalia) {
		this.codAnomalia = codAnomalia;
	}
	public String getIdentificativoUnivocoRiscossione() {
		return identificativoUnivocoRiscossione;
	}
	public void setIdentificativoUnivocoRiscossione(
			String identificativoUnivocoRiscossione) {
		this.identificativoUnivocoRiscossione = identificativoUnivocoRiscossione;
	}
	public String getIdentificativoUnivocoVersamento() {
		return identificativoUnivocoVersamento;
	}
	public void setIdentificativoUnivocoVersamento(
			String identificativoUnivocoVersamento) {
		this.identificativoUnivocoVersamento = identificativoUnivocoVersamento;
	}
}
