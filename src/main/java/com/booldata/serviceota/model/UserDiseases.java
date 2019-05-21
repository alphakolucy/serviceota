package com.booldata.serviceota.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//用户疾病  多对多，单独出表，因为要记录时间
@Entity
@Table(name = "td_user_diseases")
public class UserDiseases extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2761306256741712967L;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;  //所属用户
	 
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "diseases_id")
    private Diseases diseases;  //疾病
    
    //备注
  	@Column(length = 500) 
  	private String remark;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Diseases getDiseases() {
		return diseases;
	}

	public void setDiseases(Diseases diseases) {
		this.diseases = diseases;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


    
}
