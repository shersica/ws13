package sg.edu.nus.ssf.ws13.ws13;

import java.io.File;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ws13Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Ws13Application.class);

		ApplicationArguments argOptions = new DefaultApplicationArguments(args);

		if(argOptions.containsOption("dataDir")){
			final String dataDir = argOptions.getOptionValues("dataDir").get(0);

			File fileDir = new File(dataDir);
			if(!fileDir.exists()){
				fileDir.mkdir();
				System.out.println("Directory created");
				System.out.println(">>>" + fileDir.getAbsolutePath());
			} else {
				System.out.println(fileDir.getAbsolutePath());
			}
			
		} else {
			System.out.println("Error, please input directory");
		}

		SpringApplication.run(Ws13Application.class, args);
	}

}
