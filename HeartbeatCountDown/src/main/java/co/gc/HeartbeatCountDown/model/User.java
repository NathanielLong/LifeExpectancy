package co.gc.HeartbeatCountDown.model;

import java.io.Serializable;

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
	private Integer id;
	private String name;
	private String password;
	private String userName;
	private String country;
	private Double deathYear;
	private String gender;
	private String alcohol;
	private String dob;
	private String education;
	private String smoke;
	private Integer income;
	private String ethnicity;
	private String deathDay;
	private Integer numOfCigarettes;
	private Integer yearsSmoked;
	private String amountDrunk;
	private Integer height;
	private Integer weight;
	private Integer age;

	public User() {
		super();
	}
	
	
	
	public User(Integer id, String name, String password, String userName, String country, Double deathYear,
			String gender, String alcohol, String dob, String education, String smoke, Integer income, String ethnicity,
			String deathDay, Integer numOfCigarettes, Integer yearsSmoked, String amountDrunk, Integer height,
			Integer weight, Integer age) {
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
		this.deathDay = deathDay;
		this.numOfCigarettes = numOfCigarettes;
		this.yearsSmoked = yearsSmoked;
		this.amountDrunk = amountDrunk;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}

	public User(String name, String password, String userName, String country, Double deathYear, String gender,
			String alcohol, String dob, String education, String smoke, Integer income, String ethnicity,
			String deathDay, Integer numOfCigarettes, Integer yearsSmoked, String amountDrunk, Integer height,
			Integer weight, Integer age) {
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
		this.deathDay = deathDay;
		this.numOfCigarettes = numOfCigarettes;
		this.yearsSmoked = yearsSmoked;
		this.amountDrunk = amountDrunk;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}



	public String getDeathDay() {
		return deathDay;
	}


	public void setDeathDay(String deathDay) {
		this.deathDay = deathDay;
	}


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


	public Integer getNumOfCigarettes() {
		return numOfCigarettes;
	}



	public void setNumOfCigarettes(Integer numOfCigarettes) {
		this.numOfCigarettes = numOfCigarettes;
	}



	public Integer getYearsSmoked() {
		return yearsSmoked;
	}



	public void setYearsSmoked(Integer yearsSmoked) {
		this.yearsSmoked = yearsSmoked;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer yearsOld) {
		this.age = yearsOld;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", userName=" + userName + ", country="
				+ country + ", deathYear=" + deathYear + ", gender=" + gender + ", alcohol=" + alcohol + ", dob=" + dob
				+ ", education=" + education + ", smoke=" + smoke + ", income=" + income + ", ethnicity=" + ethnicity
				+ ", deathDay=" + deathDay + ", numOfCigarettes=" + numOfCigarettes + ", yearsSmoked=" + yearsSmoked
				+ ", amountDrunk=" + amountDrunk + ", height=" + height + ", weight=" + weight + ", age=" + age + "]";
	}


}
