package com.booldata.serviceota.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

//疾病类型 两级 疾病种类   疾病
@Entity
@Table(name = "td_diseases")
public class Diseases extends AbstractEntity implements Serializable {
	
	/**父组织*/
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Diseases parent; //parent_id为null为疾病类型:内科 、 外科 。。。。
    
    /**子组织*/
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Set<Diseases> child = new HashSet<>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 3817328080036263935L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(nullable=false,length=32, unique = true)  
    private String id;  
	
	@NotBlank(message = "疾病名称不能为空")
	@Column(nullable = false, length = 100)
	private String name;
	
	//简介
	@Column(length = 2000)
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
