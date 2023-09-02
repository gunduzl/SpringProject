package kodlama.io.rentACar.Bussiness.Concretes;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.rentACar.Bussiness.Abstracts.BrandService;
import kodlama.io.rentACar.Bussiness.Rules.BrandBusinessRules;
import kodlama.io.rentACar.Bussiness.requests.CreateBrandRequest;
import kodlama.io.rentACar.Bussiness.requests.UpdateBrandRequest;
import kodlama.io.rentACar.Bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.Bussiness.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.Abstracts.BrandRepository;
import kodlama.io.rentACar.entities.Concretes.Brand;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service // bu sınıf bir bussiness nesnesidir
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private ModelMapper modelMapper;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brandsList = brandRepository.findAll();
        List<GetAllBrandsResponse> getAllBrandsResponseList = brandsList.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class))
                .collect(Collectors.toList());
        // without mapper
        //List<GetAllBrandsResponse> refactoredList = brandsList.stream()
                //.map(brand -> new GetAllBrandsResponse(brand.getId(), brand.getName()))
                //.collect(Collectors.toList());

        // different kind of mapper usage
        //List<GetAllBrandsResponse> getAllBrandsResponseList = brandsList.stream()
        //.map(brand -> modelMapper.map(brand, GetAllBrandsResponse.class))
                //.collect(Collectors.toList());
                //.map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());

        return getAllBrandsResponseList;
    }

    @Override
    public void add( CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapper.map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = modelMapper.map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
