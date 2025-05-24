package com.cg.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class Questions {
	@Id
	private int qsnId;
	private String qsn;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String corOption;
    @ManyToOne
    @JoinColumn(name = "SUB_ID")

    private Subject subject;
    
    
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getQsnId() {
		return qsnId;
	}
	public void setQsnId(int qsnId) {
		this.qsnId = qsnId;
	}
	public String getQsn() {
		return qsn;
	}
	public void setQsn(String qsn) {
		this.qsn = qsn;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getCorOption() {
		return corOption;
	}
	public void setCorOption(String corOption) {
		this.corOption = corOption;
	}
}
