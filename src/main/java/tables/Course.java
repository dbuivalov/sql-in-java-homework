package tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import others.CourseType;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int duration;

    @Column(columnDefinition = "enum('DESIGN', 'PROGRAMMING', 'MARKETING', 'MANAGEMENT', 'BUSINESS')" )
    @Enumerated(EnumType.STRING)
    private CourseType type;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;

    @Column(name = "students_count", nullable = true)
    private int studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;
}