package com.example.burger_backend1.data;
import com.example.burger_backend1.data.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface BurgerRepository extends JpaRepository<Burger, Long>
    {
    }


