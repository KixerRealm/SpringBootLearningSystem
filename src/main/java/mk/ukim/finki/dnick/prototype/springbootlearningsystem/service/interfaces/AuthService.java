package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.User;

public interface AuthService {
    User login(String username, String password);
}
