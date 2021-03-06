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
package it.govpay.ejb.core.model;

/* vedi tabella pagamenti_online */
public class TrackingOperazioniPagamentoModel {

	public enum EnumTipoTrackingOperazione {

		AUTORIZZAZIONE("AUP", "Autorizzazione"), 
		ANNULLAMENTO("ANP", "Annullamento"), 
		ESTRATTOCONTO("ECD", "Estratto Conto Debitorio"), 
		NOTIFICA_SBF("NOS", "Notifica sbf"), 
		NOTIFICA("NOP", "Notifica"), 
		STORNO("STO", "Storno"), 
		VERIFICA("VER", "Verifica");

		private String chiave;
		private String descrizione;

		EnumTipoTrackingOperazione(String chiave, String descrizione) {
			this.chiave = chiave;
			this.descrizione = descrizione;
		}

		public String getChiave() {
			return chiave;
		}

		public void setChiave(String chiave) {
			this.chiave = chiave;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}
	}


	//TODO: [SR] Gestire Anche dei campi qui.
	
	
}
