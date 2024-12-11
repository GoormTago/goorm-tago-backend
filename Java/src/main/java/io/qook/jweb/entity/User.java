package io.qook.jweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity(name="user")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
////@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(nullable = false) // name 컬럼, null 허용 안 함
    private String name;

    @Column(nullable = false, unique = true) // email 컬럼, null 허용 안 함, 중복 불가
    private String email;

    @Column(nullable = false) // password 컬럼, null 허용 안 함
    private String password;

    @CreationTimestamp // 엔티티 생성 시 자동으로 설정
    @Temporal(TemporalType.TIMESTAMP) // Timestamp로 저장
    private Date createdAt;

    @UpdateTimestamp // 엔티티 업데이트 시 자동으로 설정
    @Temporal(TemporalType.TIMESTAMP) // Timestamp로 저장
    private Date updatedAt;
}
