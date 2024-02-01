package it.corso.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dao.DettaglioDao;
import it.corso.model.Dettaglio;

public class DettaglioServiceImpl implements DettaglioService {

	@Autowired
	private DettaglioDao dettaglioDao;

	@Override
	public Dettaglio getDettaglioById(int id) {
		
		return dettaglioDao.findById(id).get();
	}

}
