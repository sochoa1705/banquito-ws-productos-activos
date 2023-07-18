package ec.edu.espe.arquitectura.wsproductosactivos.repository;

import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;




public interface LoanProductRepository extends MongoRepository<LoanProduct, String> {

    LoanProduct findByUniqueKey(String uniqueKey);
    LoanProduct findByUniqueKeyAndState(String uniqueKey, String state);

    List<LoanProduct> findAll();
    
}
