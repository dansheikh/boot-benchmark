package com.bcgdv.benchmark.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "country")
public class Country implements Serializable {
  @Id
  @Column(name = "Code")
  private String code;
  @Column(name = "Name")
  private String name;
  @Column(name = "Continent")
  private String continent;
  @Column(name = "Region")
  private String region;
  @Column(name = "SurfaceArea")
  private Float surfaceArea;
  @Column(name = "IndepYear")
  private Integer indepYear;
  @Column(name = "Population")
  private Integer population;
  @Column(name = "LifeExpectancy")
  private Float lifeExpectancy;
  @Column(name = "GNP")
  private Float gmp;
  @Column(name = "GNPOld")
  private Float gnpOld;
  @Column(name = "LocalName")
  private String localName;
  @Column(name = "GovernmentForm")
  private String governmentForm;
  @Column(name = "HeadOfState")
  private String headOfState;
  @Column(name = "Capital")
  private Integer capital;
  @Column(name = "Code2")
  private String code2;
  @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
  @JsonManagedReference
  private List<City> cities;
  @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
  @JsonManagedReference
  private List<CountryLanguage> languages;
}
