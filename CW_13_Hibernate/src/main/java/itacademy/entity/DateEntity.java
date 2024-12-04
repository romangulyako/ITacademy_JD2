package itacademy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@MappedSuperclass
public class DateEntity {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updateDate;
}
