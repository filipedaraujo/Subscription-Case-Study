package subscriptionservice.springframework.models;

//import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "subscriptions")
public class Subscription{
	
	//private static final long serialVersionUID = 1844136251472516656L;

    @ApiModelProperty(notes = "The email from customer")
    private String email;
    
    @ApiModelProperty(notes = "The auto-generated first name")
    private String firstName;
    
    @ApiModelProperty(notes = "The gender")
    private String gender;
    
    @ApiModelProperty(notes = "The date Of Birth")
    private Date dateOfBirth;
    
    @ApiModelProperty(notes = "The flag Consent")
    private Boolean flagConsent;
    
    @ApiModelProperty(notes = "The newsletter Id")
    private String newsletterId;
    
    @ApiModelProperty(notes = "The subscription id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subscriptionId;
     
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getFlagConsent() {
        return flagConsent;
    }

    public void setFlagConsent(Boolean flagConsent) {
        this.flagConsent = flagConsent;
    }
    
    public String getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(String newsletterId) {
        this.newsletterId = newsletterId;
    }
    
    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    
}
