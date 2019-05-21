package com.booldata.serviceota.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import com.booldata.serviceota.util.enums.OrderState; 
 

//企业信息
@Entity
@Table(name = "td_ordrs")
public class Order extends AbstractEntity implements Serializable {
	 
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;  //所属企业
	 
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;  //所属用户
	 
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;  //所属产品

	/**
	 * 
	 */
	private static final long serialVersionUID = -8655615372335411995L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(nullable=false,length=32, unique = true)  
    private String id;  
	
	@NotBlank(message = "订单编号不能为空")
	@Column(nullable = false, length = 20, unique = true)
	private String orderNo;
	
	@NotNull(message = "数量不能为空")
	@Column(nullable = false)
	private Integer num;
	
	@NotNull(message = "服务价格不能为空")  //如果修改了产品的价格，不会影响已购买服务的价格
	@Column(nullable = false, columnDefinition = "decimal(11,2) default '0.00'")
	private BigDecimal price;
	
	//订单状态 未处理  已处理  已完成  已取消
	private Integer orderState;
	
	//处理状态txt
    public String getOrderStateTxt(){
        if(this.getOrderState()!=null){
            return OrderState.getTxtByValue(this.getOrderState());
        }
        return null;
    }

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	} 
 
	
}
