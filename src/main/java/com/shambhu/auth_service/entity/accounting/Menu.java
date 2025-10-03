package com.shambhu.auth_service.entity.accounting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable {

    @Serial
    private static final long serialVersionUID = 5926468583005150707L;

    @Id
    private Long id;
    private String name;
    private String url;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Menu parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Menu> subMenus = new ArrayList<>();
}

