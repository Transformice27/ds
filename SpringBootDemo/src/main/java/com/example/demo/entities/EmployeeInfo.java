package com.example.demo.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="Eployeement")
public class EmployeeInfo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "lastName", nullable = false, length = 20)
    private String lastName;

	@Column(name = "email", nullable = false, length = 28)
    private String email;
    
    //1 male, 0 female
	@Column(name = "gender", nullable = false, length = 3)
    private Integer gender;
    
	@Column(name = "department", nullable = false, length = 20)
    private Department department;
    
	@Column(name = "birth", nullable = false, length = 20)
    private Date birth;
}
