package keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class LinkedPurchaseListKey {

    static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Getter
    @Setter
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    // Это класс составного ключа
    // Подробно теория об этом: https://mywebcenter.ru/pervichnye-klyuchi-v-hibernate-3843/
}