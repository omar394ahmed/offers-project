package org.spring.offers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.spring.images.Image;





@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int     offerNumber ;
	private String  offerName ; 
	private String  description;
	private String  storeName ;
	private String  phoneNumber ;
	private String  storeAddress ;
	private String  storeLocation ; 
	private String  storeType ; 
	
	private int likes ; 
	private int views ; 
	private boolean premier ; 
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Image> image ; 
	
	
	


	public List<Image> getImage() {
		return image;
	}


	public void setImage(List<Image> image) {
		this.image = image;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public boolean isPremier() {
		return premier;
	}


	public void setPremier(boolean premier) {
		this.premier = premier;
	}


	


	public int getOfferNumber() {
		return offerNumber;
	}


	public void setOfferNumber(int offerNumber) {
		this.offerNumber = offerNumber;
	}


	public String getOfferName() {
		return offerName;
	}


	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}




	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreLocation() {
		return storeLocation;
	}


	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}


	public String getStoreType() {
		return storeType;
	}


	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}



	
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getStoreAddress() {
		return storeAddress;
	}


	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}




	
	
}
