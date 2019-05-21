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

import com.booldata.serviceota.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore; 

//用户信息
@Entity
@Table(name = "td_user")
public class Users extends AbstractEntity implements Serializable {
	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2527448941009070593L;
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private TArea city;  //所属城市
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    private TArea area;  //所属区域
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "road_id")
    private TArea road;  //所属路
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "community_id")
    private TArea community;  //所属社区

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(nullable=false,length=32, unique = true)  
    private String id;  
	
	@NotBlank(message = "姓名不能为空")
	@Column(nullable = false, length = 100)
	private String name;
	
	@NotBlank(message = "身份证号不能为空")
	@Column(nullable = false, length = 100)
	private String idcard;
	
	@NotBlank(message = "住地址不能为空")
	@Column(nullable = false, length = 100)
	private String address;
	
	private String headerImg; //头像

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TArea getCity() {
		return city;
	}

	public void setCity(TArea city) {
		this.city = city;
	}

	public TArea getArea() {
		return area;
	}

	public void setArea(TArea area) {
		this.area = area;
	}

	public TArea getRoad() {
		return road;
	}

	public void setRoad(TArea road) {
		this.road = road;
	}

	public TArea getCommunity() {
		return community;
	}

	public void setCommunity(TArea community) {
		this.community = community;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeaderImg() {
		return headerImg;
	}

	public void setHeaderImg(String headerImg) {
		this.headerImg = headerImg;
	}
 
	
}
