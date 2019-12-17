package co.gc.HeartbeatCountDown.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String userName;
	private String country;
	private Double deathYear;
	private String gender;
	private String alcohol;
	private LocalDate dob;
	private String education;
	private String smoke;
	private Integer income;
	private String ethnicity;
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	private Integer amount;
	private Integer years;
	private String stillSmokin;
	private String amountDrunk;
	private Integer height;
	private Integer weight;
	private long age;

	public User() {
		super();
	}
	
	

	public User(int id, String name, String password, String userName, String country, Double deathYear, String gender,
			String alcohol, LocalDate dob, String education, String smoke, Integer income, String ethnicity,
			Integer amount, Integer years, String stillSmokin, String amountDrunk, Integer height, Integer weight,
			long age) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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
		this.amount = amount;
		this.years = years;
		this.stillSmokin = stillSmokin;
		this.amountDrunk = amountDrunk;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}


	public User(String name, String password, String userName, String country, Double deathYear, String gender,
			String alcohol, LocalDate dob, String education, String smoke, Integer income, String ethnicity,
			Integer amount, Integer years, String stillSmokin, String amountDrunk, Integer height, Integer weight,
			long age) {
		super();
		this.name = name;
		this.password = password;
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
		this.amount = amount;
		this.years = years;
		this.stillSmokin = stillSmokin;
		this.amountDrunk = amountDrunk;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}


	public User(int id, String userName, String country, Double deathYear, String gender, String alcohol, LocalDate dob,
			String education, String smoke, int income, String ethnicity, Integer amount, Integer years,
			String stillSmokin, String amountDrunk) {
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
		this.amount = amount;
		this.years = years;
		this.stillSmokin = stillSmokin;
		this.amountDrunk = amountDrunk;
	}

	public User(String userName, String country, Double deathYear, String gender, String alcohol, LocalDate dob,
			String education, String smoke, int income, String ethnicity, Integer amount, Integer years,
			String stillSmokin, String amountDrunk) {
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
		this.amount = amount;
		this.years = years;
		this.stillSmokin = stillSmokin;
		this.amountDrunk = amountDrunk;
	}

	public User(String country, String alcohol, String smoke, int income, Integer amount, Integer years,
			String stillSmokin, String amountDrunk, Integer weight) {
		super();
		this.country = country;
		this.alcohol = alcohol;
		this.smoke = smoke;
		this.income = income;
		this.amount = amount;
		this.years = years;
		this.stillSmokin = stillSmokin;
		this.amountDrunk = amountDrunk;
		this.weight = weight;
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

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
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
		return stillSmokin;
	}

	public void setStillSmokin(String stillSmokin) {
		this.stillSmokin = stillSmokin;
	}

	public String getAmountDrunk() {
		return amountDrunk;
	}

	public void setAmountDrunk(String amountDrunk) {
		this.amountDrunk = amountDrunk;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long yearsOld) {
		this.age = yearsOld;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", userName=" + userName + ", country="
				+ country + ", deathYear=" + deathYear + ", gender=" + gender + ", alcohol=" + alcohol + ", dob=" + dob
				+ ", education=" + education + ", smoke=" + smoke + ", income=" + income + ", ethnicity=" + ethnicity
				+ ", amount=" + amount + ", years=" + years + ", stillSmokin=" + stillSmokin + ", amountDrunk="
				+ amountDrunk + ", height=" + height + ", weight=" + weight + ", age=" + age + "]";
	}



}
