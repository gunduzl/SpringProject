package kodlama.io.rentACar.Bussiness.Rules;

import kodlama.io.rentACar.core.utilities.exception.BusinessException;
import kodlama.io.rentACar.dataAccess.Abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
     public void checkIfBrandNameExists(String name){
         System.out.println("checkIfBrandNameExists" + name);
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand Name Already Exist");
        }


     }
}
