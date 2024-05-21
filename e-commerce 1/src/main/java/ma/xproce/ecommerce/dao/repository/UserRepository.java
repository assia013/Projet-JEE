package ma.xproce.ecommerce.dao.repository;

import ma.xproce.ecommerce.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
