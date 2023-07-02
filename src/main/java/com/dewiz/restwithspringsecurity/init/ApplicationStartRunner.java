package com.dewiz.restwithspringsecurity.init;

import com.dewiz.restwithspringsecurity.model.Account;
import com.dewiz.restwithspringsecurity.model.Employee;
import com.dewiz.restwithspringsecurity.model.Role;
import com.dewiz.restwithspringsecurity.repository.AccountRepository;
import com.dewiz.restwithspringsecurity.repository.JpaEmployeeRepository;
import com.dewiz.restwithspringsecurity.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final JpaEmployeeRepository jpaEmployeeRepository;
    private final AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        Role user = new Role(1L, "123", "ROLE_USER");
        Role admin = new Role(2L, "456", "ROLE_ADMIN");
        roleRepository.saveAll(List.of(user, admin));

        Employee employee = new Employee(1, "Ivan", "Ivanov", "ivanov@gmail.com");
        jpaEmployeeRepository.save(employee);

        Account account = new Account(1L, "junior", "123", true, false, false, false, Set.of(roleRepository.findByName("ROLE_USER")));
        accountRepository.save(account);
    }
}
