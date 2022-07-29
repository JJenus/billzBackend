package com.onetap.billzBackend.repository;

import com.onetap.billzBackend.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PermissionRepository extends JpaRepository<Permission, Long> {
}
