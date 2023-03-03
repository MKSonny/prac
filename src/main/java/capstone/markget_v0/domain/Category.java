package capstone.markget_v0.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    private Long category_id;

    /**
     * Enum 을 사용할 경우 다음 EnumType.STRING 을 반드시 적어줘야 한다.
     */
    @Enumerated(EnumType.STRING)
    private CategoryType category_type;

    public Category() {
    }

    public Category(CategoryType category_type) {
        this.category_type = category_type;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public CategoryType getCategory_type() {
        return category_type;
    }

    public void setCategory_type(CategoryType category_type) {
        this.category_type = category_type;
    }
}
