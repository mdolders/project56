package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the characters database table.
 * 
 */
@Entity
@Table(name="characters")
@NamedQuery(name="Character.findAll", query="SELECT c FROM Character c")
public class Character implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	@Column(name="class")
	private String class_;

	private Integer level;

	private String race;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="characters")
	private List<User> users;

	public Character() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}