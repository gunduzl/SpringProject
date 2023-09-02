package kodlama.io.rentACar.Bussiness.responses;


import kodlama.io.rentACar.entities.Concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {
    private int id;
    private String name;


}
