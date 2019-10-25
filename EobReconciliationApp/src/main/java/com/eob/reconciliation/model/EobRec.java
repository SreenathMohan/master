package com.eob.reconciliation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EobRec {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String eobName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEobName() {
		return eobName;
	}

	public void setEobName(String eobName) {
		this.eobName = eobName;
	}

}
