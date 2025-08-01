package com.pasdmsG.padms.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pasdmsG.padms.FarmStock.FarmStock;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(unique = true, nullable = false)
    private Integer phone;
    private String password;
    private String role;
    private String address;
    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<FarmStock> farmStocks;

    public User() {
    }

    public User(long id, String name, Integer phone, String password, String address, String role, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.role = role;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<FarmStock> getFarmStocks() {
        return farmStocks;
    }

    public void setFarmStocks(List<FarmStock> farmStocks) {
        this.farmStocks = farmStocks;
    }
}
