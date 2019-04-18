package jingcheng.LoanSupermarket.card.entity;

/**
 * 轮播页
 */
public class Carousel {

    /**
     * id
     */
    private Long id;
    /**
     * 信用卡id
     */
    private Long cardId;
    /**
     * 轮播图
     */
    private String carouselUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl;
    }
}
