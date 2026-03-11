import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emp_dept")
@Data
public class Employee {
    @Id
    private int eId;
    private String name;
    private String dept;

}
