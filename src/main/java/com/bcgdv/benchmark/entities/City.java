package com.bcgdv.benchmark.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "Name")
  private String name;
  @OneToOne
  @JoinColumn(name = "CountryCode")
  @JsonBackReference
  private Country country;
  @Column(name = "District")
  private String district;
  @Column(name = "Population")
  private Integer population;
}
