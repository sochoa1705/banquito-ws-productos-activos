package ec.edu.espe.arquitectura.wsproductosactivos.repository;

import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanProductRepository extends MongoRepository<LoanProduct, String> {
    /*
    TODO
       * 1. Implementar el repositorio de LoanProductRepository
       * 2. Crear un método que busque por uniqueId
       * 3. Crear un método que busque el tipo de producto prestamo por uniqueId
       * 4. Crear un método que busque el tipo de producto prestamo por uniqueId y que esté activo
       * 5. Crear un método que busque el tipo de producto prestamo por uniqueId y que esté activo y que tenga un valor de interés entre minInterest y maxInterest
       * 6. Crear un método que me devuelva la tabla de amortización para un prestamo(Id)
    *  */
}
