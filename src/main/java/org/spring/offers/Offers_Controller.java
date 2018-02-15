package org.spring.offers;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
	


	
	private List<Offer> offers  ;

	@RequestMapping( method=RequestMethod.POST ,     value= "/add_offer")
	@ResponseBody
	 public String add_offer(@RequestParam("main_image") MultipartFile  main_image   ,
			 @RequestParam("image1") MultipartFile  image1 ,
		 @RequestParam("offerName") String name  , 
			 
			 @RequestParam("describtion") String description ,
			 @RequestParam("storeName") String storeName ,
			 @RequestParam("storeLocation") String location ,
			 @RequestParam("storeType") String type 
			 
			  ) {
		
		List<Image>  offer_images = new ArrayList<>();
		
	//	save images on folder 
		  String image_name =     storageService.store(main_image);
		  Image image      = new Image(image_name  );
	
		  
   // create  images instances  	  
		  
		  String image1_name =    storageService.store(image1);
		  Image  test_image = new Image(image1_name );
		  
		 
	      
		   //add images to offer 
	       offer_images.add(image);
	       offer_images.add(test_image);
		
		  
		  
		  
		   Offer offer = new Offer();
		   offer.setOfferName(name);
		   offer.setDescription(description);
		   offer.setStoreName(storeName);
		   offer.setStoreLocation(location);
		   offer.setStoreType(type);
		   offer.setImage(offer_images);
		  
	       
	       
		
		   offer_service.insert_data(offer );
		     return "added " ; 
		
	                      }	
	
	
	
	
	
	
	
	@GetMapping("/offers")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Offer>  get_offers(){
		
	  List<Offer> offers = new ArrayList<>();
	  offers =  offer_service.get_offers();
	  
	  return offers ; 
		
		
	}
	
	
   // view Custom offers 
	@RequestMapping( method=RequestMethod.GET ,    value= "/offers/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Offer>   view_Custome_offers(@PathVariable String type) {
	 
		 offers = new ArrayList<>(); 
		 offers =  offer_service.get_offers_with_particularType(type);
	
		 return offers ; 
		
		
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
	
	
	
	@RequestMapping( method=RequestMethod.GET ,    value= "test")
	public String test(HttpServletRequest request) {
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/");
		
		return path ;
		
	}
	
	
	

}
