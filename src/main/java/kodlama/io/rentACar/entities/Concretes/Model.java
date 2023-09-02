package kodlama.io.rentACar.entities.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "models")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // sen bir veri tabanı varlığısın
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne // g63,cla200,c180e sadece mercedes in modeli audinin değil o yüzden
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> carList;
}
