package com.surbhikalra.healinghearts.repository;

import com.surbhikalra.healinghearts.model.Merchandise;
import com.surbhikalra.healinghearts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchandiseRepository extends JpaRepository<Merchandise, Long> {

}
