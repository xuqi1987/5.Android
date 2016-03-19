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
        self.count = self.count + 1
        ret = False

        # 减少误差
        avg = 0
        l = []
        for i in  range(5):


            if (GPIO.input(14) == GPIO.HIGH):

                l.append('ON')
                avg = avg + 1
            else:
                avg = avg - 1

            time.sleep(0.1)


        print l
        l.clear
        if avg > 0:

            self.value = self.value + 1
            print "Baby maybe crying~"

        # 这么做也是为了减少误差
        if self.value > 3:
            ret = True
        else:
            ret = False

        if self.count > 15:
            print "Clear"
            self.count = 0
            self.value = 0

        return ret




