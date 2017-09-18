package com.sda.gamingplatform.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity(name = "chips")
public class Chips {

	@Id
	private long user_id;
	private BigInteger user_chips;

	public Chips(long user_id, BigInteger user_chips) {
		this.user_id = user_id;
		this.user_chips = user_chips;
	}

	public Chips() {
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public BigInteger getUser_chips() {
		return user_chips;
	}

	public void setUser_chips(BigInteger user_chips) {
		this.user_chips = user_chips;
	}
}
