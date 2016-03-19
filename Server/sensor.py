#! /usr/bin/python
# -*- coding:utf-8 -*-
import RPi.GPIO as GPIO
import time

class Sensor:
    def __init__(self):
        self.cry = False
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
        self.count = self.count + 1
        ret = False

        # 减少误差
        max_num = 1000
        l = []
        for i in range(max_num):

            if (GPIO.input(14) == GPIO.HIGH):

                l.append('ON')

        print ("%s / %s ")%(len(l),max_num)

        if len(l)> (max_num /2):
            self.cry = True
            print "Baby maybe crying~"


        if self.count > 5:
            print "Clear"
            self.count = 0
            self.cry = False

        return self.cry




