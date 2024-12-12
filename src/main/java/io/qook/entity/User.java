package io.qook.jweb.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user") // 명시적으로 테이블 이름 지정
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    // 기본 생성자
    public User() {}

    // 생성자 (필드 초기화)
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getter와 Setter
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // hashCode와 equals 오버라이딩 (ID를 기준으로 비교)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString 오버라이딩
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
