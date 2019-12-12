package co.gc.HeartbeatCountDown.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String country;
	private Double deathYear;
	private String gender;
	private String alcohol;
	private LocalDate dob;
	private String education;
	private String smoke;
	private int income;
	private String ethnicity;
	private Integer amount;
	private Integer years;
	private String stillsmokin;
	private String amountDrunk;

	public String getAmountDrunk() {
		return amountDrunk;
	}

	public void setAmountDrunk(String amountDrunk) {
		this.amountDrunk = amountDrunk;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public String getStillSmokin() {
		return stillsmokin;
	}

	public void setStillSmokin(String stillsmokin) {
		this.stillsmokin = stillsmokin;
	}

	public User(String userName, String country, Double deathYear, String gender, String alcohol, LocalDate dob,
			String education, String smoke, int income, String ethnicity) {
		super();
		this.userName = userName;
		this.country = country;
		this.deathYear = deathYear;
		this.gender = gender;
		this.alcohol = alcohol;
		this.dob = dob;
		this.education = education;
		this.smoke = smoke;
		this.income = income;
		this.ethnicity = ethnicity;
	}

	public User(int id, String userName, String country, Double deathYear, String gender, String alcohol, LocalDate dob,
			String education, String smoke, int income, String ethnicity) {
		super();
		this.id = id;
		this.userName = userName;
		this.country = country;
		this.deathYear = deathYear;
		this.gender = gender;
		this.alcohol = alcohol;
		this.dob = dob;
		this.education = education;
		this.smoke = smoke;
		this.income = income;
		this.ethnicity = ethnicity;

	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(int id, String userName, String country, Double deathYear, String gender, String alcohol, LocalDate dob,
			String education, String smoke, String ethnicity) {
		super();
		this.id = id;
		this.userName = userName;
		this.country = country;
		this.deathYear = deathYear;
		this.gender = gender;
		this.alcohol = alcohol;
		this.dob = dob;
		this.education = education;
		this.smoke = smoke;
		this.ethnicity = ethnicity;
	}

	public User(String userName, String country, Double deathYear, String gender, String alcohol, LocalDate dob,
			String education, String smoke, String ethnicity) {
		super();
		this.userName = userName;
		this.country = country;
		this.deathYear = deathYear;
		this.gender = gender;
		this.alcohol = alcohol;
		this.dob = dob;
		this.education = education;
		this.smoke = smoke;
		this.ethnicity = ethnicity;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(Double deathYear) {
		this.deathYear = deathYear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSmoke() {
		return smoke;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", country=" + country + ", deathYear=" + deathYear
				+ ", gender=" + gender + ", alcohol=" + alcohol + ", dob=" + dob + ", education=" + education
				+ ", smoke=" + smoke + ", income=" + income + ", ethnicity=" + ethnicity + ", amount=" + amount
				+ ", years=" + years + ", stillsmokin=" + stillsmokin + ", amountDrunk=" + amountDrunk + "]";
	}

}
