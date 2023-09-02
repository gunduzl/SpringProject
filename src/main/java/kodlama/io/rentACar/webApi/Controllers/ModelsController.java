package kodlama.io.rentACar.webApi.Controllers;

import kodlama.io.rentACar.Bussiness.Abstracts.ModelService;
import kodlama.io.rentACar.Bussiness.requests.CreateModelRequest;
import kodlama.io.rentACar.Bussiness.responses.GetAllModelsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService modelService;

    @Autowired
    public ModelsController(ModelService modelService)
    {
        this.modelService = modelService;
    }

    @GetMapping("/getAll")
    public List<GetAllModelsResponse> getall(){
        return modelService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add( CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

}
