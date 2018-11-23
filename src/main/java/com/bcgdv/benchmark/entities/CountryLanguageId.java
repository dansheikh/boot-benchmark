package com.bcgdv.benchmark.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class CountryLanguageId implements Serializable {
  @Column(name = "CountryCode")
  private String countryCode;
  @Column(name = "Language")
  private String language;
}
