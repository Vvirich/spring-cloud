package com.training.services.controller;

import com.training.services.CaptchaResponseDto;
import com.training.services.CaptchaValidate;
import com.training.services.model.Room;
import com.training.services.services.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/rooms")
@Api(value = "rooms", tags = ("rooms"))
public class RoomController {

    @Autowired
    private RoomService roomService;
    private static final String CAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";
    @Value("${captcha.secret.key}")
    private String captchaSecretKey; //TODO define server secret key in config file, when we get it
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping
    @ApiOperation(value = "Get all rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> findAllByRoomNumber(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        if (StringUtils.isNoneEmpty(roomNumber)) {
            return Collections.singletonList(this.roomService.findByRoomNumber(roomNumber));
        }
        return this.roomService.findAll();
    }

    @PostMapping(name = "/test")
    public void verifyCaptcha(@RequestParam(name = "g-recaptcha-response")String captchaResponse){
        final String verifyUrl = String.format(CAPTCHA_VERIFY_URL, captchaSecretKey, captchaResponse);
        final CaptchaResponseDto response = restTemplate.exchange(verifyUrl, HttpMethod.POST, null, CaptchaResponseDto.class).getBody();
        CaptchaValidate.validateCaptcha(Objects.requireNonNull(response));
        //TODO define what will be return if validation was success
    }
}
