package crud.mvc.dao;

import crud.mvc.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class UserDAO {
    private static int PEOPLE_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++PEOPLE_COUNT, "Tom", 24, "tom@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Mike", 18, "mike@yahoo.com"));
        users.add(new User(++PEOPLE_COUNT, "Katy", 34, "katy@gmail.com"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }
}
