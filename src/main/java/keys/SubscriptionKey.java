package keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class SubscriptionKey implements Serializable {

    static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;

    @Getter
    @Setter
    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;

    // Это класс составного ключа
    // Подробно теория об этом: https://mywebcenter.ru/pervichnye-klyuchi-v-hibernate-3843/
}