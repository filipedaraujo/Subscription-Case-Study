package subscriptionservice.springframework.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

//@Entity
public class Subscription {
	
    //@email
    //@GeneratedValue(strategy = GenerationType.AUTO)
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
    @ApiModelProperty(notes = "The newsletter Id", required = true)
    private String newsletterId;
    @ApiModelProperty(notes = "The subscription id", required = true)
    private Integer subscriptionId;
     
   
    public String email() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String firstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String gender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

   public Date getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getflagConsent() {
        return flagConsent;
    }

    public void setflagConsent(Boolean flagConsent) {
        this.flagConsent = flagConsent;
    }
    
    public String getnewsletterId() {
        return newsletterId;
    }

    public void setString(String newsletterId) {
        this.newsletterId = newsletterId;
    }
    
    public Integer getsubscriptionId() {
        return subscriptionId;
    }

    public void setsubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    
}
