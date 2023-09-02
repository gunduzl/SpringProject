package kodlama.io.rentACar.Bussiness.Concretes;

import kodlama.io.rentACar.Bussiness.Abstracts.ModelService;
import kodlama.io.rentACar.Bussiness.requests.CreateModelRequest;
import kodlama.io.rentACar.Bussiness.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.Bussiness.responses.GetAllModelsResponse;
import kodlama.io.rentACar.dataAccess.Abstracts.ModelRepository;
import kodlama.io.rentACar.entities.Concretes.Brand;
import kodlama.io.rentACar.entities.Concretes.Model;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<GetAllModelsResponse> getAll() {

            List<Model> modelsList = modelRepository.findAll();
            List<GetAllModelsResponse> getAllModelsResponseList = modelsList.stream()
                    .map(Model -> modelMapper.map(Model, GetAllModelsResponse.class))
                    .collect(Collectors.toList());
            return getAllModelsResponseList;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapper.map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
