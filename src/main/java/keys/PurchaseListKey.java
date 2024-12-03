package keys;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PurchaseListKey implements Serializable {

    static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Column(name = "student_name")
    private String studentName;

    @Getter
    @Setter
    @Column(name = "course_name")
    private String courseName;

    // Это класс составного ключа
    // Подробно теория об этом: https://mywebcenter.ru/pervichnye-klyuchi-v-hibernate-3843/
}