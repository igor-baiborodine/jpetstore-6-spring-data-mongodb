package org.mybatis.jpetstore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import static java.lang.String.format;

import com.google.common.base.MoreObjects;

/**
 * @author Igor Baiborodine
 */
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Profile {

  private static final String BANNER_TEMPLATE = "<image src='../images/banner_%s.gif'>";

  private String favouriteCategoryId;
  @NonNull private String languagePreference;
  private boolean listOption;
  private boolean bannerOption;
  private String bannerName;

  public void setFavouriteCategoryId(String favouriteCategoryId) {
    this.favouriteCategoryId = favouriteCategoryId;
    this.bannerName = format(BANNER_TEMPLATE, favouriteCategoryId.toLowerCase());
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
