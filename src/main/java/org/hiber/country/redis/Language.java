package org.hiber.country.redis;

import java.math.BigDecimal;

public class Language {

    private String language;
    private Boolean isOfficial;
    private BigDecimal percentage;

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setOfficial(Boolean official) {
        isOfficial = official;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
