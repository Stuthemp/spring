package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.TacoAppUser;

/**
 * todo Document type UserRepository
 */
@Repository
public interface UserRepository extends CrudRepository<TacoAppUser, Long> {

    TacoAppUser findByUsername(String username);

}
