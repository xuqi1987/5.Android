#! /usr/bin/python
# -*- coding:utf-8 -*-
import RPi.GPIO as GPIO
import time

class Sensor:
    def __init__(self):
        self.value = 0
        self.start = 0
        self.count = 0

        pass

    def setup(self):
        GPIO.setmode(GPIO.BCM)
        GPIO.setup(14,GPIO.IN)
        pass

    def destory(self):
        GPIO.cleanup()
        pass

    def get(self):
        self.cout = self.count + 1
        ret = False

        if (GPIO.input(14) == GPIO.HIGH):
            self.value = self.value + 1

        if self.value > 3:
            ret = True
        else:
            ret = False

        if self.count > 10:
            self.count = 0
            self.value = 0

        return ret




