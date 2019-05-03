package com.example.web;

import com.example.service.ResponseDtoManager;
import com.example.service.dto.IEppObjectResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 2019-04-12
 */
@RestController
public class AfnicController {

  private final ResponseDtoManager responseDtoManager;

  public AfnicController(ResponseDtoManager responseDtoManager) {
    this.responseDtoManager = responseDtoManager;
  }

  @GetMapping("/{type}")
  public IEppObjectResponseDto getDto(@PathVariable String type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

    Class<? extends IEppObjectResponseDto> responseDtoClass = responseDtoManager.getResponseDto(type);
    return responseDtoClass.getDeclaredConstructor().newInstance();
  }

}
