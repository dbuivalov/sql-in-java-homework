package tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import keys.PurchaseListKey;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(PurchaseListKey.class)
@Table(name = "PurchaseList")
public class PurchaseList {

    @Id
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Id
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    // Здесь применён класс составного ключа PurchaseListKey для поддержки
    // Это нужно, чтобы обращаться к полям таблицы БД в запросe hql в классе Main и получать результат, иначе будет ошибка
    // Подробно теория об этом: https://mywebcenter.ru/pervichnye-klyuchi-v-hibernate-3843/
}