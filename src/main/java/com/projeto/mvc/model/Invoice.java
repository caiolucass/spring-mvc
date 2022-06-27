package com.projeto.mvc.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "location", nullable = false)
    private String Location;

    @Basic(optional = false)
    @NotNull
    @Column(name = "amount", nullable = false)
    private Double amount;
}
