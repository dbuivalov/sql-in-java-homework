package tables;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import keys.SubscriptionKey;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionKey key;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    // Здесь применён класс составного ключа SubscriptionKey
    // Это нужно для заполнения таблицы, где нет явно указанного естественного ключа с id
    // Подробно теория об этом: https://mywebcenter.ru/pervichnye-klyuchi-v-hibernate-3843/
}