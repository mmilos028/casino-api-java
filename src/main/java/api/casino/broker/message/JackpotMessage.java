package api.casino.broker.message;

public class JackpotMessage {

	private String jackpotCode;

	public JackpotMessage() {
		super();
	}

	public JackpotMessage(String jackpotCode) {
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
		return "JackpotMessage [jackpotCode=" + jackpotCode + "]";
	}

}
