package kodlama.io.rentACar.Bussiness.Abstracts;

import kodlama.io.rentACar.Bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.Bussiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.Bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.Bussiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.entities.Concretes.Brand;

import java.util.List;

public interface BrandService {
        List<GetAllBrandsResponse> getAll();
        void add (CreateBrandRequest createBrandRequest);
        void update(UpdateBrandRequest updateBrandRequest);
        GetByIdBrandResponse getById(int id);
        void delete(int id);
}
