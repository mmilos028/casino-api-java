package api.casino.api.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.casino.api.request.JackpotRequest;
import api.casino.command.service.JackpotService;
import api.casino.repository.UserDaoImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
//@RequestMapping(path="/api/jackpot")
public class JackpotApi {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private JackpotService service;
	
	@PostMapping(path="/api/jackpot", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody JackpotRequest request){
		logger.info("/api/jackpot jackpotCode={}", request.getJackpotCode());
		
		service.createJackpot(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(request.getJackpotCode());
	}
}