package api.casino.broker.message;

public class PromotionMessage {

	private String promotionCode;

	public PromotionMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromotionMessage(String promotionCode) {
		super();
		this.promotionCode = promotionCode;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	@Override
	public String toString() {
		return "PromotionMessage [promotionCode=" + promotionCode + "]";
	}

}
