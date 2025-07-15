package store;

import java.time.LocalDateTime;

public record StoreRecord(
        String empId,
        String empPw,
        String empName,
        LocalDateTime lastLogin,
        LocalDateTime lastLogout,
        Integer workMinute,
        Integer dailyPay
) {}
