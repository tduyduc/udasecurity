package com.udacity.catpoint.security.service;

import com.udacity.catpoint.image.service.ImageService;
import com.udacity.catpoint.security.data.*;
import com.udacity.catpoint.security.service.SecurityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SecurityServiceTest {
  public SecurityServiceTest() {}

  @InjectMocks
  private SecurityService securityService;

  private final Sensor doorSensor = new Sensor("Sample door sensor", SensorType.DOOR);
  private final Sensor windowSensor = new Sensor("Sample window sensor", SensorType.WINDOW);
  private final Sensor motionSensor = new Sensor("Sample motion sensor", SensorType.MOTION);

  @Mock
  private SecurityRepository securityRepo;

  @Mock
  private ImageService imageService;

  @BeforeEach
  public void init() {
    this.securityService = new SecurityService(this.securityRepo, this.imageService);
  }

  @Test
  public void alarmArmedAndSensorActivated_toPendingAlarmStatus() {
    Mockito.when(this.securityRepo.getArmingStatus()).thenReturn(
      ArmingStatus.ARMED_HOME
    );
    this.securityService.changeSensorActivationStatus(this.doorSensor, true);
    Assertions.assertEquals(this.securityService.getAlarmStatus(), AlarmStatus.PENDING_ALARM);
  }
}
