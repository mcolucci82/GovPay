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
package it.govpay.web.console.anagrafica.iservice;

import it.govpay.web.console.anagrafica.bean.PspBean;
import it.govpay.web.console.anagrafica.form.PspSearchForm;

import org.openspcoop2.generic_project.exception.ServiceException;
import org.openspcoop2.generic_project.web.iservice.IBaseService;

public interface IPspService extends IBaseService<PspBean, Long, PspSearchForm>{

	public void aggiornaListaPsp() throws ServiceException;
}
