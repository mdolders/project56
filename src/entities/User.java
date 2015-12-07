package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_name")
	private String userName;

	private Integer balance;

	private Boolean banned;

	@Column(name="character_slots")
	private Integer characterSlots;

	@Column(name="first_name")
	private String firstName;

	private String iban;

	@Column(name="last_name")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name="last_payment")
	private Date lastPayment;

	@Column(name="months_payed")
	private Integer monthsPayed;

	private String password;

	//bi-directional many-to-many association to Character
	@ManyToMany
	@JoinTable(
		name="owns"
		, joinColumns={
			@JoinColumn(name="user_name")
			}
		, inverseJoinColumns={
			@JoinColumn(name="name")
			}
		)
	private List<Character> characters;

	//bi-directional many-to-many association to Server
	@ManyToMany
	@JoinTable(
		name="stores"
		, joinColumns={
			@JoinColumn(name="user_name")
			}
		, inverseJoinColumns={
			@JoinColumn(name="address")
			}
		)
	private List<Server> servers;

	public User() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Boolean getBanned() {
		return this.banned;
	}

	public void setBanned(Boolean banned) {
		this.banned = banned;
	}

	public Integer getCharacterSlots() {
		return this.characterSlots;
	}

	public void setCharacterSlots(Integer characterSlots) {
		this.characterSlots = characterSlots;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIban() {
		return this.iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastPayment() {
		return this.lastPayment;
	}

	public void setLastPayment(Date lastPayment) {
		this.lastPayment = lastPayment;
	}

	public Integer getMonthsPayed() {
		return this.monthsPayed;
	}

	public void setMonthsPayed(Integer monthsPayed) {
		this.monthsPayed = monthsPayed;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Character> getCharacters() {
		return this.characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public List<Server> getServers() {
		return this.servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

}