package kodlama.io.rentACar.entities.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "brands")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // sen bir veri tabanı varlığısın
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand") // mercedes.g63 - mercedes.cla200 mercedes.c180e onetomany
    private List<Model> models;


}
