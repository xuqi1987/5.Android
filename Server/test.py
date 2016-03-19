#! /usr/bin/python
# -*- coding:utf-8 -*-
from sensor import Sensor

import time
se = Sensor()
se.setup()

while True:
    #print se.get()
    time.sleep(0.1)