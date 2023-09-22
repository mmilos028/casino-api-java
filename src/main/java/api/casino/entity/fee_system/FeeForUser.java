package api.casino.entity.fee_system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import api.casino.entity.User;

@Entity
@Table(name="fee_for_user")
@JacksonXmlRootElement(localName = "FeeForUser")
public class FeeForUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty(localName = "id")
	private Long id;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(targetEntity = FeeProfile.class)
	@JoinColumn(name="fee_profile_id")
	private FeeProfile feeProfile;
	
	@ManyToOne(targetEntity = FeeType.class)
	@JoinColumn(name="fee_type_id")
	private FeeType feeType;
}
