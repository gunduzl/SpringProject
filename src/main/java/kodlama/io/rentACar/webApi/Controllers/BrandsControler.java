package kodlama.io.rentACar.webApi.Controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.Bussiness.Abstracts.BrandService;
import kodlama.io.rentACar.Bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.Bussiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.Bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.Bussiness.responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsControler {
    private BrandService brandService;

    @Autowired
    public BrandsControler(BrandService brandService)
    {
        this.brandService = brandService;
    }

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getall(){
        return brandService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Valid CreateBrandRequest createBrandRequest){
        System.out.println(createBrandRequest.getName());
        this.brandService.add(createBrandRequest);
    }

    @GetMapping("/getByID/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return  brandService.getById(id);
    }

    @PutMapping
    public void UpdateBrandRequest(UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id ){
        this.brandService.delete(id);
    }
}
