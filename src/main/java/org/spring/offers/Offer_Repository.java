package org.spring.offers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Offer_Repository   extends CrudRepository<Offer, String > {

 public List<Offer> findByStoreType(String type);
 
 public Offer findByOfferName(String type);
 
 public Offer findByOfferNumber(int number);
}
