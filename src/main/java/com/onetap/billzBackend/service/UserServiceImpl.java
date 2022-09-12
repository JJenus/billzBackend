//package com.onetap.billzBackend.service;
//import com.onetap.billzBackend.model.AppUser;
//import com.onetap.billzBackend.model.Role;
//import com.onetap.billzBackend.repository.RoleRepository;
//import com.onetap.billzBackend.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class UserServiceImpl implements UserService, UserDetailsService {
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public AppUser registerUser(AppUser user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    public Role saveRole(Role role){
//        return roleRepository.save(role);
//    }
//
//    public void addRoleToUser(String email, String roleName){
//        AppUser user = userRepository.findByEmail(email);
//        user.getRoles().add(roleRepository.findByName(roleName));
//    }
//
//    public AppUser getUser(String email){
//        return userRepository.findByEmail(email);
//    }
//
//    public List<AppUser> getUsers(){
//        return userRepository.findAll();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        AppUser user = userRepository.findByEmail(email);
//        if (user == null){
//            throw new UsernameNotFoundException("User not found");
//        }
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//        user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        });
//
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
//    }
//}
