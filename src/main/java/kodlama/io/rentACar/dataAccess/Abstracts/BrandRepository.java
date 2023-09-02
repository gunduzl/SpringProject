package kodlama.io.rentACar.dataAccess.Abstracts;

//veri tabani ile iş yapaılıyorsa dao veya repository denir

import kodlama.io.rentACar.entities.Concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

        boolean existsByName(String name); // spring jpa keywords
}
