package kodlama.io.rentACar.Bussiness.Abstracts;

import kodlama.io.rentACar.Bussiness.requests.CreateModelRequest;
import kodlama.io.rentACar.Bussiness.responses.GetAllModelsResponse;


import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add (CreateModelRequest createModelRequest);
}
