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
package it.govpay.ejb.core.utils.rs.client;

import it.govpay.ejb.core.exception.GovPayException;
import it.govpay.ejb.core.exception.GovPayException.GovPayExceptionEnum;
import it.govpay.ejb.core.model.ConnettoreModel;
import it.govpay.ejb.core.model.ConnettoreModel.EnumAuthType;
import it.govpay.ejb.core.model.ConnettoreModel.EnumSslType;

import java.io.FileInputStream;
import java.net.URL;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class BasicClient {
	
	protected static Map<String, SSLContext> sslContexts = new HashMap<String, SSLContext>();
	protected URL url = null;
	protected SSLContext sslContext;
	protected boolean ishttpBasicEnabled=false, isSslEnabled=false;
	protected String httpBasicUser, httpBasicPassword;
	
	public BasicClient(String idEnteCreditore, ConnettoreModel connettore) throws GovPayException {
		
		if(connettore == null) {
			return;
		}
		
		try {
			this.url =  new URL(connettore.getUrl());
		} catch (Exception e) {
			throw new GovPayException(GovPayExceptionEnum.ERRORE_CONFIGURAZIONE, "La URL del connettore [" + connettore.getIdConnettore() + "] non e' valida: " + e);
		}
		sslContext = sslContexts.get(idEnteCreditore);
		
		if(connettore.getTipoAutenticazione().equals(EnumAuthType.SSL)) {
			isSslEnabled = true;
			if(sslContext == null) {
				try {
					FileInputStream finKeyStore = null;
					FileInputStream finTrustStore = null;
						
					KeyManager[] km = null;
					TrustManager[] tm = null;
			
					// Autenticazione CLIENT
					if(connettore.getTipoSsl().equals(EnumSslType.CLIENT)){
						
						if(connettore.getSslKsType() == null || 
								connettore.getSslKsLocation() == null ||
								connettore.getSslKsPasswd() == null ||
								connettore.getSslPKeyPasswd() == null)
								throw new GovPayException(GovPayExceptionEnum.ERRORE_CONFIGURAZIONE,"Configurazione SSL Client incompleta.");	
						
						KeyStore keystore = KeyStore.getInstance(connettore.getSslKsType()); // JKS,PKCS12,jceks,bks,uber,gkr
						finKeyStore = new FileInputStream(connettore.getSslKsLocation());
						keystore.load(finKeyStore, connettore.getSslKsPasswd().toCharArray());
						KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
						keyManagerFactory.init(keystore, connettore.getSslPKeyPasswd().toCharArray());
						km = keyManagerFactory.getKeyManagers();
					}
					
					if(connettore.getSslTsType() == null || 
							connettore.getSslTsLocation() == null ||
							connettore.getSslTsPasswd() == null || 
							connettore.getSslType() == null)
							throw new GovPayException(GovPayExceptionEnum.ERRORE_CONFIGURAZIONE,"Configurazione SSL Server incompleta.");	
			
					// Autenticazione SERVER
					KeyStore truststore = KeyStore.getInstance(connettore.getSslTsType()); // JKS,PKCS12,jceks,bks,uber,gkr
					finTrustStore = new FileInputStream(connettore.getSslTsLocation());
					truststore.load(finTrustStore, connettore.getSslTsPasswd().toCharArray());
					TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
					trustManagerFactory.init(truststore);
					tm = trustManagerFactory.getTrustManagers();
		
					// Creo contesto SSL
					sslContext = SSLContext.getInstance(connettore.getSslType());
					sslContext.init(km, tm, null);
					sslContexts.put(idEnteCreditore, sslContext);
				} catch (Exception e) {
					throw new GovPayException(GovPayExceptionEnum.ERRORE_CONFIGURAZIONE, "Configurazione del connettore SSL errata. Connettore  [" + connettore.getIdConnettore() + "] ", e);
				}
			}
		}
		
		if(connettore.getTipoAutenticazione().equals(EnumAuthType.HTTPBasic)) {
			ishttpBasicEnabled = true;
			httpBasicUser = connettore.getHttpUser();
			httpBasicPassword = connettore.getHttpPassw();
		}
	}
	
	public static void cleanCache(String idEnteCreditore) {
		sslContexts.remove(idEnteCreditore);
	}

}
