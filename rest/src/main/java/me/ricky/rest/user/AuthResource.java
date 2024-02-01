package me.ricky.rest.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ricky.aggregate.user.domain.User;
import me.ricky.aggregate.user.facade.dto.LoginQdo;
import me.ricky.aggregate.user.facade.dto.UserRequest;
import me.ricky.aggregate.user.service.UserService;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthResource {

  private final UserService userService;

  /*
  * 회원가입
  * */
  @PostMapping("/signup")
  public User registerUser(@RequestBody UserRequest.Register req) {
    if(userService.existsByUsername(req.getEmail())) {
      throw new NoSuchElementException("유저가 존재합니다.");
    }

    return userService.registerUser(req);
  }

  /*
  *  로그인
  * */
  @PostMapping(path = "/signin")
  public AccessTokenResponse signin(@RequestBody LoginQdo loginQdo) {

    AccessTokenResponse response = userService.signin(loginQdo);
    return response;
  }
}