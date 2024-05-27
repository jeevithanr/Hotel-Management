package com.example.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "guest")
public class Guest {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int guestId;
	    
	    @Column(name = "identification_type")
	    private String identificationType;
	    
	    @Column(name = "identification_number")
	    private String identificationNumber;
	    
	    @Column(name = "first_name")
	    private String firstName;
	    
	    @Column(name = "last_name")
	    private String lastName;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "phone_number")
	    private String phoneNumber;
	    
	    @Column(name = "nationality")
	    private String nationality;

	    public Guest() {
	    	
	    }
	    
	    
		public Guest(String identificationType, String identificationNumber, String firstName, String lastName,
				String email, String phoneNumber, String nationality) {
			super();
			this.identificationType = identificationType;
			this.identificationNumber = identificationNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.nationality = nationality;
		}


		public int getGuestId() {
			return guestId;
		}

		public void setGuestId(int guestId) {
			this.guestId = guestId;
		}

		public String getIdentificationType() {
			return identificationType;
		}

		public void setIdentificationType(String identificationType) {
			this.identificationType = identificationType;
		}

		public String getIdentificationNumber() {
			return identificationNumber;
		}

		public void setIdentificationNumber(String identificationNumber) {
			this.identificationNumber = identificationNumber;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		@Override
		public String toString() {
			return "Guest [guestId=" + guestId + ", identificationType=" + identificationType
					+ ", identificationNumber=" + identificationNumber + ", firstName=" + firstName + ", lastName="
					+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", nationality=" + nationality
					+ "]";
		}
	    
	    
}
