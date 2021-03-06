package internet.store.dao;

import internet.store.model.User;
import java.util.Optional;

public interface UserDao extends GenericDao<User, Long>,
        GenericGetDao<User, Long> {

    Optional<User> findByLogin(String login);
}
