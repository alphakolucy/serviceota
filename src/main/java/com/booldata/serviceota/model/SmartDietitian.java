package com.booldata.serviceota.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

//智能营养师
@Entity
@Table(name = "td_smart_dietitian")
public class SmartDietitian extends AbstractEntity implements Serializable {
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "diseases_id")
    private Diseases diseases;  //疾病

	/**
	 * 
	 */
	private static final long serialVersionUID = 3339049141242070083L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(nullable=false,length=32, unique = true)  
    private String id;
	
	@NotBlank(message = "说明不能为空")  //前端要用富文本编辑器
	@Column(length = 5000)
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Diseases getDiseases() {
		return diseases;
	}

	public void setDiseases(Diseases diseases) {
		this.diseases = diseases;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}  

	
}
