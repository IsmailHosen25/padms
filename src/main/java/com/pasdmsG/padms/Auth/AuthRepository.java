package com.pasdmsG.padms.Auth;

import com.pasdmsG.padms.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,Long> {
   boolean existsByPhone(Integer phone);
}
