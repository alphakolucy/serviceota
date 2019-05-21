package com.booldata.serviceota.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

//企业信息
@Entity
@Table(name = "td_companys")
public class Company extends AbstractEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6723105361216910396L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(nullable = false, length = 32, unique = true)
    private String id;

    @NotBlank(message = "企业名称不能为空")
    @Column(nullable = false, length = 100)
    private String name;


    //by ado
    @NotBlank(message = "企业证书不能为空")
    @Column(nullable = false, length = 100)
    private String certificate;

    //法人信息
    //负责人信息
    //


    private String logo;// 企业logo

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


}
