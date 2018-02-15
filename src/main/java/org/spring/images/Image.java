package org.spring.images;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import org.spring.offers.Offer;

@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ; 
	private String  imageName ;
 
   	
	
	
	
	
  

	public Image () { }
	 
	 public Image (String  Name  ) {
		 
		 this.setImageName(Name);
		 
	 }

	 
	 
	 
	 
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	
	  
	 
	
	

}
