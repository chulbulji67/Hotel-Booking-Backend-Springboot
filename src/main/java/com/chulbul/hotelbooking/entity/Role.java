package com.chulbul.hotelbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role extends AbstractClass{
    private String role;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
//    private Set<User> users;
}
