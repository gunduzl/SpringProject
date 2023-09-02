package kodlama.io.rentACar.dataAccess.Abstracts;

import kodlama.io.rentACar.entities.Concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
