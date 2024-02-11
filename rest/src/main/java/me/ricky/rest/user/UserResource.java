package me.ricky.rest.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ricky.aggregate.common.dto.OffsetElementList;
import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.facade.UserFacade;
import me.ricky.aggregate.user.facade.dto.UserSearchQdo;
import me.ricky.aggregate.user.service.UserService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "유저 관리 API", description = "유저 관리 API")
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserResource implements UserFacade {
    private final UserService userService;

    // http://localhost:8080/swagger-ui/index.html#/
    @Override
    @GetMapping("{id}")
    @Operation(summary = "유저 단건 조회", description = "유저 단건 조회용")
    public User findById(
            @Parameter(description = "유저 ID", required = true, example = "uuid") @PathVariable("id") String id
    ) {
        return userService.findById(id);
    }

    @GetMapping
    @Override
    @Operation(summary = "유저 목록 조회", description = "유저 목록 조회용")
    public OffsetElementList<User> search(@ParameterObject UserSearchQdo qdo) {
        return userService.search(qdo);
    }
}
