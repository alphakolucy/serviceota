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

//区域  贵阳市  南明区  兴关路  XXX社区
@Entity
@Table(name = "td_area")
public class TArea extends AbstractEntity  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4186096803447374755L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(nullable=false,length=32, unique = true)  
    private String id;
	
	/**父组织*/
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name="parent_id")
    private TArea parent; //parent_id为null为市
    
    /**子组织*/
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Set<TArea> child = new HashSet<>();
    
    @NotBlank(message = "名称不能为空")
	@Column(nullable = false, length = 200)
	private String areaName; 
    
    @NotBlank(message = "代码不能为空")
   	@Column(nullable = false, length = 200)
   	private String areaCode;  

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TArea getParent() {
		return parent;
	}

	public void setParent(TArea parent) {
		this.parent = parent;
	}

	public Set<TArea> getChild() {
		return child;
	}

	public void setChild(Set<TArea> child) {
		this.child = child;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
 
}
