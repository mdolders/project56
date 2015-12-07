package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servers database table.
 * 
 */
@Entity
@Table(name="servers")
@NamedQuery(name="Server.findAll", query="SELECT s FROM Server s")
public class Server implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String address;

	@Column(name="connected_users")
	private Integer connectedUsers;

	private String location;

	@Column(name="max_users")
	private Integer maxUsers;

	private String name;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="servers")
	private List<User> users;

	public Server() {
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getConnectedUsers() {
		return this.connectedUsers;
	}

	public void setConnectedUsers(Integer connectedUsers) {
		this.connectedUsers = connectedUsers;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getMaxUsers() {
		return this.maxUsers;
	}

	public void setMaxUsers(Integer maxUsers) {
		this.maxUsers = maxUsers;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}