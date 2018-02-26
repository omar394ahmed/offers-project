package org.spring.offers;





import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import org.spring.images.Image;

import org.spring.images.StorageService;


@RestController
public class Offers_Controller {
	
	
	@Autowired
	 private  Offers_Service offer_service ; 
	
	@Autowired
	private  StorageService  storageService ; 
	


	
	

	@RequestMapping( method=RequestMethod.POST ,     value= "/add_offer")
	public String add_offer(
			 @RequestParam("images") List<MultipartFile>  images ,
			 @RequestParam("offerName") String name  , 
			 @RequestParam("description") String description ,
			 @RequestParam("storeName") String storeName ,
			 @RequestParam("phoneNumber") String phoneNumber ,
			 @RequestParam("storeAddress") String address ,
			 @RequestParam("storeLocation") String location ,
			 @RequestParam("storeType") String type 
			 
			  ) {
		
		List<Image>   offer_images  = new ArrayList<>();
		List<String>  imagesNames   = new ArrayList<>();
		
    for( MultipartFile  image : images   ) {
    	 
    	String temporaryName =    storageService.store(image);
    	imagesNames.add(temporaryName);
    	
    }
    
    for( String   imageName : imagesNames   ) {
   	 
    	Image  temporaryImage = new Image(imageName );
    	 offer_images.add(temporaryImage);
    	
    }

		   Offer offer = new Offer();
		   offer.setOfferName(name);
		   offer.setDescription(description);
		   offer.setStoreName(storeName);
		   offer.setPhoneNumber(phoneNumber);
		   offer.setStoreAddress(address);
		   offer.setStoreLocation(location);
		   offer.setStoreType(type);
		   offer.setImage(offer_images);
		  
	       
	       
		  
		    offer_service.insert_data(offer );
		     return "added " ; 
		
	                      }	
	
	
	
	
	
	
	
	@GetMapping("/offers")
	@Produces(MediaType.APPLICATION_JSON)
	public  Offers  get_offers(){
		
	  Offers container = new Offers();	
	  List<Offer> offers = new ArrayList<>();
	  offers =  offer_service.get_offers();
	  container.myoffers = offers ; 
	  
	  
	  return container ; 
		
		
	}
	
	
   // view Custom offers 
	@RequestMapping( method=RequestMethod.GET ,    value= "/offers/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public  Offers  view_Custome_offers(@PathVariable String type) {
	 
		 Offers container = new Offers();
		 List<Offer>  offers = new ArrayList<>(); 
		 offers =  offer_service.get_offers_with_particularType(type);
	     container.myoffers = offers ; 
		 
		 return container ; 
		
		
	}
	
	
	@RequestMapping( method=RequestMethod.GET ,    value= "/add_like/{id}")
	public String  add_like( @PathVariable("id")   int id   ) {
		
	Offer offer = 	offer_service.get_offer_withID(id);
	offer.setLikes(offer.getLikes()+1);	
	offer_service.insert_data(offer);	
		
		return "done "  ; 
	}
	
	
	@RequestMapping( method=RequestMethod.GET ,    value= "/add_view/{id}")
	public String  add_view( @PathVariable("id")   int id   ) {
		
	Offer offer = 	offer_service.get_offer_withID(id);
	offer.setViews(offer.getViews()+1);	
	offer_service.insert_data(offer);	
		
		return "done "  ; 
	
	}
	
	
	
	/*@RequestMapping( method=RequestMethod.POST ,    value= "test" )

	public String test( @RequestParam("image") MultipartFile image ) {
		
	
		
		return name  ;
		
	}
	*/
	
	

}
