package auction.service;

import auction.model.User;

public interface UserService {

    User loadUserByUsername(String username);

}
