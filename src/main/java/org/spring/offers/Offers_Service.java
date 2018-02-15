package org.spring.offers;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.List;


import org.spring.images.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Offers_Service {
	
	
	
	
	@Autowired
    private  Offer_Repository repository ; 
	
	@Autowired 
	StorageService storageService ; 
	
	private List<Offer> offers  ;
	
	
	public void insert_data(Offer offer) {
		
		repository.save(offer);
		
	}


	public List<Offer> get_offers() {
		offers = new ArrayList<>();
		repository.findAll().
		forEach(offers::add  );
		return offers ; 
		
		
	
	}
	
	
	
   
	public List<Offer> get_offers_with_particularType(String type) {
		offers = new ArrayList<>();
		repository.findByStoreType(type).
		forEach(offers::add  );
		return offers ; 
		
		
	
	}


	public Offer get_offer(int  number) {

	Offer offer	 =  repository.findByOfferNumber(number);
	return offer ; 
		
	}


	public Offer   get_offer_withID(int id) {
		
		Offer offer =   repository.findByOfferNumber(id);
		
		return offer ; 
	}
	
	
	
	

}
