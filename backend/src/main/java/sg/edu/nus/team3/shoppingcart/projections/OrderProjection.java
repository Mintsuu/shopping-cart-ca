package sg.edu.nus.team3.shoppingcart.projections;

import java.time.LocalDate;
import java.time.LocalDateTime;

// @author: Jared Chua
// * Interface used for specific queries that either:
// * - Do not follow the format of the returned entity
// * - Have cascading return issues due to the mapping relationships
public interface OrderProjection {
    int getId();

    LocalDateTime getCreateAt();

    LocalDate getFulfilmentDate();

    String getStatus();

    String getPaymentMethod();

    int getUserId();
}