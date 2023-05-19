package dev.florinchristian.webportofoliomessaging;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class WebPortofolioMessagingApplication {

	public static void main(String[] args) throws IOException {
		initializeFirebase();
		SpringApplication.run(WebPortofolioMessagingApplication.class, args);
	}

	public static void initializeFirebase() throws IOException {
		InputStream account = WebPortofolioMessagingApplication.class
				.getResourceAsStream(
						"/portofolio-messaging-firebase-adminsdk-ego9c-f657584870.json"
				);

		assert account != null;

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(account))
				.build();

		FirebaseApp.initializeApp(options);
	}
}
