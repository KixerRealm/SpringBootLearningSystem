//package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models;
//
//import lombok.Data;
//import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.enumerations.Role;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "course_users")
//public class User implements UserDetails {
//
//    @Id
//    private String username;
//
//    @Version
//    private Long version;
//
//    private String password;
//
//    private String name;
//
//    private String surname;
//
//    private boolean isAccountNonExpired = true;
//    private boolean isAccountNonLocked = true;
//    private boolean isCredentialsNonExpired = true;
//    private boolean isEnabled = true;
//
//    @Enumerated(value = EnumType.STRING)
//    private Role role;
//
//
//    @OneToMany
//    private List<Course> courses;
//
//    public User() {
//    }
//
//    public User(String username, String password, String name, String surname, Role role) {
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.surname = surname;
//        this.role = role;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singletonList(role);
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return isAccountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return isAccountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return isCredentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isEnabled;
//    }
//}
