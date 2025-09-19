package com.example.moviebooking.entity;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @jakarta.persistence.Column(nullable = false)
    private String username;

    @jakarta.persistence.Column(nullable = false,unique = true)
    private String email;

    @jakarta.persistence.Column(nullable = false)
    private String phone;

    @jakarta.persistence.Column(nullable = false)
    private String password;

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    // Getters and Setters
    public Long getId() {   return id; }
    public void setId(Long id) {   this.id = id; }

    public String getUsername() {   return username; }
    public void setUsername(String username) {   this.username = username; }

    public String getEmail() {   return email; }            
    public void setEmail(String email) {   this.email = email; }

    public String getPhone() {   return phone; }        
    public void setPhone(String phone) {   this.phone = phone; }

    public String getPassword() {   return password; }  
    public void setPassword(String password) {   this.password = password; }

    public Instant getCreatedAt() {   return createdAt; }
    public void setCreatedAt(Instant createdAt) {   this.createdAt = createdAt; }

    public Instant getUpdatedAt() {   return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) {   this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
}


}
