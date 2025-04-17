package sg.edu.nus.team3.shoppingcart.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.nus.team3.shoppingcart.model.Order;
import sg.edu.nus.team3.shoppingcart.projections.OrderProjection;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o.id as id, o.createAt as createAt, o.fulfilmentDate as fulfilmentDate, o.status as status, o.paymentMethod as paymentMethod, o.user.id as userId FROM Order o WHERE o.createAt BETWEEN :startDate AND :endDate")
    public Optional<List<OrderProjection>> findWeeklyOrders(@Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    // @Query("SELECT o.id as id, o.createAt as createAt, o.fulfilmentDate as
    // fulfilmentDate, o.status as status, o.paymentMethod as paymentMethod,
    // o.user.id as userId FROM Order o")
    // public Optional<List<OrderProjection>> findWeeklyOrders();
}
