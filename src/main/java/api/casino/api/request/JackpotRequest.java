package api.casino.api.request;

public class JackpotRequest {
	private String jackpotCode;
	
	public JackpotRequest() {
		
	}
	
	public JackpotRequest(String jackpotCode) {
		super();
		this.jackpotCode = jackpotCode;
	}

	public String getJackpotCode() {
		return jackpotCode;
	}

	public void setJackpotCode(String jackpotCode) {
		this.jackpotCode = jackpotCode;
	}

	@Override
	public String toString() {
		return "Jackpot Request [jackpotCode=" + jackpotCode + "]";
	}
	
}
