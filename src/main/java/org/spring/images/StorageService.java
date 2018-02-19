package org.spring.images;






import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import org.springframework.web.multipart.MultipartFile;


@Service
public class StorageService {
	
	@Autowired
	private  Image_Repository repository ; 
	
	public  static Image image ; 
	
	private List<Image> images ; 
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	
	
	 static String  demo = new File("").getAbsolutePath();
	 static String demo2 = demo.concat("//images");
	
	
	// private final static Path rootLocation = Paths.get(demo2);
	
	 private final static Path rootLocation = Paths.get("C:\\Users\\omar\\Documents\\workspace-sts-3.9.0.RELEASE\\Backend_API\\src\\main\\webapp\\images");

	public String  store(MultipartFile file){
		try {
			
			System.out.println(StorageService.rootLocation);
            Files.copy(file.getInputStream(), StorageService.rootLocation.resolve(file.getOriginalFilename()));
            
           String image_name = file.getOriginalFilename();
            //Path new_path = StorageService.rootLocation.resolve(file.getOriginalFilename());
          
          //  image =  new Image(new_path.toString());
            
          //repository.save(image);
            
          return  image_name ;
        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
	}
	
	
	public List<Image>  get_Images(){
		images = new ArrayList<>();
		repository.findAll().
		forEach(images::add);
		
		return images ; 
		
		
	}

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
            	throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
        	throw new RuntimeException("FAIL!");
        }
    }
    
    public static    void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public   static void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
         //   throw new RuntimeException(e);
            
        }
        
    }
    
    
    
   public  static void   welcome_method() {
		
		String  demo = new File("").getAbsolutePath();
		String demo2 = demo.concat("\\photos");
		
		    System.out.println(demo2);
	}
}