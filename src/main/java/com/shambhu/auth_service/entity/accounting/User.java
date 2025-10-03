package com.shambhu.auth_service.entity.accounting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = 5926468583005150707L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created_on_date", nullable = false)
    private LocalDateTime createdOnDate;

    @Column(name = "modified_on_date")
    private LocalDateTime modifiedOnDate;

    @Column(name = "state_code")
    private Integer stateCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Column(name = "entity_type_id")
    private Integer entityTypeId;

    @Column(name = "level_id")
    private Integer levelId;

    @Column(name = "entity_code")
    private Integer entityCode;

    @Column(name = "district")
    private Integer district;

    @Column(name = "sub_district")
    private Integer subDistrict;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedOnDate() {
        return createdOnDate;
    }

    public void setCreatedOnDate(LocalDateTime createdOnDate) {
        this.createdOnDate = createdOnDate;
    }

    public LocalDateTime getModifiedOnDate() {
        return modifiedOnDate;
    }

    public void setModifiedOnDate(LocalDateTime modifiedOnDate) {
        this.modifiedOnDate = modifiedOnDate;
    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }


    public Integer getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(Integer entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(Integer entityCode) {
        this.entityCode = entityCode;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(Integer subDistrict) {
        this.subDistrict = subDistrict;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

