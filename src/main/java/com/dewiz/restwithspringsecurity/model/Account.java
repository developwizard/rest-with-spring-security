package com.dewiz.restwithspringsecurity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @NotNull
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;
    private boolean enabled = true;
    private boolean credentrialsexpired = false;
    private boolean expired = false;
    private boolean locked = false;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "AccountRole",
            joinColumns = @JoinColumn(name = "accountId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id")
    )
    private Set<Role> roles;
}
