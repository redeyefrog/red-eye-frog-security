package org.redeyefrog.persistence.repository;

import org.redeyefrog.persistence.entity.SsoTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SsoTokenRepository extends JpaRepository<SsoTokenEntity, String> {
}
