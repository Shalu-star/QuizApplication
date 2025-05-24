package com.cg.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@XmlRootElement
@Entity
public class Subject {
	@Id
	private int subId;
	private String subName;

	
	
//	@OneToMany// one subject has many qsns
//	@JoinColumn(name = "SUB_ID")
//	private List<Questions> qsnList;
//	public List<Questions> getQsnList() {
//		return qsnList;
//	}
//	public void setQsnList(List<Questions> qsnList) {
//		this.qsnList = qsnList;
//	}
	
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
}
