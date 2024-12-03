package org.example;

import keys.LinkedPurchaseListKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import tables.LinkedPurchaseList;
import java.util.List;

/**
 * Задача создать таблицы в БД example_schema (указанную БД нужно создать вручную заранее) и заполнить их.
 * Метод getResult в классе Main должен быть закомменитрован.
 * Классы, которые будут маппиться (участвовать в маппинге) на соответствующие им таблицы в БД: Course, PurchaseList, Student, Subscription, Teacher.
 * Составные классы ключей: SubscriptionKey, PurchaseListKey.
 * hibernate.cfg.xml - конфигурационный файл в папке resources, в котором указана конфигурация по умолчанию.
 * Перед первым запуском метода main в классе Main, в конфигурационном файле указать режим create, после отработки программы указать update.
 * В БД появятся таблицы, заливаем в БД дамп.
 * Создаём классы LinkedPurchaseList, LinkedPurchaseListKey, а в конфигурационном файле добавляем маппинг класса LinkedPurchaseList.
 * Раскомментируем метод getResult, запускаем метод main.
 */

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration(); // экземпляр класса Configuration
        configuration.configure(); // конфигурирование указанного в hibernate.cfg.xml

        try (SessionFactory sessionFactory = configuration.buildSessionFactory(); // из полученной конфигурации получим фабрику сессий
             Session session = sessionFactory.openSession()) { // получим сессию

            // HQL-запрос для получения данных, необходимых для заполнения таблицы LinkedPurchaseList
            String hql = "select " +
                    "(select id from Student where name = studentName), " +
                    "(select id from Course where name = courseName) from PurchaseList";

            getResult(session,hql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getResult (Session session, String hql) {

        // Запишем данные в List массивов:
        List<Object[]> list = session.createQuery(hql).getResultList();

        // Вывод в консоль и заполнение таблицы LinkedPurchaseList:
        for (Object[] object : list) {
            System.out.println(object[0] + " - " + object[1]); // выведем в консоль результаты для наглядности

            // Весь дальнейший код должен находиться внутри транзакции:

            Transaction transaction = session.beginTransaction(); // открытие транзакции

            // для добавления записи в таблицу БД, на которую маппится класс LinkedPurchaseList, создаём экземпляр этого класса:
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            // задаём значения:
            linkedPurchaseList.setKey(new LinkedPurchaseListKey((int) object[0], (int) object[1]));

            session.save(linkedPurchaseList); // сохраняем созданный экземпляр методом .save()

            transaction.commit(); // закрытие транзакции
        }
    }
}