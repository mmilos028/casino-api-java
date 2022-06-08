package api.casino.controller.graphql;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

import api.casino.entity.User;
import api.casino.service.UserService;
import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {
	
	@Autowired
	UserService userService;

	/**
	 * 
	 * {
		    userById(id: 10002){
		        id
		        username
		        email
		    }
		}
	 */
    public DataFetcher getUserByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Long userId = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
            System.out.println("getUserByIdDataFetcher :: id = " + userId);
            User someUser = userService.findById(userId)
            		.stream()
            		.findFirst()
            		.orElse(null)
            		;
            return someUser;
            /*Optional<User> someUser = userService.findAll()
                    .stream()
                    //.filter(user -> Integer.valueOf(user.getId()).equals(userId))
                    .findFirst()                    
                    //.orElse(null)
                    ;
            System.out.println("getUserByIdDataFetcher :: user = " + someUser);
            return someUser;*/
        };
    }
    
    /**
     * 
     * { 
    		users {        
		        id
		        username
		        email
		    }
		}
     */
    public DataFetcher getUserDataFetcher() {
        return dataFetchingEnvironment -> {
        	System.out.println("getUserDataFetcher ");
        	
            List<User> users = userService
            		.findAll()
            		.stream()
            		.toList()
                    ;    
            System.out.println("getUserDataFetcher " + users);
            
            return users;
        };
    }
}