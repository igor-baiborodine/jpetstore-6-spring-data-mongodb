package org.mybatis.jpetstore.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import com.google.common.base.MoreObjects;

/**
 * @author Igor Baiborodine
 */
@Getter @Setter @Builder
@NoArgsConstructor
public class Profile {

  private String favouriteCategoryId;
  private String languagePreference;
  private boolean listOption;
  private boolean bannerOption;
  private String bannerName;

  public Profile(@NonNull String languagePreference) {
    this.languagePreference = languagePreference;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("favouriteCategoryId", favouriteCategoryId)
        .add("languagePreference", languagePreference)
        .add("listOption", listOption)
        .add("bannerOption", bannerOption)
        .add("bannerName", bannerName)
        .toString();
  }

}
