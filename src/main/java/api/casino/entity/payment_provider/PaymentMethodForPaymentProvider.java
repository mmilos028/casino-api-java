package api.casino.entity.payment_provider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name="payment_method_for_payment_provider")
@JacksonXmlRootElement(localName = "PaymentMethodForPaymentProvider")
public class PaymentMethodForPaymentProvider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;

	@ManyToOne(targetEntity = PaymentProvider.class)
	@JoinColumn(name="payment_provider_id")
	private PaymentProvider paymentProvider;
	
	@ManyToOne(targetEntity = PaymentMethod.class)
	@JoinColumn(name="payment_method_id")
	private PaymentProvider paymentMethod;
}
