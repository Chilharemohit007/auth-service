package com.shambhu.auth_service.entity.accounting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 5926468583005150707L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "role_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="role_menu",
            joinColumns = @JoinColumn(name =
                    "role_id"), inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> menus;

}
