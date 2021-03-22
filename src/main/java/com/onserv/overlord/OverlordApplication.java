package com.onserv.overlord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@SpringBootApplication
public class OverlordApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverlordApplication.class, args);
	}

}



//@ResponseStatus(HttpStatus.BAD_REQUEST)
//public class BadRequestException extends RuntimeException {
   //
//}

/**
listener = new ActionListener<GetUsersResponse>() {
    @Override
    public void onResponse(GetUsersResponse getRolesResponse) {
        
    }

    @Override
    public void onFailure(Exception e) {
        
    }
};

List<User> users = new ArrayList<>(1);
users.addAll(response.getUsers());
GetUsersRequest request = new GetUsersRequest(usernames);
GetUsersResponse response = client.security().getUsers(request, RequestOptions.DEFAULT);
*/