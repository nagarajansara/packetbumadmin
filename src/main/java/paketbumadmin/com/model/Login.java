package paketbumadmin.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@SuppressWarnings(
{ "unused", "unchecked" })
public class Login implements Serializable
{

	@Getter
	@Setter
	private int id;

	public String getManage()
	{
		return manage;
	}

	public void setManage(String manage)
	{
		this.manage = manage;
	}

	@Getter
	@Setter
	private String manage;

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String status;

	@Getter
	@Setter
	private String firstname;

	@Getter
	@Setter
	private String lastname;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String phoneno;

	@Getter
	@Setter
	private String address;

	@Getter
	@Setter
	private String city;

	@Getter
	@Setter
	private String isapproved;

	@Getter
	@Setter
	private String role;

	@Getter
	@Setter
	private String openid;

	@Getter
	@Setter
	private String openiddata;

	@Getter
	@Setter
	private String signuptype;

	@Getter
	@Setter
	private String ip;

	@Getter
	@Setter
	private String state;

	@Getter
	@Setter
	private String organizationname;

	@Getter
	@Setter
	private String pancardno;

	@Getter
	@Setter
	private int credits;

	@Getter
	@Setter
	private int totalcredits;

	@Getter
	@Setter
	private int starrating;

	@Getter
	@Setter
	private int totaltrip;

	@Getter
	@Setter
	private int totalreviews;

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	private int isactive;

	@Getter
	@Setter
	private String shortname;

	@Getter
	@Setter
	private String creates;

	@Getter
	@Setter
	private String newsletter;

	@Getter
	@Setter
	private int country;

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	@Getter
	@Setter
	private String address1;

	@Getter
	@Setter
	private String address2;
	@Getter
	@Setter
	private String telephone;

	@Getter
	@Setter
	private String postcode;

	public String getNewsletter()
	{
		return newsletter;
	}

	public void setNewsletter(String newsletter)
	{
		this.newsletter = newsletter;
	}

	public int getCountry()
	{
		return country;
	}

	public void setCountry(int country)
	{
		this.country = country;
	}

	public String getAddress1()
	{
		return address1;
	}

	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}

	public String getAddress2()
	{
		return address2;
	}

	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}

	public int getNoofquotesaccept()
	{
		return noofquotesaccept;
	}

	public void setNoofquotesaccept(int noofquotesaccept)
	{
		this.noofquotesaccept = noofquotesaccept;
	}

	public String getCompanyname()
	{
		return companyname;
	}

	public void setCompanyname(String companyname)
	{
		this.companyname = companyname;
	}

	public String getTaxnumber()
	{
		return taxnumber;
	}

	public void setTaxnumber(String taxnumber)
	{
		this.taxnumber = taxnumber;
	}

	public String getVehiclenumber()
	{
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber)
	{
		this.vehiclenumber = vehiclenumber;
	}

	@Getter
	@Setter
	private int noofquotesaccept;

	@Getter
	@Setter
	private String companyname;

	@Getter
	@Setter
	private String taxnumber;

	@Getter
	@Setter
	private String vehiclenumber;

	public String getCountry_name()
	{
		return country_name;
	}

	public void setCountry_name(String country_name)
	{
		this.country_name = country_name;
	}

	@Getter
	@Setter
	private String country_name;

	public int getTotalreviews()
	{
		return totalreviews;
	}

	public void setTotalreviews(int totalreviews)
	{
		this.totalreviews = totalreviews;
	}

	public int getTotaltrip()
	{
		return totaltrip;
	}

	public void setTotaltrip(int totaltrip)
	{
		this.totaltrip = totaltrip;
	}

	public int getStarrating()
	{
		return starrating;
	}

	public void setStarrating(int starrating)
	{
		this.starrating = starrating;
	}

	@Getter
	@Setter
	private String verificationcode;

	public String getVerificationcode()
	{
		return verificationcode;
	}

	public void setVerificationcode(String verificationcode)
	{
		this.verificationcode = verificationcode;
	}

	public int getTotalcredits()
	{
		return totalcredits;
	}

	public void setTotalcredits(int totalcredits)
	{
		this.totalcredits = totalcredits;
	}

	@Getter
	@Setter
	private String reason;

	public String getTripowneremail()
	{
		return tripowneremail;
	}

	public void setTripowneremail(String tripowneremail)
	{
		this.tripowneremail = tripowneremail;
	}

	public String getEnquiredemail()
	{
		return enquiredemail;
	}

	public void setEnquiredemail(String enquiredemail)
	{
		this.enquiredemail = enquiredemail;
	}

	@Getter
	@Setter
	private String tripowneremail;

	@Getter
	@Setter
	private String enquiredemail;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Getter
	@Setter
	private String name;

	public int getUserid()
	{
		return userid;
	}

	public void setUserid(int userid)
	{
		this.userid = userid;
	}

	@Getter
	@Setter
	private int initialcredits;

	@Getter
	@Setter
	private int userid;

	public int getTotalcreditshistory()
	{
		return totalcreditshistory;
	}

	public void setTotalcreditshistory(int totalcreditshistory)
	{
		this.totalcreditshistory = totalcreditshistory;
	}

	@Getter
	@Setter
	private int totalcreditshistory;

	public int getInitialcredits()
	{
		return initialcredits;
	}

	public void setInitialcredits(int initialcredits)
	{
		this.initialcredits = initialcredits;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public int getCrdits()
	{
		return crdits;
	}

	public void setCrdits(int crdits)
	{
		this.crdits = crdits;
	}

	public void setCredits(int credits)
	{
		this.credits = credits;
	}

	@Getter
	@Setter
	private int crdits;

	public String getPancardno()
	{
		return pancardno;
	}

	public void setPancardno(String pancardno)
	{
		this.pancardno = pancardno;
	}

	public String getPincode()
	{
		return pincode;
	}

	public void setPincode(String pincode)
	{
		this.pincode = pincode;
	}

	@Getter
	@Setter
	private String mobile;

	@Getter
	@Setter
	private String pincode;

	@Getter
	@Setter
	private int tripcredits;

	@Getter
	@Setter
	private String createddate;

	public int getTripcredits()
	{
		return tripcredits;
	}

	public void setTripcredits(int tripcredits)
	{
		this.tripcredits = tripcredits;
	}

	public String getCreateddate()
	{
		return createddate;
	}

	public void setCreateddate(String createddate)
	{
		this.createddate = createddate;
	}

	public int getCredits()
	{
		return credits;
	}

	public Login()
	{

	}

	public Login(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPhoneno()
	{
		return phoneno;
	}

	public void setPhoneno(String phoneno)
	{
		this.phoneno = phoneno;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getIsapproved()
	{
		return isapproved;
	}

	public void setIsapproved(String isapproved)
	{
		this.isapproved = isapproved;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getOpenid()
	{
		return openid;
	}

	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	public String getOpeniddata()
	{
		return openiddata;
	}

	public void setOpeniddata(String openiddata)
	{
		this.openiddata = openiddata;
	}

	public String getSignuptype()
	{
		return signuptype;
	}

	public void setSignuptype(String signuptype)
	{
		this.signuptype = signuptype;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getOrganizationname()
	{
		return organizationname;
	}

	public void setOrganizationname(String organizationname)
	{
		this.organizationname = organizationname;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getIsactive()
	{
		return isactive;
	}

	public void setIsactive(int isactive)
	{
		this.isactive = isactive;
	}

	public String getShortname()
	{
		return shortname;
	}

	public void setShortname(String shortname)
	{
		this.shortname = shortname;
	}

	public String getCreates()
	{
		return creates;
	}

	public void setCreates(String creates)
	{
		this.creates = creates;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public Login(int id, String role)
	{
		this.id = id;
		this.role = role;
	}

	public Login(int userid, String email, String username, int isactive,
			String mobile)
	{
		this.email = email;
		this.username = username;
		this.isactive = isactive;
		this.mobile = mobile;
		this.id = userid;
	}

	public Login(String email, String username, String firstname,
			String lastname, String companyName, String telephoneNo,
			String taxNo, String city, String address1, String address2,
			String postCode, int isactive, String mobile, int id,
			String vehiclenumber)
	{
		this.email = email;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.companyname = companyName;
		this.telephone = telephoneNo;
		this.taxnumber = taxNo;
		this.city = city;
		this.address1 = address1;
		this.address2 = address2;
		this.postcode = postCode;
		this.isactive = isactive;
		this.mobile = mobile;
		this.id = id;
		this.vehiclenumber = vehiclenumber;
	}

}
