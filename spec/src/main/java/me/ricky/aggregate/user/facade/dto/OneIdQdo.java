package me.ricky.aggregate.user.facade.dto;

import java.util.List;

public record OneIdQdo(List<String> sub, String email, String name) {
    
}
