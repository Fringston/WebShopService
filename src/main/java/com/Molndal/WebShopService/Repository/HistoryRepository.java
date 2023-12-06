package com.Molndal.WebShopService.Repository;

import com.Molndal.WebShopService.Models.History;
import com.Molndal.WebShopService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
List<History> findByUser(User user);
}