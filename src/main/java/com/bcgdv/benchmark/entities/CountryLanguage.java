package com.bcgdv.benchmark.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage implements Serializable {
  @EmbeddedId
  private CountryLanguageId countryLanguageId;
  @Column(name = "IsOfficial")
  private String isOfficial;
  @Column(name = "Percentage")
  private Float percentage;
  @ManyToOne
  @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
  @JsonBackReference
  private Country country;
}
